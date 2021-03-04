import request from '@/utils/request'

export function login(params) {
  return request({
    url: '/sys/login',
    method: 'post',
    data: params
  })
}

export function getInfo() {
  return request({
    url: '/user-center/sysuser/info',
    method: 'get'
  })
}

