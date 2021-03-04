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
      label: '省份',
      prop: 'provice',
      search: true
    },
    {
      label: '城市',
      prop: 'city',
      search: true
    },
    {
      label: '区域',
      prop: 'area'
    },
    {
      label: '年份',
      prop: 'year',
      search: true
    },
    {
      label: '类型',
      prop: 'type',
      slot: true,
      search: true,
      type: 'select',
      dicData: [{
        label: '公务员',
        value: 0
      }, {
        label: '事业单位',
        value: 1
      }, {
        label: '国企',
        value: 2
      }]
    },
    {
      label: '单位名称',
      prop: 'companyName'
    },
    {
      label: '职位名称',
      prop: 'positionName'
    },
    {
      label: '专业限制',
      prop: 'subjectClassify'
    },
    {
      label: '地点',
      prop: 'address'
    }, {
      label: '人数',
      prop: 'userNum'
    }, {
      label: '要求',
      prop: 'requirement'
    }, {
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
