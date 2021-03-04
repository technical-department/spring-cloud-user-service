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
      label: '专业名称',
      prop: 'subjectName'
    },
    {
      label: '图片',
      prop: 'avatar',
      slot: true
    }, {
      label: 'pdf地址',
      prop: 'pdfUrl'
    }, {
      label: '描述',
      prop: 'content'
    }, {
      label: '本专科',
      prop: 'collegeMainType',
      slot: true,
      type: 'select',
      dicData: [{
        label: '本科',
        value: 0
      }, {
        label: '专科',
        value: 1
      }]
    },{
      label: '文理科',
      prop: 'isArts',
      slot: true,
      type: 'select',
      dicData: [{
        label: '文科',
        value: 0
      }, {
        label: '理科',
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
