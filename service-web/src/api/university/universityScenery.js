import request from '@/utils/request'

export function queryList(query) {
  return request({
    url: '/web/universityScenery',
    method: 'get',
    params: query
  })
}

export function delById(id) {
  return request({
    url: '/web/universityScenery/delById/' + id,
    method: 'get'
  })
}

export function addObj(tempId, fkUniversityId, title, area, imgUrl) {
  return request({
    url: '/web/universityScenery/addObj',
    method: 'post',
    data: {
      tempId,
      fkUniversityId,
      title,
      area,
      imgUrl
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

