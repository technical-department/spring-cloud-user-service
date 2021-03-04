<template>
  <div style="margin-top: 20px;">
    <avue-crud :option="option" :table-loading="listLoading" :data="list" :page="page" @search-change="searchChange" @on-load="getList" @refresh-change="getList">
      <template slot="menuLeft">
        <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openUpload">添加</el-button>
        <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openBatchUpload">批量上传</el-button>
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
      <template slot="isArts" slot-scope="scope">
        <el-tag v-if="scope.row.isArts == 0" effect="dark">文科</el-tag>
        <el-tag v-if="scope.row.isArts == 1" effect="dark" type="success">理科</el-tag>
      </template>
      <template slot="batchNum" slot-scope="scope">
        <el-tag v-if="scope.row.batchNum == 1" effect="dark">第一批次</el-tag>
        <el-tag v-if="scope.row.batchNum == 2" effect="dark" type="success">第二批次</el-tag>
        <el-tag v-if="scope.row.batchNum == 3" effect="dark" type="danger">第三批次</el-tag>
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
        <el-form-item label="年份">
          <el-input v-model="tempYear" />
        </el-form-item>
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
        <el-form-item label="文理科">
          <el-select v-model="tempIsArts" placeholder="请选择">
            <el-option
              v-for="item in artsOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="批次">
          <el-select v-model="tempBatchNum" placeholder="请选择">
            <el-option label="第一批次" value="1" />
            <el-option label="第二批次" value="2" />
            <el-option label="第三批次" value="3" />
          </el-select>
        </el-form-item>
        <el-form-item label="最高分">
          <el-input-number v-model="tempMaxScore" :min="1" />
        </el-form-item>
        <el-form-item label="最低分">
          <el-input-number v-model="tempMinScore" :min="1" />
        </el-form-item>
        <el-form-item label="平均分">
          <el-input-number v-model="tempAverageScore" :min="1" />
        </el-form-item>
        <el-form-item label="录取人数">
          <el-input-number v-model="tempUserNum" :min="1" />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="confimAdd">确 定</el-button>
      </span>
    </el-dialog>
    <!--批量上传--->
    <el-dialog
      title="批量上传"
      :visible.sync="batchDialogVisible"
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
        <el-button @click="batchDialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="batchConfimAdd">确 定</el-button>
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
import { tableOption } from '@/const/crud/university/admission'
import { queryList, delById, addObj, batchAdd, checkPrecent } from '@/api/university/universityAdmission'
export default {
  name: 'SubjectAdmission',
  data() {
    return {
      option: tableOption,
      artsOptions: [{
        label: '文科',
        value: 0
      }, {
        label: '理科',
        value: 1
      }],
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
      list: [],
      listLoading: true,
      dialogVisible: false,
      form: {},
      fileList: [],
      tempYear: undefined,
      tempProviceId: undefined,
      tempIsArts: undefined,
      tempBatchNum: undefined,
      tempMaxScore: undefined,
      tempMinScore: undefined,
      tempAverageScore: undefined,
      tempUserNum: undefined,
      universitySubjectId: undefined,
      batchDialogVisible: false,
      uplodeFlag: false,
      uplodeUrl: undefined,
      dialogPrecentVisible: false,
      progressNum: 0,
      progressStatus: undefined,
      tempParams: undefined
    }
  },
  computed: {
  },
  created() {
    this.universitySubjectId = this.$route.query.id
  },
  methods: {
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
        size: page.pageSize,
        universitySubjectId: this.universitySubjectId
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
    openUpload() {
      this.dialogVisible = true
      this.tempYear = undefined
      this.tempIsArts = undefined
      this.tempProviceId = undefined
      this.tempBatchNum = undefined
      this.tempMaxScore = undefined
      this.tempMinScore = undefined
      this.tempAverageScore = undefined
      this.tempUserNum = undefined
      this.form = {}
    },
    openBatchUpload() {
      this.batchDialogVisible = true
      this.fileList = []
      this.uplodeUrl = undefined
    },
    confimAdd() {
      if (this.tempYear === undefined || this.tempYear === '') {
        this.$message.error('请填写年份')
        return
      }
      if (this.tempProviceId === undefined) {
        this.$message.error('请选择上传省份')
        return
      }
      if (this.tempIsArts === undefined) {
        this.$message.error('请选择文理科')
        return
      }
      if (this.tempBatchNum === undefined) {
        this.$message.error('请选择批次')
        return
      }
      // if (this.tempMaxScore === undefined) {
      //   this.$message.error('请填写最高分')
      //   return
      // }
      // if (this.tempMinScore === undefined) {
      //   this.$message.error('请填写最低分')
      //   return
      // }
      if (this.tempUserNum === undefined) {
        this.$message.error('请填写录取人数')
        return
      }
      addObj(this.universitySubjectId, this.tempProviceId, this.tempIsArts, this.tempBatchNum, this.tempYear,
        this.tempMaxScore, this.tempMinScore, this.tempAverageScore, this.tempUserNum).then(res => {
        this.dialogVisible = false
        this.searchChange()
      })
    },
    batchConfimAdd() {
      if (this.uplodeFlag) {
        this.$message.error('请等待上传完成')
        return
      }
      batchAdd(this.universitySubjectId, this.uplodeUrl).then(res => {
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
    }
  }
}
</script>
<style>
</style>
