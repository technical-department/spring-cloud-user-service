import request from '@/utils/request'

export function queryList(query) {
  return request({
    url: '/web/scoreParagraph',
    method: 'get',
    params: query
  })
}

export function delById(id) {
  return request({
    url: '/web/scoreParagraph/delById/' + id,
    method: 'get'
  })
}

export function addObj(year, proviceId, isArts, uplodeUrl) {
  return request({
    url: '/web/scoreParagraph/addObj',
    method: 'post',
    data: {
      year,
      proviceId,
      isArts,
      uplodeUrl
    }
  })
}

export function checkPrecent(uplodeUrl) {
  return request({
    url: '/web/scoreParagraph/checkPrecent',
    method: 'get',
    params: {
      uplodeUrl
    }
  })
}

