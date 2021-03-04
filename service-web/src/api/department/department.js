import request from '@/utils/request'

export function getTree(companyCode) {
  return request({
    url: '/user-center/organization/tree/' + companyCode,
    method: 'get'
  })
}


