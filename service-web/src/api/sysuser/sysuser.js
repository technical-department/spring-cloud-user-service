import request from '@/utils/request'

export function queryPage(query) {
  return request({
    url: '/user-center/sysuser/page',
    method: 'post',
    data: query
  })
}

export function getByUserCode(userCode) {
  return request({
    url: '/user-center/sysuser/setrole/' + userCode,
    method: 'get'
  })
}

export function setRole(params) {
  return request({
    url: '/user-center/sysuser/setrole',
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

// export function editObj(id, title, content, files) {
//   return request({
//     url: '/web/chapter',
//     method: 'put',
//     data: {
//       id,
//       title,
//       content,
//       files
//     }
//   })
// }

// export function getById(id) {
//   return request({
//     url: '/user-center/sysuser/setrole/' + id,
//     method: 'get'
//   })
// }
