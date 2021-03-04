import request from '@/utils/request'

export function queryList(query) {
  return request({
    url: '/web/nmet/supplement',
    method: 'get',
    params: query
  })
}

export function delById(id) {
  return request({
    url: '/web/nmet/supplement/delById/' + id,
    method: 'get'
  })
}

export function addObj(tempProviceId, uplodeUrl) {
  return request({
    url: '/web/nmet/supplement/addObj',
    method: 'get',
    params: {
      tempProviceId,
      uplodeUrl
    }
  })
}

export function checkPrecent(uplodeUrl) {
  return request({
    url: '/web/nmet/supplement/checkPrecent',
    method: 'get',
    params: {
      uplodeUrl
    }
  })
}

export function deleteBatch(proviceId, isArts, year) {
  return request({
    url: '/web/nmet/supplement/deleteBatch',
    method: 'post',
    data: {
      proviceId,
      isArts,
      year
    }
  })
}

