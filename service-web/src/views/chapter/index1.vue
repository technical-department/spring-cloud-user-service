<template>
  <div style="margin-top: 20px;">
    <avue-crud :option="option" :table-loading="listLoading" :data="list" :page="page" @search-change="searchChange" @on-load="getList" @refresh-change="getList">
      <template slot="menuLeft">
        <el-button type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="add">添加</el-button>
      </template>
      <template slot="menu" slot-scope="scope">
        <el-button size="small" type="text" icon="el-icon-edit" @click="handleUpdate(scope.row)">编辑</el-button>
        <el-divider direction="vertical" />
        <el-button size="small" type="text" icon="el-icon-delete" @click="handleDelete(scope.row.id)">删除</el-button>
      </template>
    </avue-crud>
    <el-dialog
      title="添加"
      :visible.sync="dialogVisible"
      width="60%"
      style="text-align: center;"
    >
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="标题">
          <el-input v-model="title" />
        </el-form-item>
        <el-form-item label="内容">
          <el-input type="textarea" v-model="content" />
        </el-form-item>
        <el-form-item label="图片上传">
          <el-upload
            class="avatar-uploader"
            action="http://www.zhishieducation.cn:40000/web/uplode/uplode"
            list-type="picture-card"
            :file-list="fileList"
            :on-preview="handlePictureCardPreview"
            :on-success="handleUplodeSuccess"
            :on-remove="handleRemove"
          >
            <img v-if="imageUrl" :src="imageUrl" class="avatar">
            <i v-else class="el-icon-plus" />
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
  import { tableOption } from '@/const/crud/chapter/chapter'
  import { queryList, delById, addObj, editObj, getById } from '@/api/chapter/chapter'
  export default {
    name: 'Chapter',
    data() {
      return {
        option: tableOption,
        page: {
          total: 0,
          currentPage: 1,
          pageSize: 20,
          isAsc: false
        },
        title: undefined,
        content: undefined,
        id: undefined,
        imageUrl: undefined,
        list: [],
        listLoading: true,
        dialogVisible: false,
        dialogPrecentVisible: false,
        progressStatus: undefined,
        progressNum: 0,
        uplodeUrl: undefined,
        form: {},
        fileList: [],
        deleteDialogVisible: false,
      }
    },
    computed: {
    },
    methods: {
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
          this.searchChange()
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
      add() {
        this.id = undefined;
        this.dialogVisible = true
        this.uplodeUrl = undefined
        this.title=undefined
        this.content=undefined
        this.fileList = []
      },
      confimAdd() {
        if (!this.title) {
          this.$message.error('标题不能为空')
          return
        }

        if (!this.content) {
          this.$message.error('内容不能为空')
          return
        }

        let files = [];
        if (this.fileList.length > 0) {
          this.fileList.forEach(ele => {
            let param = {};
            param.fileName = ele.name;
            param.fileKey = ele.url;
            param.fileType = ele.fileType;
            files.push(param);
          })
        }

        if (this.id) {
          editObj(this.id, this.title, this.content, files).then(res => {
            this.$notify({
              title: '成功',
              message: '编辑成功',
              type: 'success',
              duration: 1500
            })
            this.dialogVisible = false
            this.searchChange()
          })
        } else {
          addObj(this.title, this.content, files).then(res => {
            this.$notify({
              title: '成功',
              message: '添加成功',
              type: 'success',
              duration: 1500
            })
            this.dialogVisible = false
            this.searchChange()
          })
        }
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
        this.fileList.splice(index, 1);
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
</style>



