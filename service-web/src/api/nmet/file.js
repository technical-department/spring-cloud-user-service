import request from '@/utils/request'

export function videoList(query) {
  return request({
    url: '/web/pdfManager',
    method: 'get',
    params: query
  })
}

export function updateStatus(id, status) {
  return request({
    url: '/web/pdfManager/updateStatus',
    method: 'get',
    params: {
      id,
      status
    }
  })
}

export function delById(id) {
  return request({
    url: '/web/pdfManager/delById/' + id,
    method: 'get'
  })
}

export function addObj(title, fileType, fileUrl) {
  return request({
    url: '/web/pdfManager/addObj',
    method: 'post',
    data: {
      title,
      fileUrl,
      fileType
    }
  })
}
