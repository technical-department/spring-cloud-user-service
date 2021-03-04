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
      label: '系统编码',
      prop: 'systemCode',
      search: false
    }, {
      label: '系统名称',
      prop: 'systemName',
      search: true
    }, {
      label: '创建时间',
      prop: 'createTime',
      type: 'date',
      format: 'yyyy-MM-dd hh:mm:ss',
      valueFormat: 'yyyy-MM-dd hh:mm:ss',
      addDisplay: false,
      editDisplay: false
    }
  ]
}
