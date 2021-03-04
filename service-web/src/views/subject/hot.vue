<template>
  <div>
    <avue-crud :option="option" :table-loading="listLoading" :data="list" :page="page" @on-load="getList" @refresh-change="getList">
      <template slot="menuLeft">
        <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openBannerUpload">添加</el-button>
      </template>
      <template slot="avatar" slot-scope="scope">
        <el-avatar :size="100" :src="scope.row.avatar" @error="errorHandler">
          <img src="https://cube.elemecdn.com/e/fd/0fc7d20532fdaf769a25683617711png.png">
        </el-avatar>
      </template>
      <template slot="collegeMainType" slot-scope="scope">
        <el-tag v-if="scope.row.collegeMainType == 0" type="success">本科</el-tag>
        <el-tag v-else type="warning">专科</el-tag>
      </template>
      <template slot="isArts" slot-scope="scope">
        <el-tag v-if="scope.row.isArts == 0" type="success">文科</el-tag>
        <el-tag v-else type="success">理科</el-tag>
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
        <el-form-item label="专业">
          <el-cascader :props="subjectProps" v-model="tempSubject"></el-cascader>
        </el-form-item>
        <el-form-item label="描述">
          <el-input
            type="textarea"
            :rows="3"
            placeholder="请输入内容"
            v-model="tempContent">
          </el-input>
        </el-form-item>
        <el-form-item label="文理科">
          <el-select v-model="tempIsArts" placeholder="请选择文理科">
            <el-option label="文科" value="0" />
            <el-option label="理科" value="1" />
          </el-select>
        </el-form-item>
        <el-form-item label="本专科">
          <el-select v-model="tempMainType" placeholder="请选择本专科">
            <el-option label="本科" value="0" />
            <el-option label="专科" value="1" />
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
        <el-form-item label="PDF上传">
          <el-upload
            class="upload-demo"
            drag
            multiple
            action="http://www.zhishieducation.cn:40000/web/uplode/uplode"
            :on-success="handleVideoUplodeSuccess"
            :before-upload="beforePdfUpload"
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
import { tableOption } from '../../const/crud/subject/subjectHot'
import { getClassifyList, getTopListByClassifyName, getSubjectList, addObj, queryList, delById } from '@/api/subject/subjectHot'
export default {
  name: 'SubjectHot',
  data() {
    return {
      option: tableOption,
      tempSubject: undefined,
      tempContent: undefined,
      tempIsArts: undefined,
      tempMainType: undefined,
      uplodeFlag: false,
      subjectProps: {
        lazy: true,
        lazyLoad(node, resolve) {
          const { level } = node
          if (level === 0) {
            getClassifyList().then(res => {
              const nodes = res.data.map(item => ({
                value: item,
                label: item,
                leaf: level >= 2
              }))
              resolve(nodes)
            })
          }
          if (level === 1) {
            getTopListByClassifyName(node.value).then(res => {
              const nodes = res.data.map(item => ({
                value: item,
                label: item,
                leaf: level >= 2
              }))
              resolve(nodes)
            })
          }
          if (level === 2) {
            getSubjectList(node.parent.value, node.value).then(res => {
              const nodes = res.data.map(item => ({
                value: item.id,
                label: item.subjectName,
                leaf: level >= 2
              }))
              resolve(nodes)
            })
          }
        }
      },
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
    errorHandler() {
      return true
    },
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
      this.uplodeImgUrl = undefined
      this.imageUrl = undefined
      this.uplodeVideoUrl = undefined
      this.tempSubject = undefined
      this.tempContent = undefined
      this.tempIsArts = undefined
      this.tempMainType = undefined
      this.uplodeFlag = false
      this.form = {}
      this.fileList = []
    },
    handleUplodeSuccess(res, file) {
      this.uplodeFlag = false
      this.uplodeImgUrl = res.data
      this.imageUrl = URL.createObjectURL(file.raw)
    },
    handleVideoUplodeSuccess(res, file) {
      this.uplodeFlag = false
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
      if ((isJPG || isPNG) && isLt2M) {
        this.uplodeFlag = true
        return true
      } else {
        return false
      }
    },
    beforePdfUpload() {
      this.uplodeFlag = true
      return true
    },
    confimAdd() {
      if (this.uplodeFlag) {
        this.$message.error('请等待上传完成')
        return
      }
      if (this.tempSubject === undefined) {
        this.$message.error('请选择专业')
        return
      }
      if (this.tempContent === undefined) {
        this.$message.error('请输入描述')
        return
      }
      if (this.tempIsArts === undefined) {
        this.$message.error('请选择文理科')
        return
      }
      if (this.tempMainType === undefined) {
        this.$message.error('请选择本专科')
        return
      }
      if (this.uplodeImgUrl === undefined || this.uplodeImgUrl === '') {
        this.$message.error('请先上传图片')
        return
      }
      if (this.uplodeVideoUrl === undefined || this.uplodeVideoUrl === '') {
        this.$message.error('请先上传PDF文件')
        return
      }
      addObj(this.tempSubject[2], this.uplodeImgUrl, this.tempContent, this.uplodeVideoUrl, this.tempMainType, this.tempIsArts).then(res => {
        // eslint-disable-next-line eqeqeq
        if (res.data != undefined) {
          this.$notify({
            title: '失败',
            message: '此专业已添加过',
            type: 'warning',
            duration: 2000
          })
        } else {
          this.dialogVisible = false
          this.$notify({
            title: '成功',
            message: '处理成功',
            type: 'success',
            duration: 2000
          })
          this.getList(this.page)
        }
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
