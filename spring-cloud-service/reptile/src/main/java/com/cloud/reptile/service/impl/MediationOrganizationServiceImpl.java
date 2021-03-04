package com.cloud.reptile.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.reptile.model.MediationOrganization;
import com.cloud.reptile.dao.MediationOrganizationDao;
import com.cloud.reptile.service.MediationOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:调解机构
 * </p>
 * @author chenyouhong
 * @date 2021-02-27
 */
@Service
public class MediationOrganizationServiceImpl extends ServiceImpl<MediationOrganizationDao, MediationOrganization> implements MediationOrganizationService {

	@Autowired
	MediationOrganizationDao mediationOrganizationDao;
	
	@Override
	public MediationOrganization findById(Long mediationOrganizationId) {
		return mediationOrganizationDao.selectById(mediationOrganizationId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertObj(MediationOrganization mediationOrganization) {
		mediationOrganizationDao.insert(mediationOrganization);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(MediationOrganization mediationOrganization) {
		mediationOrganizationDao.updateById(mediationOrganization);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(MediationOrganization mediationOrganization) {
		mediationOrganizationDao.updateById(mediationOrganization);
	}

	@Override
	public MediationOrganization findOneByObj(MediationOrganization mediationOrganization) {
		QueryWrapper<MediationOrganization> qw = new QueryWrapper<MediationOrganization>(mediationOrganization);
		return mediationOrganizationDao.selectOne(qw);
	}

	@Override
	public List<MediationOrganization> findByObj(MediationOrganization mediationOrganization) {
		QueryWrapper<MediationOrganization> qw = new QueryWrapper<MediationOrganization>(mediationOrganization);
		return mediationOrganizationDao.selectList(qw);
	}

	@Override
	public Page selectMyPage(Page page, Map<String, Object> params) {
		return mediationOrganizationDao.selectMyPage(page, params);
	}

}
