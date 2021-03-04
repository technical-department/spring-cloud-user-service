<template>
  <div>
    <avue-crud :option="option" :table-loading="listLoading" :data="list" :page="page" @on-load="getList" @refresh-change="getList">
      <template slot="menuLeft">
        <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openBannerUpload">添加</el-button>
      </template>
      <template slot="imgUrl" slot-scope="scope">
        <span><img :src="scope.row.imgUrl" style="max-height: 200px;"></span>
      </template>
      <template slot="status" slot-scope="scope">
        <el-tag v-if="scope.row.status == 0" type="success">启用</el-tag>
        <el-tag v-else type="warning">禁用</el-tag>
      </template>
      <template slot="videoType" slot-scope="scope">
        <el-tag v-if="scope.row.videoType == 0" type="success">APP介绍</el-tag>
        <el-tag v-if="scope.row.videoType == 1" type="warning">推荐视频</el-tag>
        <el-tag v-if="scope.row.videoType == 2" type="info">专业视频</el-tag>
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
          <el-input v-model="form.msg" />
        </el-form-item>
        <el-form-item label="视频类型">
          <el-select v-model="form.videoType" placeholder="请选择视频类型">
            <el-option label="APP介绍" value="0" />
            <el-option label="推荐视频" value="1" />
            <el-option label="专业视频" value="2" />
          </el-select>
        </el-form-item>
        <el-form-item label="图片上传">
          <el-upload
            class="avatar-uploader"
            action="http://www.zhishieducation.cn:40000/web/uplode/uplode"
            :show-file-list="false"
            :on-success="handleUplodeSuccess"
            :before-upload="beforeUpload"
          >
            <img v-if="imageUrl" :src="imageUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon" />
          </el-upload>
        </el-form-item>
        <el-form-item label="视频上传">
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
import { tableOption } from '../../const/crud/videoManager/videoManager'
import { videoList, updateStatus, delById, addObj } from '@/api/videoManager'
export default {
  name: 'VideoManager',
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
      imageUrl: undefined,
      uplodeImgUrl: undefined,
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
      this.uplodeImgUrl = undefined
      this.imageUrl = undefined
      this.uplodeVideoUrl = undefined
      this.form = {}
      this.fileList = []
    },
    handleUplodeSuccess(res, file) {
      this.uplodeImgUrl = res.data
      this.imageUrl = URL.createObjectURL(file.raw)
    },
    handleVideoUplodeSuccess(res, file) {
      this.uplodeVideoUrl = res.data
    },
    beforeUpload(file) {
      const isJPG = file.type === 'image/jpeg'
      const isPNG = file.type === 'image/png'
      const isLt2M = file.size / 1024 / 1024 < 2

      if (!(isJPG || isPNG)) {
        this.$message.error('上传图片只能是 JPG 或 PNG 格式!')
      }
      if (!isLt2M) {
        this.$message.error('上传图片大小不能超过 2MB!')
      }
      return (isJPG || isPNG) && isLt2M
    },
    confimAdd() {
      if (this.form.videoType === undefined) {
        this.$message.error('请选择视频类型')
        return
      }
      if (this.form.videoType === '1' || this.form.videoType === '2') {
        if (this.form.msg === undefined || this.form.msg === '') {
          this.$message.error('请填写标题')
          return
        }
      }
      if (this.uplodeImgUrl === undefined || this.uplodeImgUrl === '') {
        this.$message.error('请先上传图片')
        return
      }
      if (this.uplodeVideoUrl === undefined || this.uplodeVideoUrl === '') {
        this.$message.error('请先上传视频文件')
        return
      }
      addObj(this.uplodeImgUrl, this.uplodeVideoUrl, this.form.msg, this.form.videoType).then(res => {
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
