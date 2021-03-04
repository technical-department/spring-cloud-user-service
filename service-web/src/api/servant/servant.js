import request from '@/utils/request'

export function queryList(query) {
  return request({
    url: '/web/servant',
    method: 'get',
    params: query
  })
}

export function delById(id) {
  return request({
    url: '/web/servant/delById/' + id,
    method: 'get'
  })
}

export function addObj(uplodeUrl) {
  return request({
    url: '/web/servant/addObj',
    method: 'post',
    data: {
      uplodeUrl
    }
  })
}

export function checkPrecent(uplodeUrl) {
  return request({
    url: '/web/servant/checkPrecent',
    method: 'get',
    params: {
      uplodeUrl
    }
  })
}
export function deleteBatch(year,provice,city) {
  return request({
    url: '/web/servant/deleteBatch',
    method: 'get',
    params: {
      year,
      provice,
      city
    }
  })
}


