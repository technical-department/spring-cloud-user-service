import request from '@/utils/request'

export function queryList(query) {
  return request({
    url: '/web/userFeedBack',
    method: 'get',
    params: query
  })
}

export function updateStatus(id, status) {
  return request({
    url: '/web/userFeedBack/updateStatus',
    method: 'get',
    params: {
      id,
      status
    }
  })
}

