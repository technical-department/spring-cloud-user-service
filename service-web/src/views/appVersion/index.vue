<template>
  <div>
    <avue-crud :option="option" :table-loading="listLoading" :data="list" :page="page" @on-load="getList" @refresh-change="getList">
      <template slot="menuLeft">
        <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openBannerUpload">添加</el-button>
      </template>
      <template slot="status" slot-scope="scope">
        <el-tag v-if="scope.row.forceFlag == 0" type="success">不强制</el-tag>
        <el-tag v-else type="warning">强制</el-tag>
      </template>
      <template slot="menu" slot-scope="scope">
        <el-button size="small" type="text" icon="el-icon-delete" @click="handleDelete(scope.row.id)">删除</el-button>
      </template>
    </avue-crud>
    <el-dialog
      title="添加"
      :visible.sync="dialogVisible"
      width="30%"
      style="text-align: center;"
    >
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="版本号">
          <el-input v-model="form.version" />
        </el-form-item>
        <el-form-item label="是否强制">
          <el-select v-model="forceFlagValue" placeholder="请选择">
            <el-option
              v-for="item in forceFlagOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="app上传">
          <el-upload
            class="upload-demo"
            drag
            multiple
            action="http://www.zhishieducation.cn:40000/web/uplode/appUplode"
            :on-success="handleUplodeSuccess"
            :before-upload="beforeUpload"
            :file-list="fileList"
            :limit="1"
          >
            <i class="el-icon-upload" />
            <div class="el-upload__text">将文件拖到此处，或<em>点击上传</em></div>
          </el-upload>
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="confimAdd">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
import { tableOption } from '../../const/crud/appVersion/appVersion'
import { queryList, delById, addObj } from '@/api/appVersion'
export default {
  name: 'AppVersion',
  data() {
    return {
      option: tableOption,
      forceFlagOptions: [{
        value: '0',
        label: '不强制'
      }, {
        value: '1',
        label: '强制'
      }],
      forceFlagValue: undefined,
      page: {
        total: 0,
        currentPage: 1,
        pageSize: 20,
        isAsc: false
      },
      list: [],
      listLoading: true,
      dialogVisible: false,
      uplodeUrl: undefined,
      form: {},
      fileList: []
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
    handleDelete(id) {
      delById(id).then(res => {
        this.$notify({
          title: '成功',
          message: '删除成功',
          type: 'success',
          duration: 1500
        })
        this.getList(this.page)
      })
    },
    openBannerUpload() {
      this.dialogVisible = true
      this.uplodeUrl = undefined
      this.form = {}
      this.fileList = []
    },
    handleUplodeSuccess(res, file) {
      this.uplodeUrl = res.data
    },
    beforeUpload(file) {
      console.log(file.type)
      return true;
    },
    confimAdd() {
      if (this.form.version === undefined) {
        this.$message.error('请填写版本号')
        return
      }
      if (this.forceFlagValue === undefined) {
        this.$message.error('请选择是否强制更新')
        return
      }
      if (this.uplodeUrl === undefined || this.uplodeUrl === '') {
        this.$message.error('请先上传app')
        return
      }
      addObj(this.uplodeUrl, this.form.version, this.forceFlagValue).then(res => {
        this.dialogVisible = false
        this.getList(this.page)
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
