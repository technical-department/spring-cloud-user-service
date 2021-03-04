import request from '@/utils/request'

export function queryList(query) {
  return request({
    url: '/web/nmet/nouns',
    method: 'get',
    params: query
  })
}

export function updateStatus(id, status) {
  return request({
    url: '/web/nmet/nouns/updateStatus',
    method: 'get',
    params: {
      id,
      status
    }
  })
}

export function delObject(id) {
  return request({
    url: '/web/nmet/nouns/delObj/' + id,
    method: 'get'
  })
}

export function addObj(title, content, status) {
  return request({
    url: '/web/nmet/nouns/addObj',
    method: 'post',
    data: {
      title,
      content,
      status
    }
  })
}
