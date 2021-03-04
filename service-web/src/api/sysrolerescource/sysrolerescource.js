import request from '@/utils/request'

export function editResource(params) {
  return request({
    url: '/user-center/sysRoleResources',
    method: 'post',
    data: params
  })
}
