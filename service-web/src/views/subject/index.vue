<template>
  <div style="margin-top: 20px;">
    <avue-crud :option="option" :table-loading="listLoading" :data="list" :page="page" @search-change="searchChange" @on-load="getList" @refresh-change="getList">
      <template slot="menuLeft">
        <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openUpload">添加</el-button>
      </template>
      <template slot="menu" slot-scope="scope">
        <el-button size="small" type="text" icon="el-icon-edit" @click="handleIntroduce(scope.row.id)">专业介绍</el-button>
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
        <el-form-item label="excel上传">
          <el-upload
            class="upload-demo"
            drag
            multiple
            action="http://www.zhishieducation.cn:40000/web/uplode/uplodeExcel"
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
    <el-dialog
      title="处理进度"
      :visible.sync="dialogPrecentVisible"
      :close-on-click-modal="false"
      :close-on-press-escape="false"
      :show-close="false"
      center
    >
      <div style="text-align: center">
        <el-progress type="circle" :percentage="progressNum" :status="progressStatus" />
      </div>
    </el-dialog>
  </div>
</template>
<script>
import { tableOption } from '@/const/crud/subject/subject'
import { queryList, delById, addObj, checkPrecent } from '@/api/subject/subject'
export default {
  name: 'Subject',
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
      tempParams: undefined
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
      this.getList({ currentPage: 1, pageSize: 20 }, params)
    },
    getList(page, params) {
      // eslint-disable-next-line eqeqeq
      if (params == undefined && this.tempParams != undefined) {
        params = this.tempParams
      }
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
    beforeUpload(file) {
      console.log(file.name)
      console.log(file.type)
      const fileName = file.name
      if (fileName.substring(fileName.lastIndexOf('.') + 1) === 'xlsx') {
        this.uplodeFlag = true
        return true
      }
      this.$message.error('请上传excel文件')
      return false
    },
    confimAdd() {
      if (this.uplodeFlag) {
        this.$message.error('请等待上传完成')
        return
      }
      if (this.uplodeUrl === undefined || this.uplodeUrl === '') {
        this.$message.error('请先上传excel')
        return
      }
      addObj(this.uplodeUrl).then(res => {
        this.dialogVisible = false
        this.dialogPrecentVisible = true
        const _this = this
        _this.timet = setInterval(() => {
          checkPrecent(_this.uplodeUrl).then(res => {
            const resdata = res.data
            if (resdata.status === '1' || resdata.status === 1) {
              // 获取到百分比
              if (resdata.precent === undefined || resdata.precent === null) {
                _this.progressNum = 0
              } else {
                _this.progressNum = Number(resdata.precent)
              }
            } else if (resdata.status === 0 || resdata.status === '0') {
              _this.progressNum = 100
              _this.progressStatus = 'success'
              clearInterval(_this.timet)
              this.$notify({
                title: '成功',
                message: '处理成功',
                type: 'success',
                duration: 2000
              })
              setTimeout(() => {
                _this.searchChange()
              }, 1000)
              _this.dialogPrecentVisible = false
            }
          }).catch(() => {
            this.$notify({
              title: '失败',
              message: '检查处理进度失败',
              type: 'warning',
              duration: 2000
            })
            clearInterval(_this.timet)
            _this.progressNum = 0
            _this.uplodeUrl = undefined
            _this.dialogPrecentVisible = false
            _this.progressStatus = undefined
          })
        }, 500)
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
