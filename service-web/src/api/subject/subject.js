import request from '@/utils/request'

export function queryList(query) {
  return request({
    url: '/web/subject',
    method: 'get',
    params: query
  })
}

export function delById(id) {
  return request({
    url: '/web/subject/delById/' + id,
    method: 'get'
  })
}

export function addObj(uplodeUrl) {
  return request({
    url: '/web/subject/addObj',
    method: 'get',
    params: {
      uplodeUrl
    }
  })
}

export function checkPrecent(uplodeUrl) {
  return request({
    url: '/web/subject/checkPrecent',
    method: 'get',
    params: {
      uplodeUrl
    }
  })
}

