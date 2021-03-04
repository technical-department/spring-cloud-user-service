import request from '@/utils/request'

export function bannerList(query) {
  return request({
    url: '/web/banner',
    method: 'get',
    params: query
  })
}

export function updateStatus(id, status) {
  return request({
    url: '/web/banner/updateStatus',
    method: 'get',
    params: {
      id,
      status
    }
  })
}

export function delBanner(id) {
  return request({
    url: '/web/banner/delBanner/' + id,
    method: 'get'
  })
}

export function addBanner(imgType,imgUrl) {
  return request({
    url: '/web/banner/addBanner',
    method: 'get',
    params: {
      imgType,
      imgUrl
    }
  })
}

export function generatorActivityCode() {
  return request({
    url: '/web/banner/generatorActivityCode',
    method: 'get'
  })
}

export function getStatistics() {
  return request({
    url: '/web/banner/getStatistics',
    method: 'get'
  })
}

export function getPayConfigration() {
  return request({
    url: '/web/banner/getPayConfigration',
    method: 'get'
  })
}

export function savePayConfigration(payConfig) {
  return request({
    url: '/web/banner/savePayConfigration',
    method: 'get',
    params: {
      payConfig
    }
  })
}

export function getIOSPayConfigration(payConfig) {
  return request({
    url: '/web/banner/getIOSPayConfigration',
    method: 'get'
  })
}

export function getSmartReportConfigration(payConfig) {
  return request({
    url: '/web/banner/getSmartReportConfigration',
    method: 'get'
  })
}

export function updateIOSPayConfigration(status) {
  return request({
    url: '/web/banner/updateIOSPayConfigration',
    method: 'get',
    params: {
      status
    }
  })
}
export function updateSmartReportConfigration(status) {
  return request({
    url: '/web/banner/updateSmartReportConfigration',
    method: 'get',
    params: {
      status
    }
  })
}
