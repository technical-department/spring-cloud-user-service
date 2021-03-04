<template>
  <div>
    <avue-crud :option="option" :table-loading="listLoading" :data="list" :page="page" @on-load="getList" @refresh-change="getList">
      <template slot="menuLeft">
        <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openBannerUpload">添加</el-button>
      </template>
      <template slot="fileType" slot-scope="scope">
        <el-tag v-if="scope.row.fileType == 0" type="success">app使用</el-tag>
        <el-tag v-if="scope.row.fileType == 1">报道入学</el-tag>
        <el-tag v-if="scope.row.fileType == 2" type="warning">历年专业目录</el-tag>
      </template>
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
    <el-dialog
      title="添加"
      :visible.sync="dialogVisible"
      width="30%"
      style="text-align: center;"
    >
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="标题">
          <el-input v-model="form.title" />
        </el-form-item>
        <el-form-item label="文件类型">
          <el-select v-model="form.fileType" placeholder="请选择文件类型">
            <el-option label="app使用" value="0" />
            <el-option label="报道入学" value="1" />
            <el-option label="历年专业目录" value="2" />
          </el-select>
        </el-form-item>
        <el-form-item label="文件上传">
          <el-upload
            class="upload-demo"
            drag
            multiple
            action="http://www.zhishieducation.cn:40000/web/uplode/uplode"
            :on-success="handleVideoUplodeSuccess"
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
import { tableOption } from '@/const/crud/nmet/file'
import { videoList, updateStatus, delById, addObj } from '@/api/nmet/file'
export default {
  name: 'PdfManager',
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
      dialogVisible: false,
      uplodeVideoUrl: undefined,
      form: {},
      fileList: []
    }
  },
  computed: {
  },
  methods: {
    getList(page, params) {
      this.listLoading = true
      videoList(Object.assign({
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
      this.uplodeVideoUrl = undefined
      this.form = {}
      this.fileList = []
    },
    handleVideoUplodeSuccess(res, file) {
      this.uplodeVideoUrl = res.data
    },
    confimAdd() {
      if (this.form.title === undefined || this.form.title === '') {
        this.$message.error('请填写标题')
        return
      }
      if (this.form.fileType === undefined) {
        this.$message.error('请选择文件类型')
        return
      }
      if (this.uplodeVideoUrl === undefined || this.uplodeVideoUrl === '') {
        this.$message.error('请先上传文件')
        return
      }
      addObj(this.form.title, this.form.fileType, this.uplodeVideoUrl).then(res => {
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
