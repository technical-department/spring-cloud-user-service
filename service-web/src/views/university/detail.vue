<template>
  <div style="margin-top: 20px;">
    <el-form ref="form" label-width="80px">
      <el-form-item label="学校网址">
        <el-input v-model="website" class="max-width-600"></el-input>
      </el-form-item>
      <el-form-item label="招生电话">
        <el-input v-model="phone" class="max-width-600"></el-input>
      </el-form-item>
      <el-form-item label="学校地址">
        <el-input v-model="address" class="max-width-600"></el-input>
      </el-form-item>
      <el-form-item label="博士点">
        <el-input v-model="doctorAddress" class="max-width-600"></el-input>
      </el-form-item>
      <el-form-item label="硕士点">
        <el-input v-model="masterAddress" class="max-width-600"></el-input>
      </el-form-item>
      <el-form-item label="学校概况">
        <markdown-editor v-model="survey" height="200px" />
      </el-form-item>
      <el-form-item label="出国对接">
        <markdown-editor v-model="abroadAbutment" height="200px" />
      </el-form-item>
      <el-form-item label="科研平台">
        <markdown-editor v-model="scientificPlatform" height="200px" />
      </el-form-item>
      <el-form-item label="就业对接">
        <markdown-editor v-model="jobAbutment" height="200px" />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" @click="onSubmit">确认</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>
  </div>
</template>
<script>
import MarkdownEditor from '@/components/MarkdownEditor'
import { queryObj, addObj } from '@/api/university/universityInfo'
export default {
  name: 'UniversityDetail',
  components: { MarkdownEditor },
  created() {
    this.universityId = this.$route.query.id
    queryObj(this.universityId).then(res => {
      if (res.data != null) {
        const resData = res.data
        this.website = resData.website
        this.phone = resData.phone
        this.address = resData.address
        this.doctorAddress = resData.doctorAddress
        this.masterAddress = resData.masterAddress
        this.survey = resData.survey
        this.abroadAbutment = resData.abroadAbutment
        this.scientificPlatform = resData.scientificPlatform
        this.jobAbutment = resData.jobAbutment
      } else {
        this.website = undefined
        this.phone = undefined
        this.address = undefined
        this.doctorAddress = undefined
        this.masterAddress = undefined
        this.survey = undefined
        this.abroadAbutment = undefined
        this.scientificPlatform = undefined
        this.jobAbutment = undefined
      }
    })
  },
  data() {
    return {
      universityId: undefined,
      website: undefined,
      phone: undefined,
      address: undefined,
      doctorAddress: undefined,
      masterAddress: undefined,
      survey: undefined,
      abroadAbutment: undefined,
      scientificPlatform: undefined,
      jobAbutment: undefined
    }
  },
  computed: {
  },
  methods: {
    onSubmit() {
      addObj(this.universityId, this.website, this.phone, this.address,
        this.doctorAddress, this.masterAddress, this.survey,
        this.abroadAbutment, this.scientificPlatform, this.jobAbutment).then(res => {
        this.$notify({
          title: '成功',
          message: '修改成功',
          type: 'success',
          duration: 1500
        })
      })
      console.log(this.survey)
    }
  }
}
</script>
<style>
  .max-width-600{
    max-width: 600px;
  }
</style>
