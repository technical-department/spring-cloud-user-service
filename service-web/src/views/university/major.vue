<template>
  <el-container>
    <el-main>
      <avue-crud :option="option" :table-loading="listLoading" :data="list" :page="page" @on-load="getList" @search-change="searchChange" @refresh-change="getList">
        <template slot="menuLeft">
          <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openUpload">添加</el-button>
          <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openBatchUpload">批量上传</el-button>
          <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openBatchScoreUpload">批量上传录取数据</el-button>
          <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openBatchDelete">批量删除专业数据</el-button>
          <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openBatchScoreDelete">批量删除录取数据</el-button>
        </template>
        <template slot="menu" slot-scope="scope">
          <el-button size="small" type="text" icon="el-icon-delete" @click="handleDelete(scope.row.id)">删除</el-button>
          <el-button size="small" type="text" icon="el-icon-delete" @click="toAdmission(scope.row.id)">录取数据</el-button>
        </template>
      </avue-crud>
    </el-main>
    <el-dialog
      title="添加"
      :visible.sync="dialogVisible"
      width="30%"
      style="text-align: center;"
    >
      <el-form ref="form" label-width="80px">
        <el-form-item label="专业">
          <el-cascader v-model="tempSubject" :props="subjectProps" />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="confimAdd">确 定</el-button>
      </span>
    </el-dialog>
    <!--批量上传-->
    <el-dialog
      title="批量上传"
      :visible.sync="batchDialogVisible"
      width="30%"
      style="text-align: center;"
    >
      <el-form ref="form" label-width="80px">
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
        <el-button @click="batchDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="batchConfimAdd">确 定</el-button>
      </span>
    </el-dialog>
    <!--批量录取数据上传-->
    <el-dialog
      title="批量录取数据上传"
      :visible.sync="batchScoreDialogVisible"
      width="30%"
      style="text-align: center;"
    >
      <el-form ref="form" label-width="80px">
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
        <el-button @click="batchScoreDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="batchScoreConfimAdd">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog
      title="批量专业删除"
      :visible.sync="batchDeleteDialogVisible"
      width="30%"
      style="text-align: center;"
    >
      <el-form ref="form" label-width="80px">
        <div>是否确认删除</div>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="batchDeleteDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="batchDeleteConfim">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog
      title="批量录取数据删除"
      :visible.sync="batchScoreDeleteDialogVisible"
      width="30%"
      style="text-align: center;"
    >
      <el-form ref="form" label-width="80px">
        <el-form-item label="年份">
          <el-input v-model="tempDeleteYear" placeholder="请输入年份" />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="batchScoreDeleteDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="batchScoreDeleteConfim">确 定</el-button>
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
  </el-container>
</template>
<script>
import { tableOption } from '@/const/crud/university/major'
import { queryList, delById, addObj, batchAdd, checkPrecent, batchScoreAdd, checkScorePrecent, batchDelete, batchScoreDelete } from '@/api/university/universityMajor'
import { getClassifyList, getTopListByClassifyName, getSubjectList } from '@/api/subject/subjectHot'
export default {
  name: 'UniversityScenery',
  data() {
    return {
      option: tableOption,
      page: {
        total: 0,
        currentPage: 1,
        pageSize: 20,
        isAsc: false
      },
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
      tempSubject: undefined,
      list: [],
      listLoading: true,
      dialogVisible: false,
      batchDialogVisible: false,
      batchScoreDialogVisible: false,
      batchDeleteDialogVisible: false,
      batchScoreDeleteDialogVisible: false,
      universityId: undefined,
      filterText: '',
      uplodeFlag: false,
      uplodeUrl: undefined,
      fileList: [],
      dialogPrecentVisible: false,
      progressNum: 0,
      progressStatus: undefined,
      tempParams: undefined,
      tempDeleteYear: undefined
    }
  },
  computed: {
  },
  watch: {
    filterText(val) {
      this.$refs.tree.filter(val)
    }
  },
  created() {
    this.universityId = this.$route.query.id
  },
  methods: {
    toAdmission(id) {
      this.$router.push({ path: '/university/universitySubject/admission', query: { id: id }})
    },
    getList(page, params) {
      // eslint-disable-next-line eqeqeq
      if (params == undefined && this.tempParams != undefined) {
        params = this.tempParams
      }
      this.listLoading = true
      // eslint-disable-next-line eqeqeq
      queryList(Object.assign({
        current: page.currentPage,
        size: page.pageSize,
        universityId: this.universityId
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
    searchChange(params) {
      console.log(params)
      this.tempParams = params
      this.getList({ currentPage: 1, pageSize: 20 }, params)
    },
    openUpload() {
      this.dialogVisible = true
      this.tempSubject = undefined
    },
    openBatchUpload() {
      this.batchDialogVisible = true
      this.uplodeUrl = undefined
      this.form = {}
      this.fileList = []
    },
    openBatchScoreUpload() {
      this.batchScoreDialogVisible = true
      this.uplodeUrl = undefined
      this.form = {}
      this.fileList = []
    },
    openBatchDelete() {
      this.batchDeleteDialogVisible = true
    },
    openBatchScoreDelete() {
      this.batchScoreDeleteDialogVisible = true
      this.tempDeleteYear = undefined
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
    batchConfimAdd() {
      if (this.uplodeFlag) {
        this.$message.error('请等待上传完成')
        return
      }
      batchAdd(this.universityId, this.uplodeUrl).then(res => {
        this.batchDialogVisible = false
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
                _this.progressNum = 0
                _this.progressStatus = undefined
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
    },
    batchScoreConfimAdd() {
      if (this.uplodeFlag) {
        this.$message.error('请等待上传完成')
        return
      }
      batchScoreAdd(this.universityId, this.uplodeUrl).then(res => {
        this.batchScoreDialogVisible = false
        this.dialogPrecentVisible = true
        const _this = this
        _this.timet = setInterval(() => {
          checkScorePrecent(_this.uplodeUrl).then(res => {
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
                _this.progressNum = 0
                _this.progressStatus = undefined
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
    },
    batchScoreDeleteConfim() {
      if (this.tempDeleteYear === undefined) {
        this.$message.error('请填写年份')
        return
      }
      batchScoreDelete(this.universityId, this.tempDeleteYear).then(res => {
        this.batchScoreDeleteDialogVisible = false
        this.$notify({
          title: '成功',
          message: '处理成功',
          type: 'success',
          duration: 2000
        })
      })
    },
    batchDeleteConfim() {
      batchDelete(this.universityId).then(res => {
        this.batchDeleteDialogVisible = false
        this.$notify({
          title: '成功',
          message: '处理成功',
          type: 'success',
          duration: 2000
        })
        this.getList(this.page)
      })
    },
    confimAdd() {
      if (this.tempSubject === undefined) {
        this.$message.error('请选择专业')
        return
      }
      addObj(this.universityId, this.tempSubject[2]).then(res => {
        // eslint-disable-next-line eqeqeq
        if (res.data.status == 1 || res.data.status == '1') {
          this.$notify({
            title: '失败',
            message: '学校已存在此专业',
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
