import request from '@/utils/request'

export function msgList(query) {
  return request({
    url: '/web/msgnotify',
    method: 'get',
    params: query
  })
}

export function updateStatus(id, status) {
  return request({
    url: '/web/msgnotify/updateStatus',
    method: 'get',
    params: {
      id,
      status
    }
  })
}

export function delMsgnotify(id) {
  return request({
    url: '/web/msgnotify/delMsgnotify/' + id,
    method: 'get'
  })
}

export function addMsgnotify(msg, status, redirectUrl) {
  return request({
    url: '/web/msgnotify/addMsgnotify',
    method: 'post',
    data: {
      msg,
      status,
      redirectUrl
    }
  })
}
