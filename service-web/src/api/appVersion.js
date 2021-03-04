import request from '@/utils/request'

export function queryList(query) {
  return request({
    url: '/web/version',
    method: 'get',
    params: query
  })
}

export function delById(id) {
  return request({
    url: '/web/version/delById/' + id,
    method: 'get'
  })
}

export function addObj(uplodeUrl, version, forceFlag) {
  return request({
    url: '/web/version/addObj',
    method: 'post',
    data: {
      appUrl: uplodeUrl,
      version: version,
      forceFlag: forceFlag
    }
  })
}
