<template>
  <div style="margin-top: 20px;">
    <avue-crud :option="option" :table-loading="listLoading" :data="list" :page="page" @on-load="getList" @refresh-change="getList">
      <template slot="menuLeft">
        <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openUpload">添加</el-button>
      </template>
      <template slot="imgUrl" slot-scope="scope">
        <el-avatar :size="100" :src="scope.row.imgUrl" shape="square" @error="errorHandler">
          <img src="https://cube.elemecdn.com/e/fd/0fc7d20532fdaf769a25683617711png.png">
        </el-avatar>
      </template>
      <template slot="menu" slot-scope="scope">
        <el-button size="small" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)">编辑</el-button>
        <el-divider direction="vertical" />
        <el-button size="small" type="text" icon="el-icon-delete" @click="handleDelete(scope.row.id)">删除</el-button>
      </template>
    </avue-crud>
    <el-dialog
      title="添加"
      :visible.sync="dialogVisible"
      width="30%"
      style="text-align: center;"
    >
      <el-form ref="form" label-width="80px">
        <el-form-item label="图片标题">
          <el-input v-model="title" />
        </el-form-item>
        <el-form-item label="所属校区">
          <el-input v-model="area" />
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
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="confimAdd">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>
<script>
import { tableOption } from '@/const/crud/university/scenery'
import { queryList, delById, addObj } from '@/api/university/universityScenery'
export default {
  name: 'UniversityScenery',
  data() {
    return {
      title: undefined,
      area: undefined,
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
      uplodeUrl: undefined,
      imageUrl: undefined,
      tempId: undefined,
      universityId: undefined
    }
  },
  computed: {
  },
  created() {
    this.universityId = this.$route.query.id
  },
  methods: {
    errorHandler() {
      return true
    },
    getList(page, params) {
      this.listLoading = true
      queryList(Object.assign({
        current: page.currentPage,
        size: page.pageSize,
        fkUniversityId: this.universityId
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
    handleUpdate(row) {
      this.dialogVisible = true
      this.title = row.title
      this.area = row.area
      this.uplodeUrl = row.imgUrl
      this.imageUrl = row.imgUrl
      this.tempId = row.id
    },
    openUpload() {
      this.dialogVisible = true
      this.uplodeUrl = undefined
      this.imageUrl = undefined
      this.title = undefined
      this.area = undefined
      this.tempId = undefined
    },
    handleUplodeSuccess(res, file) {
      this.uplodeFlag = false
      this.uplodeUrl = res.data
      this.imageUrl = URL.createObjectURL(file.raw)
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
      if (this.uplodeFlag) {
        this.$message.error('请等待上传完成')
        return
      }
      if (this.title === undefined) {
        this.$message.error('请填写图片标题')
        return
      }
      if (this.area === undefined) {
        this.$message.error('请填写所属校区')
        return
      }
      if (this.uplodeUrl === undefined || this.uplodeUrl === '') {
        this.$message.error('请先上传图片')
        return
      }
      addObj(this.tempId, this.universityId, this.title, this.area, this.uplodeUrl).then(res => {
        if (this.tempId === undefined || this.tempId === null) {
          this.$notify({
            title: '成功',
            message: '添加成功',
            type: 'success',
            duration: 1500
          })
        } else {
          this.$notify({
            title: '成功',
            message: '修改成功',
            type: 'success',
            duration: 1500
          })
        }
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
