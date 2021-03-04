import request from '@/utils/request'

export function queryList(query) {
  return request({
    url: '/web/user',
    method: 'get',
    params: query
  })
}

