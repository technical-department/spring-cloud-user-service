<template>
  <div>
    <avue-crud :option="option"
               :table-loading="listLoading"
               :data="list"
               :page="page"
               v-model="form"
               @on-load="getList"
               @row-save="handleAdd"
               @refresh-change="getList">
      <template slot="imgUrl1" slot-scope="scope">
        <span v-if="scope.row.imgUrl1"><img :src="scope.row.imgUrl1" style="max-height: 200px;max-width: 200px;"></span>
      </template>
      <template slot="imgUrl2" slot-scope="scope">
        <span v-if="scope.row.imgUrl2"><img :src="scope.row.imgUrl2" style="max-height: 200px;max-width: 200px;"></span>
      </template>
      <template slot="imgUrl3" slot-scope="scope">
        <span v-if="scope.row.imgUrl3"><img :src="scope.row.imgUrl3" style="max-height: 200px;max-width: 200px;"></span>
      </template>
      <template slot="status" slot-scope="scope">
        <el-tag v-if="scope.row.status == 0" type="warning">未处理</el-tag>
        <el-tag v-else  type="success">已处理</el-tag>
      </template>
      <template slot="menu" slot-scope="scope">
        <el-button v-if="scope.row.status == 0" size="small" type="text" icon="el-icon-edit" @click="handleChangeStatus(scope.row.id,1)">处理</el-button>
      </template>
    </avue-crud>
  </div>
</template>
<script>
import { tableOption } from '../../const/crud/userFeedBack/userFeedBack'
import { queryList, updateStatus } from '@/api/userFeedBack'
export default {
  name: 'UserFeedBack',
  data() {
    return {
      option: tableOption,
      page: {
        total: 0,
        currentPage: 1,
        pageSize: 20,
        isAsc: false
      },
      form: {},
      list: [],
      listLoading: true
    }
  },
  computed: {
  },
  methods: {
    getList(page, params) {
      this.listLoading = true
      queryList(Object.assign({
        current: page.currentPage,
        size: page.pageSize
      }, params)).then(res => {
        this.list = res.data.records
        this.page.total = res.data.total
        this.listLoading = false
      })
    },
    handleChangeStatus(id, status) {
      updateStatus(id, status).then(res => {
        this.$notify({
          title: '成功',
          message: '修改成功',
          type: 'success',
          duration: 1500
        })
        this.getList(this.page)
      })
    }
  }
}
</script>
<style>
</style>
