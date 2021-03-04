export const tableOption = {
  border: true,
  index: true,
  expandLevel: 3,
  headerAlign: 'center',
  align: 'center',
  tree: true,
  addBtn: false,
  editBtn: false,
  delBtn: false,
  menu: true,
  column: [
    {
      label: '用户编码',
      prop: 'userCode',
      search: true
    }, {
      label: '真实姓名',
      prop: 'userName',
      search: true
    }, {
      label: '所属部门',
      prop: 'departName',
      search: true
    }, {
      label: '所属岗位',
      prop: 'positionName',
      search: false
    }, {
      label: '手机号',
      prop: 'userMobile',
      search: true
    }, {
      label: '更新时间',
      prop: 'updateTime',
      type: 'date',
      format: 'yyyy-MM-dd hh:mm:ss',
      valueFormat: 'yyyy-MM-dd hh:mm:ss',
      addDisplay: false,
      editDisplay: false
    }
  ]
}
