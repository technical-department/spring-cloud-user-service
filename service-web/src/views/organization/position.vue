<template>
  <div>
    <el-form ref="form" :model="form" label-width="80px">
      <el-form-item label="机构名称">
        <el-select v-model="companyCode" placeholder="请选择" @change="selectChanged">
          <el-option
            v-for="item in companies"
            :key="item.companyCode"
            :label="item.companySimpleName"
            :value="item.companyCode" >
          </el-option>
        </el-select>
      </el-form-item>
    </el-form>
    <div>
      <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="add(0)">添加</el-button>
    </div>

    <div class="" style="margin: 10px auto; width: 98%;">
      <el-table :data="list"
                :tree-props="{children: 'children', hasChildren: 'hasChildren'}"
                @on-load="getTree" @refresh-change="getTree"
                row-key="id"
                border >
        <el-table-column
          prop="departName"
          label="部门名称"
          sortable>
        </el-table-column>
        <el-table-column
          prop="managerCode"
          label="部门主管"
          sortable>
        </el-table-column>
        <el-table-column
          align="center"
          label="操作">
          <template slot-scope="scope">
            <template v-if="scope.row.type != '2'">
              <el-button size="small" type="text" icon="el-icon-edit" @click="handleAdd(scope.row)">添加子项</el-button>
              <el-divider direction="vertical"/>
            </template>
            <el-button size="small" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)">编辑</el-button>
          </template>
        </el-table-column>
      </el-table>
    </div>

    <el-dialog
      title="添加"
      :visible.sync="dialogVisible"
      width="30%"
      style="text-align: center;"
    >
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="资源名称">
          <el-input v-model="name"/>
        </el-form-item>
        <el-form-item label="url">
          <el-input v-model="url"/>
        </el-form-item>
        <el-form-item label="路径">
          <el-input v-model="path"/>
        </el-form-item>
        <el-form-item label="权限码">
          <el-input v-model="permission"/>
        </el-form-item>
        <el-form-item label="icon">
<!--          <icon-picker v-model="icon"></icon-picker>-->
          <el-input v-model="icon"/>
        </el-form-item>
        <el-form-item label="状态" class="text-left">
          <el-switch v-model="available" active-color="#13ce66">
          </el-switch>
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
  import {getAllCompany} from '@/api/company/company'
  import {getTree} from '@/api/department/department'

  export default {
    name: 'Department',
    // components: {
    //   'e-icon-picke': iconPicker,
    // },
    data() {
      return {
        // option: tableOption,
        companyCode: undefined,
        companySimpleName: undefined,
        companies: [],
        name: undefined,
        url: undefined,
        path: undefined,
        permission: undefined,
        icon: undefined,
        available: true,
        resourceCode: undefined,
        parentResourceCode: undefined,
        list: [],
        listLoading: true,
        dialogVisible: false,
        dialogPrecentVisible: false,
        progressStatus: undefined,
        progressNum: 0,
        form: {},
        deleteDialogVisible: false,
        systemCode: undefined,
        systemName: undefined,
        baseinfos: undefined
      }
    },
    computed: {

    },
    mounted: function () {
      getAllCompany().then(res => {
        if (res.code != '1') {
          return
        }
        if (!res.data) {
          return
        }
        this.companies = res.data
        if (this.companies.length > 0) {
          this.companyCode=this.companies[0].companyCode
          this.companySimpleName=this.companies[0].companySimpleName
          this.getTree()
        }
        // this.listLoading = false
      })
    },
    methods: {
      selectChanged(value) {
        this.baseinfos.forEach(item => {
          if (value == item.systemCode) {
            this.systemCode=item.systemCode
            this.systemName=item.systemName
          }
        })
        this.getTree()
      },
      confimDelete() {
        if (this.tempDeleteYear === undefined || this.tempDeleteYear === '') {
          this.$message.error('请填写年份')
          return
        }
        if (this.tempProvice === undefined) {
          this.$message.error('请填写省份')
          return
        }
        if (this.tempCity === undefined) {
          this.$message.error('请填写城市')
          return
        }
        deleteBatch(this.tempDeleteYear, this.tempProvice, this.tempCity).then(res => {
          this.deleteDialogVisible = false
          this.$notify({
            title: '成功',
            message: '删除成功',
            type: 'success',
            duration: 2000
          })
        }).catch(() => {
          this.$notify({
            title: '失败',
            message: '删除失败',
            type: 'warning',
            duration: 2000
          })
        })
      },
      openDelete() {
        this.deleteDialogVisible = true
        this.tempDeleteYear = undefined
        this.tempProvice = undefined
        this.tempCity = undefined
      },
      getTree() {
        this.listLoading = true
        getTree(this.companyCode).then(res => {
          this.list = res.data
          this.listLoading = false
          // if (this.list.length > 0) {
          //   this.recursive(this.list)
          // }
        })
      },
      recursive(data) {
        data.forEach(ele => {
          ele.systemName = this.systemName
          // 判断有子元素,并且子元素的长度大于0就再次调用自身
          if (ele.children && ele.children.length > 0) {
            this.recursive(ele.children)
          }
        })
      },
      handleDelete(row) {
        delById(row.id).then(res => {
          this.$notify({
            title: '成功',
            message: '删除成功',
            type: 'success',
            duration: 1500
          })
          this.getTree(this.page)
        })
      },
      add(type) {
        this.dialogVisible = true
        this.type = type
      },
      confimAdd() {
        let params = {
          systemCode: this.systemCode,
          parentResourceCode: this.parentResourceCode,
          resourceCode: this.resourceCode,
          type: this.type,
          name: this.name,
          url: this.url,
          path: this.path,
          permission: this.permission,
          icon: this.icon,
          available: this.available == true ? 1 : 0
        }
        editObj(params).then(res => {
          this.$notify({
            title: '成功',
            message: '添加成功',
            type: 'success',
            duration: 1500
          })
          this.dialogVisible = false
          this.getTree()
        })
      },
      handleUpdate(row) {
        this.fileList = [];
        getById(row.id).then(res => {
          this.dialogVisible = true
          this.title = row.title
          this.content = row.content
          this.id = row.id
          if (res.data && res.data.files.length > 0) {
            res.data.files.forEach(ele => {
              let item = {};
              item.name = ele.fileName;
              item.url = ele.fileKey;
              this.fileList.push(item);
            })
          }
        })
      },
      handleAdd(row) {
        this.parentResourceCode = row.resourceCode
        this.add(parseInt(row.type) + 1);
        console.log(parseInt(row.type) + 1)
      },
      handleUplodeSuccess(res, file) {
        // this.uplodeFlag = false
        // this.uplodeUrl = res.data
        // this.imageUrl = URL.createObjectURL(file.raw)
        let param = {};
        param.name = file.name;
        param.url = res.data;
        param.fileType = file.raw.type;
        this.fileList.push(param);
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
      handleRemove(file, fileList) {
        // console.info(file);
        // console.info( fileList);
        const index = this.fileList.findIndex(ele => ele.url === file.url);
        this.fileList.splice(position, 1);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
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

  .text-left {
    text-align: left;
  }
</style>



