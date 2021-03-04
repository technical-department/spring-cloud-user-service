<template>
  <div style="margin-top: 20px;">
    <el-form ref="form" label-width="80px">
      <markdown-editor v-model="introduce" height="600px" />
      <el-button type="primary" @click="onSubmit">确认</el-button>
    </el-form>
  </div>
</template>
<script>
import MarkdownEditor from '@/components/MarkdownEditor'
import { getIntroduceDetail, updateIntroduce } from '@/api/university/universityMajor'
export default {
  name: 'UniversityMajorIntroduce',
  components: { MarkdownEditor },
  data() {
    return {
      majorId: undefined,
      introduce: undefined
    }
  },
  computed: {
  },
  created() {
    this.majorId = this.$route.query.id
    getIntroduceDetail(this.majorId).then(res => {
      if (res.data != null) {
        const resData = res.data
        this.introduce = resData.detail
      } else {
        this.introduce = undefined
      }
    })
  },
  methods: {
    onSubmit() {
      updateIntroduce(this.majorId, this.introduce).then(res => {
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
</style>
