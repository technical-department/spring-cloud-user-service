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
      <template slot="status" slot-scope="scope">
        <el-tag v-if="scope.row.status == 0" type="success">启用</el-tag>
        <el-tag v-else type="warning">禁用</el-tag>
      </template>
      <template slot="menu" slot-scope="scope">
        <el-button v-if="scope.row.status == 1" size="small" type="text" icon="el-icon-edit" @click="handleChangeStatus(scope.row.id,0)">启用</el-button>
        <el-button v-if="scope.row.status == 0" size="small" type="text" icon="el-icon-edit" @click="handleChangeStatus(scope.row.id,1)">禁用</el-button>
        <el-button size="small" type="text" icon="el-icon-delete" @click="handleDelete(scope.row.id)">删除</el-button>
      </template>
    </avue-crud>
  </div>
</template>
<script>
import { tableOption } from '../../const/crud/msgnotify/msgnotify'
import { msgList, updateStatus, delMsgnotify, addMsgnotify } from '@/api/msgnotify'
export default {
  name: 'Msgnotify',
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
      msgList(Object.assign({
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
    },
    handleDelete(id) {
      delMsgnotify(id).then(res => {
        this.$notify({
          title: '成功',
          message: '删除成功',
          type: 'success',
          duration: 1500
        })
        this.getList(this.page)
      })
    },
    handleAdd(row, done, loading) {
      addMsgnotify(row.msg, row.status, row.redirectUrl).then(res => {
        this.getList(this.page)
        done()
        this.$notify({
          title: '成功',
          message: '添加成功',
          type: 'success',
          duration: 1500
        })
      }).catch(() => {
        loading()
      })
    }
  }
}
</script>
<style>
</style>
