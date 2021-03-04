import request from '@/utils/request'

export function queryPage(query) {
  return request({
    url: '/user-center/baseinfo/page',
    method: 'post',
    data: query
  })
}

export function queryList() {
  return request({
    url: '/user-center/baseinfo/adminsys',
    method: 'get'
  })
}

export function getMySystem() {
  return request({
    url: '/user-center/baseinfo/my/system',
    method: 'get'
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

export function getById(id) {
  return request({
    url: '/web/chapter/' + id,
    method: 'get'
  })
}
