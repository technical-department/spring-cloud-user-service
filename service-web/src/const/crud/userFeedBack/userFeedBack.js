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
      label: '手机号',
      prop: 'userPhone'
    }, {
      label: '详情',
      prop: 'detailMsg'
    }, {
      label: '反馈图片1',
      prop: 'imgUrl1',
      slot: true
    }, {
      label: '反馈图片2',
      prop: 'imgUrl2',
      slot: true
    }, {
      label: '反馈图片3',
      prop: 'imgUrl3',
      slot: true
    }, {
      label: '状态',
      prop: 'status',
      slot: true,
      type: 'select',
      dicData: [{
        label: '未处理',
        value: 0
      }, {
        label: '已处理',
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
