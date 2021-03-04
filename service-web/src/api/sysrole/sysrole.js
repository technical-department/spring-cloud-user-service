import request from '@/utils/request'

export function transferList() {
  return request({
    url: '/user-center/sysrole/transferList',
    method: 'get'
  })
}

export function roleTree() {
  return request({
    url: '/user-center/sysrole/role/tree',
    method: 'get'
  })
}

export function addRole(params) {
  return request({
    url: '/user-center/sysrole',
    method: 'post',
    data: params
  })
}

export function delById(id) {
  return request({
    url: '/web/baseinfo/' + id,
    method: 'delete'
  })
}

export function editObj(params) {
  return request({
    url: '/user-center/baseinfo',
    method: 'post',
    data: params
  })
}

