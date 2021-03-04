<template>
  <div style="margin-top: 20px;">
    <div id="dataPage" class="el-col-8">
      <el-tree
          id="el-tree"
          class=" el-col-offset-2"
          :data="data"
          node-key="code"
          :props="defaultProps"
          @node-click="nodeClick"
          @node-contextmenu="rightClick"/>
      <vue-context-menu
        :target="contextMenuTarget"
        :show="contextMenuVisible"
        class="tree-right-menu"
        @update:show="(show) => contextMenuVisible = show">
        <a href="javascript:;" @click="createRole">
          <i class="el-icon-circle-plus-outline red-color" ></i>&nbsp;<span class="font-color">新增角色</span>
        </a>
      </vue-context-menu>
    </div>
    <div class="el-col-16">
      <el-form label-width="80px">
        <el-tree
          ref="resourceTree"
          :data="resourceTree"
          :default-checked-keys="resourceTreeCheckedKeys"
          :default-expanded-keys="resourceTreeExpandedKeys"
          show-checkbox
          node-key="resourceCode"
          :props="resourceTreeProps">
        </el-tree>
      </el-form>
      <div
        title="确 定"
        v-if="confimVisible" :visible.sync="confimVisible"
        width="30%"
        style="text-align: center;"
      >
        <el-button :visible.sync="confimVisible" type="primary" style="margin-top: 20px;margin-left: 20px;" size="small" @click="confim">确 定</el-button>
      </div>
    </div>

    <el-dialog
      title="新增角色"
      :visible.sync="dialogVisible"
      width="60%"
      style="text-align: center;"
    >
      <el-form ref="form" :model="form" label-width="80px">
        <el-form-item label="当前选中">
          <el-input v-model="systemName" disabled />
        </el-form-item>
        <el-form-item label="新增角色">
          <el-input v-model="roleName"/>
        </el-form-item>
        <el-form-item label="备注">
          <el-input v-model="roleRemark"/>
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
  import { roleTree, addRole } from '@/api/sysrole/sysrole'
  import { getResource } from '@/api/sysrescource/sysrescource'
  import { editResource } from '@/api/sysrolerescource/sysrolerescource'
  import { component as VueContextMenu } from '@xunlei/vue-context-menu';

  export default {
    name: 'Sysrole',
    components: {
      'vue-context-menu': VueContextMenu,
    },
    data() {
      return {
        form: {},
        confimVisible: false,
        list: [],
        listLoading: true,
        dialogVisible: false,
        dialogPrecentVisible: false,
        roleName: undefined,
        roleRemark: undefined,
        systemCode: undefined,
        roleCode: undefined,
        systemName: undefined,
        treeNodeData: '', // 存当前数据
        treeNode: '', // 存当前节点信息
        contextMenuVisible: false, // 让菜单显示
        contextMenuTarget: null,
        data: [],
        defaultProps: {
          children: 'children',
          label: 'name'
        },
        resourceTree: [],
        resourceTreeCheckedKeys: [],
        resourceTreeExpandedKeys: [],
        resourceTreeProps: {
          children: 'children',
          label: 'name'
        }
      }
    },
    computed: {
    },
    created() {
      this.roleTree()
    },
    methods: {
      rightClick(e, data, node) {
        if (!data.systemType) {
          return
        }
        this.treeNodeData = data;// 存当前数据
        this.treeNode = node;// 存当前节点信息
        // console.log('rightClick', this.treeNodeData, this.treeNode);
        this.contextMenuVisible = true;// 让菜单显示
        // console.log('0', e, '1', e.screenX, '2', e.screenY);
        const ele = document.querySelector('.tree-right-menu');
        ele.style.top = (e.clientY - 100) + 'px'; //根据鼠标点击位置设置菜单出现
        ele.style.left = 30 + 'px';
      },
      nodeClick(e, data, node) {
        if (data.data.systemType != undefined) {
          this.resourceTree = []
          this.confimVisible = false
          return
        }

        this.systemCode = data.data.systemCode
        this.roleCode = data.data.code

        getResource(data.data.systemCode, data.data.code).then(res => {
          this.resourceTree = []
          this.confimVisible = false
          if (res.data) {
            this.resourceTree = res.data.sysResources
            this.resourceTreeCheckedKeys = res.data.resourceTreeCheckedKeys
            res.data.sysResources.forEach((item, i) => {
              this.resourceTreeExpandedKeys.push(item.resourceCode)
            })
            this.confimVisible = true
          }
        })
      },
      createRole() {
        this.contextMenuVisible = false;
        this.dialogVisible = true

        this.systemName = this.treeNodeData.name
        this.systemCode = this.treeNodeData.code
        // console.log('createRole', this.treeNodeData, this.treeNode);

      },
      deleteDatabaseOrTable() {
        this.contextMenuVisible = false;
        console.log('deleteDatabaseOrTable', this.treeNodeData, this.treeNode);
      },
      roleTree() {
        this.listLoading = true
        roleTree().then(res => {
          this.listLoading = false
          this.data = res.data
        })
      },
      confim() {
        let params = {}
        params.roleCode = this.roleCode
        params.resourceCodes = this.$refs.resourceTree.getCheckedKeys()

        editResource(params).then(res => {
          this.$notify({
            title: '成功',
            message: '成功',
            type: 'success',
            duration: 1500
          })
        })
      },
      confimAdd() {
        let params = {}
        params.systemCode = this.systemCode
        params.roleName = this.roleName
        params.roleRemark = this.roleRemark

        addRole(params).then(res => {
          this.dialogVisible = false
          this.$notify({
            title: '成功',
            message: '成功',
            type: 'success',
            duration: 1500
          })
        })
      }
    }
  }
</script>
<style>
  .red-color {
    color: red;
  }
  .font-color {
    color: #409EFF;
  }
  #dataPage {
    margin: 0 0;
    text-align: center;
    color: #2c3e50;
    height: 100%;
    position: relative;
  }
  /*// 右键会选中文字，为了美观将它禁用*/
   #el-tree{
     user-select:none;
   }

  .tree-right-menu {
    font-size: 14px;
    width: 150px;
    position: absolute;
    background: #fff;
    border: solid 1px rgba(0, 0, 0, .2);
    border-radius: 3px;
    z-index: 999;
    display: none;
    border: 1px solid #eee;
    box-shadow: 0 0.5em 1em 0 rgba(0,0,0,.1);
    border-radius: 1px;
  }
  .tree-right-menu a {
    height: 28px;
    line-height: 28px;
    text-align: center;
    display: block;
    color: #1a1a1a;
    padding: 2px;
  }
  .tree-right-menu a:hover {
    background: #bbb;
    color: #fff;
  }
  a {
    text-decoration: none;
  }

</style>
