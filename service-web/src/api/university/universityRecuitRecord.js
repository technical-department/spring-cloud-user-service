import request from '@/utils/request'

export function queryList(query) {
  return request({
    url: '/web/university/recruitRecord',
    method: 'get',
    params: query
  })
}

export function delById(id) {
  return request({
    url: '/web/university/recruitRecord/delById/' + id,
    method: 'get'
  })
}

export function addObj(proviceId, isArts, batchNum, year, uplodeUrl) {
  return request({
    url: '/web/university/recruitRecord/addObj',
    method: 'post',
    data: {
      proviceId,
      isArts,
      batchNum,
      year,
      uplodeUrl
    }
  })
}

export function deleteBatch(proviceId, isArts, batchNum, year) {
  return request({
    url: '/web/university/recruitRecord/deleteBatch',
    method: 'post',
    data: {
      proviceId,
      isArts,
      batchNum,
      year
    }
  })
}

export function checkPrecent(uplodeUrl) {
  return request({
    url: '/web/university/recruitRecord/checkPrecent',
    method: 'get',
    params: {
      uplodeUrl
    }
  })
}

