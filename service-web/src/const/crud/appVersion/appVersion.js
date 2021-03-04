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
  column: [
    {
      label: '版本号',
      prop: 'version'
    }, {
      label: '下载地址',
      prop: 'appUrl'
    }, {
      label: '是否强制',
      prop: 'status',
      slot: true,
      type: 'select',
      dicData: [{
        label: '不强制',
        value: 0
      }, {
        label: '强制',
        value: 1
      }]
    },{
      label: '创建时间',
      prop: 'gmtCreate',
      type: 'date',
      format: 'yyyy-MM-dd hh:mm:ss',
      valueFormat: 'yyyy-MM-dd hh:mm:ss',
      addDisplay: false,
      editDisplay: false
    }
  ]
}
