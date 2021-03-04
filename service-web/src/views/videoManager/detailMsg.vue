<template>
  <div style="margin-top: 20px;">
    <el-form ref="form" label-width="80px">
      <el-form-item label="描述">
        <markdown-editor v-model="detailMsg" height="400px" />
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
import { queryObj, updateDetailMsg } from '@/api/newVideoManager'
export default {
  name: 'VideodetailMsg',
  components: { MarkdownEditor },
  data() {
    return {
      videoId: undefined,
      detailMsg: undefined
    }
  },
  computed: {
  },
  created() {
    this.videoId = this.$route.query.id
    queryObj(this.videoId).then(res => {
      if (res.data != null) {
        this.detailMsg = res.data
      } else {
        this.detailMsg = undefined
      }
    })
  },
  methods: {
    onSubmit() {
      updateDetailMsg(this.videoId, this.detailMsg).then(res => {
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
