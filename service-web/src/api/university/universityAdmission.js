import request from '@/utils/request'

export function queryList(query) {
  return request({
    url: '/web/university/subjectAdmission',
    method: 'get',
    params: query
  })
}

export function delById(id) {
  return request({
    url: '/web/university/subjectAdmission/delById/' + id,
    method: 'get'
  })
}

export function addObj(universitySubjectId, proviceId, isArts, batchNum, year, maxScore, minScore, averageScore, userNum) {
  return request({
    url: '/web/university/subjectAdmission/addObj',
    method: 'post',
    data: {
      universitySubjectId,
      proviceId,
      isArts,
      batchNum,
      year,
      maxScore,
      minScore,
      averageScore,
      userNum
    }
  })
}

export function batchAdd(universitySubjectId, uplodeUrl) {
  return request({
    url: '/web/university/subjectAdmission/batchAdd',
    method: 'post',
    data: {
      universitySubjectId,
      uplodeUrl
    }
  })
}

export function checkPrecent(uplodeUrl) {
  return request({
    url: '/web/university/subjectAdmission/checkPrecent',
    method: 'get',
    params: {
      uplodeUrl
    }
  })
}

