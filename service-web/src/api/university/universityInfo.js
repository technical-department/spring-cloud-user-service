import request from '@/utils/request'

export function queryObj(id) {
  return request({
    url: '/web/universityInfo',
    method: 'get',
    params: {
      id
    }
  })
}

export function addObj(fkUniversityId, website, phone, address, doctorAddress, masterAddress, survey, abroadAbutment, scientificPlatform, jobAbutment) {
  return request({
    url: '/web/universityInfo/addObj',
    method: 'post',
    data: {
      fkUniversityId,
      website,
      phone,
      address,
      doctorAddress,
      masterAddress,
      survey,
      abroadAbutment,
      scientificPlatform,
      jobAbutment
    }
  })
}

