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
      label: '订单号',
      prop: 'orderId',
      search: true
    }, {
      label: '支付类型',
      prop: 'payType',
      slot: true
    }, {
      label: '金额',
      prop: 'paymentAmount'
    }, {
      label: '手机号',
      prop: 'phone',
      search: true
    }, {
      label: '商品描述',
      prop: 'descripe'
    }, {
      label: '第三方',
      prop: 'transactionId',
      search: true
    },
    {
      label: '创建时间',
      prop: 'gmtCreate',
      type: 'date',
      format: 'yyyy-MM-dd hh:mm:ss',
      valueFormat: 'yyyy-MM-dd hh:mm:ss',
      addDisplay: false,
      editDisplay: false
    },
    {
      label: '支付时间',
      prop: 'gmtUpdate',
      type: 'date',
      format: 'yyyy-MM-dd hh:mm:ss',
      valueFormat: 'yyyy-MM-dd hh:mm:ss',
      addDisplay: false,
      editDisplay: false
    }
  ]
}
