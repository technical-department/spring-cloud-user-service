import request from '@/utils/request'

export function getAllCompany() {
  return request({
    url: '/user-center/company/all',
    method: 'get'
  })
}


