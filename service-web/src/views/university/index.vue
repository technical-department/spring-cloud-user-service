<template>
  <div style="margin-top: 20px;">
    <avue-crud :option="option" :table-loading="listLoading" :data="list" :page="page" @search-change="searchChange" @on-load="getList" @refresh-change="getList">
      <template slot="menuLeft">
        <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="openUpload">添加</el-button>
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
      <template slot="collegeType" slot-scope="scope">
        <el-tag v-if="scope.row.collegeType == 0" effect="dark">综合</el-tag>
        <el-tag v-if="scope.row.collegeType == 1" effect="dark" type="success">理工</el-tag>
        <el-tag v-if="scope.row.collegeType == 2" effect="dark" type="info">农林</el-tag>
        <el-tag v-if="scope.row.collegeType == 3" effect="dark" type="warning">医药</el-tag>
        <el-tag v-if="scope.row.collegeType == 4" effect="dark" type="danger">师范</el-tag>
        <el-tag v-if="scope.row.collegeType == 5" effect="dark" color="#345678">语言</el-tag>
        <el-tag v-if="scope.row.collegeType == 6" effect="dark" color="#345678">财经</el-tag>
        <el-tag v-if="scope.row.collegeType == 7" effect="dark" color="#345678">政法</el-tag>
        <el-tag v-if="scope.row.collegeType == 8" effect="dark" color="#345678">体育</el-tag>
        <el-tag v-if="scope.row.collegeType == 9" effect="dark" color="#345678">艺术</el-tag>
        <el-tag v-if="scope.row.collegeType == 10" effect="dark" color="#345678">民族</el-tag>
        <el-tag v-if="scope.row.collegeType == 11" effect="dark" color="#345678">军事</el-tag>
        <el-tag v-if="scope.row.collegeType == 12" effect="dark" color="#345678">其他</el-tag>
      </template>
      <template slot="collegeAttribute" slot-scope="scope">
        <el-tag
          v-for="item in scope.row.collegeAttribute.split(',')"
          :key="item"
          style="margin: 3px;"
          :type="attibuteTypeFilter(item)"
          effect="dark"
        >
          {{ attibuteValueFilter(item) }}
        </el-tag>
      </template>
      <template slot="collegeMainType" slot-scope="scope">
        <el-tag v-if="scope.row.collegeMainType == 0" effect="dark">本科</el-tag>
        <el-tag v-if="scope.row.collegeMainType == 1" effect="dark" type="success">专科</el-tag>
      </template>
      <template slot="menu" slot-scope="scope">
        <el-button size="small" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)">编辑</el-button>
        <el-divider direction="vertical" />
        <el-button size="small" type="text" icon="el-icon-delete" @click="handleDelete(scope.row.id)">删除</el-button>
        <el-divider direction="vertical" />
        <el-dropdown :hide-on-click="false" style="color: #4A9FF9">
          <span class="el-dropdown-link">
            更多<i class="el-icon-arrow-down el-icon--right" />
          </span>
          <el-dropdown-menu slot="dropdown">
            <el-dropdown-item @click.native="toBaseInfo(scope.row.id)">基础数据</el-dropdown-item>
            <el-dropdown-item v-if="scope.row.collegeMainType == 0" @click.native="toScenery(scope.row.id)">校园风光</el-dropdown-item>
            <el-dropdown-item @click.native="toMajor(scope.row.id)">专业维护</el-dropdown-item>
            <el-dropdown-item v-if="scope.row.collegeMainType == 0" @click.native="toAbutment(scope.row.id)">院校对接</el-dropdown-item>
            <el-dropdown-item v-if="scope.row.collegeMainType == 1" @click.native="toJoionAbutment(scope.row.id)">专科录取描述</el-dropdown-item>
          </el-dropdown-menu>
        </el-dropdown>
      </template>
    </avue-crud>
    <el-dialog
      title="添加"
      :visible.sync="dialogVisible"
      width="30%"
      style="text-align: center;"
    >
      <el-form ref="form" label-width="80px">
        <el-form-item label="学校名称">
          <el-input v-model="collegeName" />
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
        <el-form-item label="学校代码">
          <el-input v-model="tempCode" />
        </el-form-item>
        <el-form-item label="所在城市">
          <el-input v-model="tempCityName" />
        </el-form-item>
        <el-form-item label="院校类型">
          <el-select v-model="tempCollegeType" placeholder="请选择">
            <el-option
              v-for="item in collegeTypeOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="院校属性">
          <el-checkbox-group v-model="checkList">
            <el-checkbox label="0">985</el-checkbox>
            <el-checkbox label="1">211</el-checkbox>
            <el-checkbox label="2">双一流</el-checkbox>
          </el-checkbox-group>
        </el-form-item>
        <el-form-item label="本专科">
          <el-select v-model="tempCollegeMainType" placeholder="请选择">
            <el-option
              v-for="item in collegeMainTypeOptions"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            />
          </el-select>
        </el-form-item>
        <el-form-item label="全国排名">
          <el-input-number v-model="nationalRank" :min="1" />
        </el-form-item>
        <el-form-item label="类别排名">
          <el-input-number v-model="categoryRank" :min="1" />
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
import { tableOption } from '../../const/crud/university/university'
import { queryList, delById, addObj } from '@/api/university'
export default {
  name: 'AppVersion',
  data() {
    return {
      option: tableOption,
      collegeTypeOptions: [{
        label: '综合',
        value: 0
      }, {
        label: '理工',
        value: 1
      }, {
        label: '农林',
        value: 2
      }, {
        label: '医药',
        value: 3
      }, {
        label: '师范',
        value: 4
      }, {
        label: '语言',
        value: 5
      }, {
        label: '财经',
        value: 6
      }, {
        label: '政法',
        value: 7
      }, {
        label: '体育',
        value: 8
      }, {
        label: '艺术',
        value: 9
      }, {
        label: '民族',
        value: 10
      }, {
        label: '军事',
        value: 11
      }, {
        label: '其他',
        value: 12
      }],
      collegeMainTypeOptions: [{
        label: '本科',
        value: 0
      }, {
        label: '专科',
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
      checkList: [],
      uplodeFlag: false,
      list: [],
      listLoading: true,
      dialogVisible: false,
      dialogPrecentVisible: false,
      progressStatus: undefined,
      progressNum: 0,
      uplodeUrl: undefined,
      imageUrl: undefined,
      form: {},
      fileList: [],
      tempId: undefined,
      collegeName: undefined,
      nationalRank: undefined,
      categoryRank: undefined,
      tempProviceId: undefined,
      tempCityName: undefined,
      tempCode: undefined,
      tempCollegeType: undefined,
      tempCollegeMainType: undefined,
      tempParams: undefined
    }
  },
  computed: {
  },
  methods: {
    toBaseInfo(id) {
      this.$router.push({ path: '/university/universityDetail', query: { id: id }})
    },
    toScenery(id) {
      this.$router.push({ path: '/university/universityScenery', query: { id: id }})
    },
    toMajor(id) {
      this.$router.push({ path: '/university/universityMajor', query: { id: id }})
    },
    toAbutment(id) {
      this.$router.push({ path: '/university/universityAbutment', query: { id: id }})
    },
    toJoionAbutment(id) {
      this.$router.push({ path: '/university/universityJoionAbutment', query: { id: id }})
    },
    attibuteTypeFilter: function(item) {
      // eslint-disable-next-line eqeqeq
      // eslint-disable-next-line eqeqeq
      if (item == 0) {
        return 'danger'
        // eslint-disable-next-line eqeqeq
      } else if (item == 1) {
        return 'warning'
        // eslint-disable-next-line eqeqeq
      } else if (item == 2) {
        // eslint-disable-next-line eqeqeq
        return 'info'
        // eslint-disable-next-line eqeqeq
      } else if (item == 3) {
        return 'success'
        // eslint-disable-next-line eqeqeq
      } else if (item == 4) {
        return ''
        // eslint-disable-next-line eqeqeq
      } else if (item == 5) {
        return ''
        // eslint-disable-next-line eqeqeq
      } else if (item == 6) {
        return ''
      }
    },
    attibuteValueFilter: function(item) {
      // eslint-disable-next-line eqeqeq
      if (item == 0) {
        return '985'
        // eslint-disable-next-line eqeqeq
      } else if (item == 1) {
        return '211'
        // eslint-disable-next-line eqeqeq
      } else if (item == 2) {
        // eslint-disable-next-line eqeqeq
        return '双一流'
        // eslint-disable-next-line eqeqeq
      } else if (item == 3) {
        return '本一'
        // eslint-disable-next-line eqeqeq
      } else if (item == 4) {
        return '本二'
        // eslint-disable-next-line eqeqeq
      } else if (item == 5) {
        return '本三'
        // eslint-disable-next-line eqeqeq
      } else if (item == 6) {
        return '高职高专'
      }
    },
    errorHandler() {
      return true
    },
    searchChange(params) {
      console.log(params)
      this.tempParams = params
      this.getList({ currentPage: 1, pageSize: 20 }, params)
    },
    getList(page, params) {
      // eslint-disable-next-line eqeqeq
      if (params == undefined && this.tempParams != undefined) {
        params = this.tempParams
      }
      console.log(params)
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
    handleUpdate(row) {
      this.dialogVisible = true
      this.collegeName = row.name
      this.tempCityName = row.cityName
      this.tempCode = row.universityCode
      this.tempProviceId = row.fkProviceId
      this.tempCollegeType = row.collegeType
      this.tempCollegeMainType = row.collegeMainType
      this.nationalRank = row.nationalRank
      this.categoryRank = row.categoryRank
      this.checkList = row.collegeAttribute.split(',')
      this.uplodeUrl = row.avatar
      this.imageUrl = row.avatar
      this.tempId = row.id
    },
    openUpload() {
      this.dialogVisible = true
      this.uplodeUrl = undefined
      this.imageUrl = undefined
      this.collegeName = undefined
      this.tempProviceId = undefined
      this.tempCityName = undefined
      this.tempCode = undefined
      this.tempCollegeType = undefined
      this.tempCollegeMainType = undefined
      this.nationalRank = undefined
      this.categoryRank = undefined
      this.form = {}
      this.checkList = []
      this.fileList = []
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
      if (this.collegeName === undefined) {
        this.$message.error('请填写学校名称')
        return
      }
      if (this.tempProviceId === undefined) {
        this.$message.error('请选择省份')
        return
      }
      if (this.tempCityName === undefined) {
        this.$message.error('请选择院校类型')
        return
      }
      if (this.tempCode === undefined) {
        this.$message.error('请填写院校代码')
        return
      }/* if (this.checkList === undefined || this.checkList.length < 1) {
        this.$message.error('请选择院校属性')
        return
      }*/
      if (this.tempCollegeMainType === undefined) {
        this.$message.error('请选择本专科')
        return
      }
      if (this.nationalRank === undefined) {
        this.$message.error('请填写全国排名')
        return
      }
      if (this.categoryRank === undefined) {
        this.$message.error('请填写类别排名')
        return
      }
      if (this.uplodeUrl === undefined || this.uplodeUrl === '') {
        this.$message.error('请先上传院校图片')
        return
      }
      addObj(this.tempId, this.collegeName, this.tempProviceId, this.tempCityName, this.tempCode, this.tempCollegeType, this.checkList.join(','), this.tempCollegeMainType, this.uplodeUrl, this.nationalRank, this.categoryRank).then(res => {
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
        this.searchChange()
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
