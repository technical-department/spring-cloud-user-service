import request from '@/utils/request'

export function queryList(query) {
  return request({
    url: '/web/university',
    method: 'get',
    params: query
  })
}

export function delById(id) {
  return request({
    url: '/web/university/delById/' + id,
    method: 'get'
  })
}

export function addObj(tempId, name, proviceId, cityName, universityCode, collegeType, collegeAttibute, collegeMainType, avatar, nationalRank, categoryRank) {
  return request({
    url: '/web/university/addObj',
    method: 'post',
    data: {
      tempId,
      name,
      proviceId,
      cityName,
      universityCode,
      collegeType,
      collegeAttibute,
      collegeMainType,
      avatar,
      nationalRank,
      categoryRank
    }
  })
}

export function checkPrecent(uplodeUrl) {
  return request({
    url: '/web/scoreParagraph/checkPrecent',
    method: 'get',
    params: {
      uplodeUrl
    }
  })
}

