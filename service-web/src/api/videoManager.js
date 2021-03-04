import request from '@/utils/request'

export function videoList(query) {
  return request({
    url: '/web/video',
    method: 'get',
    params: query
  })
}

export function updateStatus(id, status) {
  return request({
    url: '/web/video/updateStatus',
    method: 'get',
    params: {
      id,
      status
    }
  })
}

export function delById(id) {
  return request({
    url: '/web/video/delById/' + id,
    method: 'get'
  })
}

export function addObj(imgUrl, videoUrl, msg, videoType) {
  return request({
    url: '/web/video/addObj',
    method: 'post',
    data: {
      imgUrl,
      videoUrl,
      msg,
      videoType
    }
  })
}
