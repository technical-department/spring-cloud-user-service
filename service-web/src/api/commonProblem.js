import request from '@/utils/request'

export function queryList(query) {
  return request({
    url: '/web/commonProblem',
    method: 'get',
    params: query
  })
}

export function updateStatus(id, status) {
  return request({
    url: '/web/commonProblem/updateStatus',
    method: 'get',
    params: {
      id,
      status
    }
  })
}

export function delObject(id) {
  return request({
    url: '/web/commonProblem/delObj/' + id,
    method: 'get'
  })
}

export function addObj(question, answer, orderId, status) {
  return request({
    url: '/web/commonProblem/addObj',
    method: 'post',
    data: {
      question,
      answer,
      orderId,
      status
    }
  })
}
