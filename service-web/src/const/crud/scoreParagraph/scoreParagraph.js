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
  menu: false,
  column: [
    {
      label: '省份',
      prop: 'fkProviceId',
      slot: true,
      search: true,
      type: 'select',
      dicData: [{
        label: '北京市',
        value: 1
      }, {
        label: '天津市',
        value: 2
      }, {
        label: '上海市',
        value: 3
      }, {
        label: '重庆市',
        value: 4
      }, {
        label: '河北省',
        value: 5
      }, {
        label: '山西省',
        value: 6
      }, {
        label: '辽宁省',
        value: 7
      }, {
        label: '吉林省',
        value: 8
      }, {
        label: '黑龙江省',
        value: 9
      }, {
        label: '江苏省',
        value: 10
      }, {
        label: '浙江省',
        value: 11
      }, {
        label: '安徽省',
        value: 12
      }, {
        label: '福建省',
        value: 13
      }, {
        label: '江西省',
        value: 14
      }, {
        label: '山东省',
        value: 15
      }, {
        label: '河南省',
        value: 16
      }, {
        label: '湖北省',
        value: 17
      }, {
        label: '湖南省',
        value: 18
      }, {
        label: '广东省',
        value: 19
      }, {
        label: '海南省',
        value: 20
      }, {
        label: '四川省',
        value: 21
      }, {
        label: '贵州省',
        value: 22
      }, {
        label: '云南省',
        value: 23
      }, {
        label: '陕西省',
        value: 24
      }, {
        label: '甘肃省',
        value: 25
      }, {
        label: '青海省',
        value: 26
      }, {
        label: '西藏自治区',
        value: 27
      }, {
        label: '广西壮自治区',
        value: 28
      }, {
        label: '内蒙古自治区',
        value: 29
      }, {
        label: '宁夏回族自治区',
        value: 30
      }, {
        label: '新疆维吾尔自治区',
        value: 31
      }, {
        label: '香港',
        value: 32
      }, {
        label: '澳门',
        value: 33
      }, {
        label: '台湾省',
        value: 34
      }]
    }, {
      label: '文理科',
      prop: 'isArts',
      slot: true,
      search: true,
      type: 'select',
      dicData: [{
        label: '文科',
        value: 0
      }, {
        label: '理科',
        value: 1
      }]
    }, {
      label: '年份',
      prop: 'year',
      search: true
    }, {
      label: '分数',
      prop: 'score'
    }, {
      label: '人数',
      prop: 'userNum'
    }, {
      label: '累计人数',
      prop: 'allNum'
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
