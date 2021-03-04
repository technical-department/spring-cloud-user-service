<template>
  <div>
    <avue-crud :option="option" :table-loading="listLoading" :data="list" :page="page" @on-load="getList" @refresh-change="getList">
      <template slot="menuLeft">
        <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openBannerUpload">添加</el-button>
      </template>
      <template slot="imgUrl" slot-scope="scope">
        <span><img :src="scope.row.imgUrl" style="max-height: 200px;max-width: 200px;"></span>
      </template>
      <template slot="status" slot-scope="scope">
        <el-tag v-if="scope.row.status == 0" type="success">启用</el-tag>
        <el-tag v-else type="warning">禁用</el-tag>
      </template>
      <template slot="imgType" slot-scope="scope">
        <el-tag v-if="scope.row.imgType == 0" type="success">首页</el-tag>
        <el-tag v-if="scope.row.imgType == 1" type="success">师兄师姐说专业</el-tag>
      </template>
      <template slot="menu" slot-scope="scope">
        <el-button v-if="scope.row.status == 1" size="small" type="text" icon="el-icon-edit" @click="handleChangeStatus(scope.row.id,0)">启用</el-button>
        <el-button v-if="scope.row.status == 0" size="small" type="text" icon="el-icon-edit" @click="handleChangeStatus(scope.row.id,1)">禁用</el-button>
        <el-button size="small" type="text" icon="el-icon-delete" @click="handleDelete(scope.row.id)">删除</el-button>
      </template>
    </avue-crud>
    <el-dialog
      title="上传"
      :visible.sync="dialogVisible"
      width="30%"
      style="text-align: center;"
    >
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="banner类型">
          <el-select v-model="imgType" placeholder="请选择banner类型">
            <el-option label="首页banner" value="0" />
            <el-option label="师兄师姐说专业banner" value="1" />
          </el-select>
        </el-form-item>
        <el-form-item label="图片上传">
          <el-upload
            class="avatar-uploader"
            action="http://www.zhishieducation.cn:40000/web/uplode/uplode"
            :show-file-list="false"
            :on-success="handleUplodeSuccess"
            :before-upload="beforeUpload">
            <img v-if="imageUrl" :src="imageUrl" class="avatar">
            <i v-else class="el-icon-plus avatar-uploader-icon"></i>
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
import { tableOption } from '../../const/crud/banner/banner'
import { bannerList, updateStatus, delBanner, addBanner } from '@/api/banner'
export default {
  name: 'Banner',
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
      imgType: undefined,
      uplodeImgUrl: undefined,
      form:{}
    }
  },
  computed: {
  },
  methods: {
    getList(page, params) {
      this.listLoading = true
      bannerList(Object.assign({
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
      delBanner(id).then(res => {
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
      this.imgType = undefined
    },
    handleUplodeSuccess(res, file) {
      this.uplodeImgUrl = res.data
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
      if (this.imgType === undefined){
        this.$message.error('请选择banner类型')
      } else if (this.uplodeImgUrl === undefined || this.uplodeImgUrl === '') {
        this.$message.error('请先上传图片')
      } else {
        addBanner(this.imgType, this.uplodeImgUrl).then(res => {
          this.dialogVisible = false
          this.getList(this.page)
        })
      }
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
