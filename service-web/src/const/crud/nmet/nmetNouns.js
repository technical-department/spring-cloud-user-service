export const tableOption = {
  border: true,
  index: true,
  expandLevel: 3,
  headerAlign: 'center',
  align: 'center',
  tree: true,
  editBtn: false,
  delBtn: false,
  column: [
    {
      label: '名词',
      prop: 'title'
    }, {
      label: '解释',
      prop: 'content'
    }, {
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
      valueFormat: 'yyyy-MM-dd hh:mm:ss',
      addDisplay: false,
      editDisplay: false
    }
  ]
}
