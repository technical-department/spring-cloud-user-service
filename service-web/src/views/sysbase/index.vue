<template>
  <div style="margin-top: 20px;">
    <avue-crud :option="option" :table-loading="listLoading" :data="list" :page="page" @search-change="searchChange" @on-load="getPage" @refresh-change="getPage">
      <template slot="menuLeft">
        <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openUpload">添加</el-button>
      </template>
      <template slot="menu" slot-scope="scope">
        <el-button size="small" type="text" icon="el-icon-edit" @click="handleIntroduce(scope.row.id)">编辑</el-button>
        <el-button size="small" type="text" icon="el-icon-delete" @click="handleDelete(scope.row.id)">删除</el-button>
      </template>
    </avue-crud>

    <el-dialog
      title="添加"
      :visible.sync="dialogVisible"
      width="60%"
      style="text-align: center;"
    >
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="系统名称">
          <el-input v-model="systemName"/>
        </el-form-item>
        <el-form-item label="系统类型">
          <el-select v-model="systemType" placeholder="请选择" style="width:100%">
            <el-option
              v-for="item in systemTypes"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="首页地址">
          <el-input v-model="indexUrl"/>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="confim">确 定</el-button>
      </span>
    </el-dialog>

  </div>
</template>
<script>
  import { tableOption } from '@/const/crud/sysbase/sysbase'
  import {queryList, delById, addObj, checkPrecent, queryPage} from '@/api/sysbase/sysbase'
  import {editObj} from "@/api/sysbase/sysbase";
  export default {
    name: 'Sysbase',
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
        tempParams: undefined,
        systemName: undefined,
        systemTypes: [{
          value: '1',
          label: '内部系统'
        }, {
          value: '2',
          label: '外部系统'
        }],
        systemType: undefined,
        indexUrl: undefined

      }
    },
    computed: {
    },
    methods: {
      handleIntroduce(id) {
        this.$router.push({ path: '/university/universityMajorIntroduce/index', query: { id: id }})
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
      handleDelete(id) {
        delById(id).then(res => {
          this.$notify({
            title: '成功',
            message: '删除成功',
            type: 'success',
            duration: 1500
          })
          this.getPage(this.page)
        })
      },
      openUpload() {
        this.dialogVisible = true
        this.uplodeUrl = undefined
        this.form = {}
        this.fileList = []
      },
      handleUplodeSuccess(res, file) {
        this.uplodeFlag = false
        this.uplodeUrl = res.data
      },
      confim() {
        if (!this.systemName) {
          this.$message.error('系统名称不能为空')
          return
        }
        if (!this.systemType) {
          this.$message.error('系统类型不能为空')
          return
        }
        if (!this.indexUrl) {
          this.$message.error('首页地址不能为空')
          return
        }

        let params = {}
        params.id = this.id
        params.systemName = this.systemName
        params.systemType = this.systemType
        params.indexUrl = this.indexUrl

        editObj(params).then(res => {
          this.$notify({
            title: '成功',
            message: '编辑成功',
            type: 'success',
            duration: 1500
          })
          this.dialogVisible = false
          this.searchChange()
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
