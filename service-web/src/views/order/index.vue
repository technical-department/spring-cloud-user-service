<template>
  <div>
    <avue-crud :option="option" :table-loading="listLoading" :data="list" :page="page" @search-change="searchChange" @on-load="getList" @refresh-change="getList">
      <template slot="payType" slot-scope="scope">
        <el-tag v-if="scope.row.payType == 0" type="success">微信</el-tag>
        <el-tag v-if="scope.row.payType == 1" type="warning">支付宝</el-tag>
      </template>
    </avue-crud>
  </div>
</template>
<script>
import { tableOption } from '../../const/crud/order/order'
import { pageList } from '@/api/order/order'
export default {
  name: 'OrderList',
  data() {
    return {
      option: tableOption,
      page: {
        total: 0,
        currentPage: 1,
        pageSize: 20,
        isAsc: false
      },
      list: [],
      listLoading: true,
      form: {},
      fileList: [],
      tempParams: undefined
    }
  },
  computed: {
  },
  methods: {
    searchChange(params) {
      this.tempParams = params
      this.getList({ currentPage: 1, pageSize: 20 }, params)
    },
    getList(page, params) {
      // eslint-disable-next-line eqeqeq
      if (params == undefined && this.tempParams != undefined) {
        params = this.tempParams
      }
      this.listLoading = true
      pageList(Object.assign({
        current: page.currentPage,
        size: page.pageSize
      }, params)).then(res => {
        this.list = res.data.records
        this.page.total = res.data.total
        this.listLoading = false
      })
    }
  }
}
</script>
<style>
</style>
