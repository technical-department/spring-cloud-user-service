import request from '@/utils/request'

export function queryList(query) {
  return request({
    url: '/web/chapter/all',
    method: 'get',
    params: query
  })
}

export function delById(id) {
  return request({
    url: '/web/chapter/' + id,
    method: 'delete'
  })
}

export function addObj(title, content, files, parentCode) {
  return request({
    url: '/web/chapter',
    method: 'post',
    data: {
      parentCode,
      title,
      content,
      files
    }
  })
}

export function editObj(id, title, content, files) {
  return request({
    url: '/web/chapter',
    method: 'put',
    data: {
      id,
      title,
      content,
      files
    }
  })
}

export function getById(id) {
  return request({
    url: '/web/chapter/' + id,
    method: 'get'
  })
}
