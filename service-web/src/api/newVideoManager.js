import request from '@/utils/request'

export function videoList(query) {
  return request({
    url: '/web/newVideo',
    method: 'get',
    params: query
  })
}

export function updateStatus(id, status) {
  return request({
    url: '/web/newVideo/updateStatus',
    method: 'get',
    params: {
      id,
      status
    }
  })
}

export function delById(id) {
  return request({
    url: '/web/newVideo/delById/' + id,
    method: 'get'
  })
}

export function addObj(imgUrl, videoUrl, msg, videoType, otherMsg, orderNum, videoTime, videlNum) {
  return request({
    url: '/web/newVideo/addObj',
    method: 'post',
    data: {
      imgUrl,
      videoUrl,
      msg,
      videoType,
      otherMsg,
      orderNum,
      videoTime,
      videlNum
    }
  })
}

export function queryObj(id) {
  return request({
    url: '/web/newVideo/queryObj',
    method: 'get',
    params: {
      id
    }
  })
}

export function updateDetailMsg(id, detailMsg) {
  return request({
    url: '/web/newVideo/updateDetailMsg',
    method: 'post',
    data: {
      id,
      detailMsg
    }
  })
}

