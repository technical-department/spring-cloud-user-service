import request from '@/utils/request'

export function videoList(query) {
  return request({
    url: '/web/volunteerTemplate',
    method: 'get',
    params: query
  })
}

export function updateStatus(id, status) {
  return request({
    url: '/web/volunteerTemplate/updateStatus',
    method: 'get',
    params: {
      id,
      status
    }
  })
}

export function delById(id) {
  return request({
    url: '/web/volunteerTemplate/delById/' + id,
    method: 'get'
  })
}

export function addObj(fkProviceId, isArts, rankType, title, fileType, fileUrl) {
  return request({
    url: '/web/volunteerTemplate/addObj',
    method: 'post',
    data: {
      fkProviceId,
      isArts,
      rankType,
      title,
      fileUrl,
      fileType
    }
  })
}
