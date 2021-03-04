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
      label: '标题',
      prop: 'title'
    }, {
      label: '文件地址',
      prop: 'fileUrl'
    }, {
      label: '文件类型',
      prop: 'fileType',
      slot: true,
      type: 'select',
      dicData: [{
        label: 'app使用',
        value: 0
      }, {
        label: '报道入学',
        value: 1
      }, {
        label: '历年专业目录',
        value: 2
      }]
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
