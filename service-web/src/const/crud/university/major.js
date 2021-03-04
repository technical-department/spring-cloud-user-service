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
      label: '学科门类',
      prop: 'classifyName',
      search: true
    }, {
      label: '一级学科',
      prop: 'topName',
      search: true
    }, {
      label: '二级学科',
      prop: 'subjectName',
      search: true
    }, {
      label: '备注',
      prop: 'remark'
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
