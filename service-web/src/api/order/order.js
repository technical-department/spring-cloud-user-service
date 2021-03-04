import request from '@/utils/request'

export function pageList(query) {
  return request({
    url: '/web/order',
    method: 'get',
    params: query
  })
}
