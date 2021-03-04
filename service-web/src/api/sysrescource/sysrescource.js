import request from '@/utils/request'

export function getTree(systemCode) {
  return request({
    url: '/user-center/sysrescource/tree/' + systemCode,
    method: 'get',
  })
}

export function getResource(systemCode, roleCode) {
  return request({
    url: '/user-center/sysrescource/' + systemCode + '/' + roleCode,
    method: 'get',
  })
}

export function getSystemMenu(systemCode) {
  return request({
    url: '/user-center/sysrescource/menu/' + systemCode,
    method: 'get',
  })
}

export function editObj(params) {
  return request({
    url: '/user-center/sysrescource',
    method: 'post',
    data: params
  })
}
