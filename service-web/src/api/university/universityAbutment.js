import request from '@/utils/request'

export function queryObj(id) {
  return request({
    url: '/web/universityAbutment',
    method: 'get',
    params: {
      id
    }
  })
}

export function addObj(fkUniversityId, evaluate, contact, detail) {
  return request({
    url: '/web/universityAbutment/addObj',
    method: 'post',
    data: {
      fkUniversityId,
      evaluate,
      contact,
      detail
    }
  })
}
