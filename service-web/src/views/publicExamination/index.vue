<template>
  <div>
    <avue-crud :option="option" :table-loading="listLoading" :data="list" :page="page" @on-load="getList" @refresh-change="getList">
      <template slot="menuLeft">
        <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openBannerUpload">添加</el-button>
      </template>
      <template slot="fkProviceId" slot-scope="scope">
        <el-tag v-if="scope.row.fkProviceId == 1" type="success">北京市</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 2" type="success">天津市</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 3" type="success">上海市</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 4" type="success">重庆市</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 5" type="success">河北省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 6" type="success">山西省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 7" type="success">辽宁省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 8" type="success">吉林省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 9" type="success">黑龙江省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 10" type="success">江苏省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 11" type="success">浙江省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 12" type="success">安徽省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 13" type="success">福建省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 14" type="success">江西省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 15" type="success">山东省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 16" type="success">河南省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 17" type="success">湖北省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 18" type="success">湖南省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 19" type="success">广东省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 20" type="success">海南省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 21" type="success">四川省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 22" type="success">贵州省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 23" type="success">云南省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 24" type="success">陕西省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 25" type="success">甘肃省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 26" type="success">青海省</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 27" type="success">西藏自治区</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 28" type="success">广西壮自治区</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 29" type="success">内蒙古自治区</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 30" type="success">宁夏回族自治区</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 31" type="success">新疆维吾尔自治区</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 32" type="success">香港</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 33" type="success">澳门</el-tag>
        <el-tag v-if="scope.row.fkProviceId == 34" type="success">台湾省</el-tag>
      </template>
      <template slot="avatar" slot-scope="scope">
        <el-avatar :size="100" :src="scope.row.avatar" @error="errorHandler">
          <img src="https://cube.elemecdn.com/e/fd/0fc7d20532fdaf769a25683617711png.png">
        </el-avatar>
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
        <el-form-item label="省份">
          <el-select v-model="tempProviceId" placeholder="请选择">
            <el-option
              v-for="item in proviceOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            />
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
        <el-form-item label="文件上传">
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
import { tableOption } from '@/const/crud/publicExamination/publicExamination'
import { videoList, delById, addObj } from '@/api/publicExamination/publicExamination'
export default {
  name: 'PublicExamination',
  data() {
    return {
      option: tableOption,
      proviceOptions: [{
        label: '北京市',
        value: 1
      }, {
        label: '天津市',
        value: 2
      }, {
        label: '上海市',
        value: 3
      }, {
        label: '重庆市',
        value: 4
      }, {
        label: '河北省',
        value: 5
      }, {
        label: '山西省',
        value: 6
      }, {
        label: '辽宁省',
        value: 7
      }, {
        label: '吉林省',
        value: 8
      }, {
        label: '黑龙江省',
        value: 9
      }, {
        label: '江苏省',
        value: 10
      }, {
        label: '浙江省',
        value: 11
      }, {
        label: '安徽省',
        value: 12
      }, {
        label: '福建省',
        value: 13
      }, {
        label: '江西省',
        value: 14
      }, {
        label: '山东省',
        value: 15
      }, {
        label: '河南省',
        value: 16
      }, {
        label: '湖北省',
        value: 17
      }, {
        label: '湖南省',
        value: 18
      }, {
        label: '广东省',
        value: 19
      }, {
        label: '海南省',
        value: 20
      }, {
        label: '四川省',
        value: 21
      }, {
        label: '贵州省',
        value: 22
      }, {
        label: '云南省',
        value: 23
      }, {
        label: '陕西省',
        value: 24
      }, {
        label: '甘肃省',
        value: 25
      }, {
        label: '青海省',
        value: 26
      }, {
        label: '西藏自治区',
        value: 27
      }, {
        label: '广西壮自治区',
        value: 28
      }, {
        label: '内蒙古自治区',
        value: 29
      }, {
        label: '宁夏回族自治区',
        value: 30
      }, {
        label: '新疆维吾尔自治区',
        value: 31
      }, {
        label: '香港',
        value: 32
      }, {
        label: '澳门',
        value: 33
      }, {
        label: '台湾省',
        value: 34
      }],
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
      uplodeVideoUrl: undefined,
      form: {},
      fileList: [],
      tempProviceId: undefined,
      uplodeImgUrl: undefined,
      imageUrl: undefined
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
      videoList(Object.assign({
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
      this.uplodeVideoUrl = undefined
      this.uplodeFlag = false
      this.uplodeImgUrl = undefined
      this.imageUrl = undefined
      this.form = {}
      this.fileList = []
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
    beforePdfUpload(file) {
      this.uplodeFlag = true
      return true
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
    confimAdd() {
      if (this.uplodeFlag) {
        this.$message.error('请等待上传完成')
        return
      }
      if (this.tempProviceId === undefined) {
        this.$message.error('请选择省份')
        return
      }
      if (this.uplodeImgUrl === undefined || this.uplodeImgUrl === '') {
        this.$message.error('请先上传图片')
        return
      }
      if (this.uplodeVideoUrl === undefined || this.uplodeVideoUrl === '') {
        this.$message.error('请先上传文件')
        return
      }
      addObj(this.tempProviceId, this.uplodeImgUrl, this.uplodeVideoUrl).then(res => {
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
