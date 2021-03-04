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
      label: '图片',
      prop: 'imgUrl',
      slot: true
    }, {
      label: '类型',
      prop: 'imgType',
      slot: true,
      type: 'select',
      dicData: [{
        label: '首页',
        value: 0
      }, {
        label: '师兄师姐说专业',
        value: 1
      }]
    },
    {
      label: '状态',
      prop: 'status',
      slot: true,
      type: 'select',
      dicData: [{
        label: '启用',
        value: 0
      }, {
        label: '禁用',
        value: 1
      }]
    },
    {
      label: '创建时间',
      prop: 'gmtCreate',
      type: 'date',
      format: 'yyyy-MM-dd hh:mm:ss',
      valueFormat: 'yyyy-MM-dd hh:mm:ss'
    }
  ]
}
