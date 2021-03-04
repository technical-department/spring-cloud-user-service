import request from '@/utils/request'

export function queryList(query) {
  return request({
    url: '/web/universityMajor',
    method: 'get',
    params: query
  })
}

export function delById(id) {
  return request({
    url: '/web/universityMajor/delById/' + id,
    method: 'get'
  })
}

export function addObj(universityId, subjectId) {
  return request({
    url: '/web/universityMajor/addObj',
    method: 'get',
    params: {
      universityId,
      subjectId
    }
  })
}

export function getIntroduceDetail(id) {
  return request({
    url: '/web/universityMajor/getIntroduceDetail/' + id,
    method: 'get'
  })
}

export function updateIntroduce(majorId, introduce) {
  return request({
    url: '/web/universityMajor/updateIntroduce',
    method: 'post',
    data: {
      majorId,
      introduce
    }
  })
}

export function batchAdd(universityId, uplodeUrl) {
  return request({
    url: '/web/universityMajor/batchAdd',
    method: 'post',
    data: {
      universityId,
      uplodeUrl
    }
  })
}

export function checkPrecent(uplodeUrl) {
  return request({
    url: '/web/universityMajor/checkPrecent',
    method: 'get',
    params: {
      uplodeUrl
    }
  })
}

export function batchScoreAdd(universityId, uplodeUrl) {
  return request({
    url: '/web/universityMajor/batchScoreAdd',
    method: 'post',
    data: {
      universityId,
      uplodeUrl
    }
  })
}

export function checkScorePrecent(uplodeUrl) {
  return request({
    url: '/web/universityMajor/checkScorePrecent',
    method: 'get',
    params: {
      uplodeUrl
    }
  })
}
export function batchDelete(universityId) {
  return request({
    url: '/web/universityMajor/batchDelete',
    method: 'get',
    params: {
      universityId
    }
  })
}

export function batchScoreDelete(universityId, year) {
  return request({
    url: '/web/universityMajor/batchScoreDelete',
    method: 'get',
    params: {
      universityId,
      year
    }
  })
}
