import request from '@/utils/request'

export function getClassifyList() {
  return request({
    url: '/web/subject/getClassifyList',
    method: 'get'
  })
}

export function getTopListByClassifyName(classifyName) {
  return request({
    url: '/web/subject/getTopListByClassifyName',
    method: 'get',
    params: {
      classifyName
    }
  })
}

export function getSubjectList(classifyName, topName) {
  return request({
    url: '/web/subject/getSubjectList',
    method: 'get',
    params: {
      classifyName,
      topName
    }
  })
}

export function queryList(query) {
  return request({
    url: '/web/subject/hotPage',
    method: 'get',
    params: query
  })
}

export function delById(id) {
  return request({
    url: '/web/subject/subjectHot/delById/' + id,
    method: 'get'
  })
}

export function addObj(fkSubjectId, avatar, content, pdfUrl, collegeMainType, isArts) {
  return request({
    url: '/web/subject/subjectHot/addObj',
    method: 'post',
    data: {
      fkSubjectId,
      avatar,
      content,
      pdfUrl,
      collegeMainType,
      isArts
    }
  })
}

