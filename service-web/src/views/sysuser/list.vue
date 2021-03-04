<template>
  <div style="margin-top: 20px;">
    <avue-crud :option="option" :table-loading="listLoading" :data="list" :page="page" @search-change="searchChange" @on-load="getPage" @refresh-change="getPage">
      <template slot="menu" slot-scope="scope">
        <el-button size="small" type="text" icon="el-icon-edit" @click="handleIRole(scope.row.userCode)">编辑</el-button>
      </template>
    </avue-crud>

    <el-dialog
      title="设置角色"
      :visible.sync="dialogVisible"
      width="60%"
    >
      <template>
        <el-transfer
          filterable
          :filter-method="filterMethod"
          filter-placeholder="关键字搜索"
          v-model="value"
          :data="data"
          :titles="['未绑定角色', '已绑定角色']">
        </el-transfer>
      </template>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="confim">确 定</el-button>
      </span>
    </el-dialog>

  </div>
</template>
<script>
  import { tableOption } from '@/const/crud/sysuser/sysuser'
  import {setRole, getByUserCode, queryPage} from '@/api/sysuser/sysuser'
  import { transferList } from '@/api/sysrole/sysrole'
  export default {
    name: 'Sysrole',
    data() {
      return {
        option: tableOption,
        page: {
          total: 0,
          currentPage: 1,
          pageSize: 20,
          isAsc: false
        },
        uplodeFlag: false,
        list: [],
        listLoading: true,
        dialogVisible: false,
        dialogPrecentVisible: false,
        progressStatus: undefined,
        progressNum: 0,
        uplodeUrl: undefined,
        form: {},
        fileList: [],
        userCode: undefined,
        data: [],
        search: [],
        value: [],
        filterMethod(query, item) {
          return item.search.indexOf(query) > -1;
        }
      }
    },
    computed: {
    },
    methods: {
      handleIRole(userCode) {
        this.dialogVisible = true
        this.userCode = userCode;
        this.value = []
        this.data = []
        getByUserCode(userCode).then(res => {
          this.value = res.data
        })
        transferList().then(res => {
          res.data.forEach((ele, index) => {
            this.data.push({
              label: ele.roleName,
              key: ele.roleCode,
              search: ele.roleName
            });
          })
        })
      },
      searchChange(params) {
        this.tempParams = params
        this.getPage({ currentPage: 1, pageSize: 20 }, params)
      },
      getPage(page, params) {
        // eslint-disable-next-line eqeqeq
        if (params == undefined && this.tempParams != undefined) {
          params = this.tempParams
        }
        this.listLoading = true
        queryPage(Object.assign({
          current: page.currentPage,
          size: page.pageSize
        }, params)).then(res => {
          this.list = res.data.records
          this.page.total = res.data.total
          this.listLoading = false
        })
      },
      confim() {
        let params = {}
        params.userCode = this.userCode
        params.roleCodes = this.value

        setRole(params).then(res => {
          this.$notify({
            title: '成功',
            message: '设置成功',
            type: 'success',
            duration: 1500
          })
          this.dialogVisible = false
        })
      }
    }
  }
</script>
<style>
  .avatar-uploader .el-upload {
    border: 1px dashed #d9d9d9;
    border-radius: 6px;
    cursor: pointer;
    position: relative;
    overflow: hidden;
  }
  .avatar-uploader .el-upload:hover {
    border-color: #409EFF;
  }
  .avatar-uploader-icon {
    font-size: 28px;
    color: #8c939d;
    width: 178px;
    height: 178px;
    line-height: 178px;
    text-align: center;
  }
  .avatar {
    width: 178px;
    height: 178px;
    display: block;
  }
</style>
