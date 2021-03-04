import request from '@/utils/request'

export function videoList(query) {
  return request({
    url: '/web/publicExamination',
    method: 'get',
    params: query
  })
}

export function delById(id) {
  return request({
    url: '/web/publicExamination/delById/' + id,
    method: 'get'
  })
}

export function addObj(fkProviceId, avatar, pdfUrl) {
  return request({
    url: '/web/publicExamination/addObj',
    method: 'post',
    data: {
      fkProviceId,
      avatar,
      pdfUrl
    }
  })
}
