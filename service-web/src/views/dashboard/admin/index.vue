<template>
  <div class="dashboard-editor-container">
    <el-button :loading="downloadLoading" @click="exportExcel">生成激活码</el-button>
    <el-button @click="payConfiguration">支付金额设置</el-button>
    <el-button @click="IOSPay">IOS支付设置</el-button>
    <el-button @click="smartReport">智能填报开关</el-button>
    <panel-group />
    <el-dialog
      title="支付金额设置"
      :visible.sync="dialogVisible"
      width="30%"
      style="text-align: center;"
    >
      <el-form ref="form" label-width="80px">
        <el-form-item label="金额">
          <el-input v-model="decimal" />
        </el-form-item>
      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="dialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="confimPayConfiguration">确 定</el-button>
      </span>
    </el-dialog>

    <el-dialog
      title="IOS支付设置"
      :visible.sync="IOSdialogVisible"
      width="30%"
      style="text-align: center;"
    >
      <el-switch
        v-model="IOSPayFlag"
        active-text="启用"
        inactive-text="未启用"
      />
      <span slot="footer" class="dialog-footer">
        <el-button @click="IOSdialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="confimIOS">确 定</el-button>
      </span>
    </el-dialog>
    <el-dialog
      title="智能填报开关"
      :visible.sync="smartReportdialogVisible"
      width="30%"
      style="text-align: center;"
    >
      <el-switch
        v-model="smartReportFlag"
        active-text="启用"
        inactive-text="未启用"
      />
      <span slot="footer" class="dialog-footer">
        <el-button @click="smartReportdialogVisible = false">取 消</el-button>
        <el-button type="primary" @click="confimSmartReport">确 定</el-button>
      </span>
    </el-dialog>
  </div>
</template>

<script>
import PanelGroup from './components/PanelGroup'
import { generatorActivityCode, getPayConfigration, savePayConfigration, getIOSPayConfigration, updateIOSPayConfigration, getSmartReportConfigration, updateSmartReportConfigration } from '@/api/banner'

export default {
  name: 'DashboardAdmin',
  components: {
    PanelGroup
  },
  data() {
    return {
      downloadLoading: false,
      dialogVisible: false,
      IOSdialogVisible: false,
      smartReportdialogVisible: false,
      IOSPayFlag: false,
      smartReportFlag: false,
      decimal: 0,
      list: null,
      filename: '',
      autoWidth: true,
      bookType: 'xlsx'
    }
  },
  methods: {
    confimSmartReport() {
      let status = 0
      // eslint-disable-next-line eqeqeq
      if (this.smartReportFlag == false) {
        status = 0
      } else if (this.smartReportFlag) {
        status = 1
      }
      updateSmartReportConfigration(status).then(res => {
        if (res.code === 0) {
          this.$message.success('修改成功')
          this.smartReportdialogVisible = false
        }
      })
    },
    confimIOS() {
      let status = 0
      // eslint-disable-next-line eqeqeq
      if (this.IOSPayFlag == false) {
        status = 0
      } else if (this.IOSPayFlag) {
        status = 1
      }
      updateIOSPayConfigration(status).then(res => {
        if (res.code === 0) {
          this.$message.success('修改成功')
          this.IOSdialogVisible = false
        }
      })
    },
    confimPayConfiguration() {
      savePayConfigration(this.decimal).then(res => {
        if (res.code === 0) {
          this.$message.success('修改成功')
          this.dialogVisible = false
        }
      })
    },
    payConfiguration() {
      this.dialogVisible = true
      getPayConfigration().then(res => {
        this.decimal = res.data
      })
    },
    IOSPay() {
      this.IOSdialogVisible = true
      getIOSPayConfigration().then(res => {
        // eslint-disable-next-line eqeqeq
        if (res.data == 0) {
          this.IOSPayFlag = false
          // eslint-disable-next-line eqeqeq
        } else if (res.data == 1) {
          this.IOSPayFlag = true
        }
      })
    },
    smartReport() {
      this.smartReportdialogVisible = true
      getSmartReportConfigration().then(res => {
        // eslint-disable-next-line eqeqeq
        if (res.data == 0) {
          this.IOSPayFlag = false
          // eslint-disable-next-line eqeqeq
        } else if (res.data == 1) {
          this.IOSPayFlag = true
        }
      })
    },
    exportExcel() {
      this.downloadLoading = true
      generatorActivityCode().then(res => {
        import('@/vendor/Export2Excel').then(excel => {
          const tHeader = ['激活码']
          const filterVal = ['activityCode']
          const list = res.data
          const data = this.formatJson(filterVal, list)
          excel.export_json_to_excel({
            header: tHeader,
            data,
            filename: this.filename,
            autoWidth: this.autoWidth,
            bookType: this.bookType
          })
          this.downloadLoading = false
        })
      })
    },
    formatJson(filterVal, jsonData) {
      return jsonData.map(v => filterVal.map(j => {
        return v[j]
      }))
    }
  }
}
</script>

<style lang="scss" scoped>
.dashboard-editor-container {
  padding: 32px;
  background-color: rgb(240, 242, 245);
  position: relative;

  .github-corner {
    position: absolute;
    top: 0px;
    border: 0;
    right: 0;
  }

  .chart-wrapper {
    background: #fff;
    padding: 16px 16px 0;
    margin-bottom: 32px;
  }
}

@media (max-width:1024px) {
  .chart-wrapper {
    padding: 8px;
  }
}
</style>
