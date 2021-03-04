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
      label: '视频地址',
      prop: 'videoUrl'
    }, {
      label: '标题',
      prop: 'msg'
    }, {
      label: '副标题',
      prop: 'otherMsg'
    }, {
      label: '类型',
      prop: 'videoType',
      slot: true,
      type: 'select',
      dicData: [{
        label: '资料视频讲解',
        value: 0
      }, {
        label: '志愿大讲堂',
        value: 1
      }, {
        label: '师兄师姐说专业',
        value: 2
      }]
    }, {
      label: '排序',
      prop: 'orderNum'
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
