<template>
  <div style="margin-top: 20px;">
    <el-form ref="form" label-width="80px">
      <el-form-item label="描述">
        <markdown-editor v-model="detail" height="400px" />
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
import { queryObj, addObj } from '@/api/university/universityAbutment'
export default {
  name: 'UniversityJoionAbutment',
  components: { MarkdownEditor },
  data() {
    return {
      universityId: undefined,
      evaluate: undefined,
      contact: undefined,
      detail: undefined
    }
  },
  computed: {
  },
  created() {
    this.universityId = this.$route.query.id
    queryObj(this.universityId).then(res => {
      if (res.data != null) {
        const resData = res.data
        this.evaluate = resData.evaluate
        this.contact = resData.contact
        this.detail = resData.detail
      } else {
        this.evaluate = undefined
        this.contact = undefined
        this.detail = undefined
      }
    })
  },
  methods: {
    onSubmit() {
      addObj(this.universityId, this.evaluate, this.contact, this.detail).then(res => {
        this.$notify({
          title: '成功',
          message: '修改成功',
          type: 'success',
          duration: 1500
        })
      })
    }
  }
}
</script>
<style>
  .max-width-600{
    max-width: 600px;
  }
</style>
