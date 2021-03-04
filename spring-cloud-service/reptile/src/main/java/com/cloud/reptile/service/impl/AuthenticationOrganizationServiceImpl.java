package com.cloud.reptile.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.reptile.model.AuthenticationOrganization;
import com.cloud.reptile.dao.AuthenticationOrganizationDao;
import com.cloud.reptile.service.AuthenticationOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:鉴定机构
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
@Service
public class AuthenticationOrganizationServiceImpl extends ServiceImpl<AuthenticationOrganizationDao, AuthenticationOrganization> implements AuthenticationOrganizationService {

	@Autowired
	AuthenticationOrganizationDao authenticationOrganizationDao;
	
	@Override
	public AuthenticationOrganization findById(Long authenticationOrganizationId) {
		return authenticationOrganizationDao.selectById(authenticationOrganizationId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertObj(AuthenticationOrganization authenticationOrganization) {
		authenticationOrganizationDao.insert(authenticationOrganization);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(AuthenticationOrganization authenticationOrganization) {
		authenticationOrganizationDao.updateById(authenticationOrganization);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(AuthenticationOrganization authenticationOrganization) {
		authenticationOrganizationDao.updateById(authenticationOrganization);
	}

	@Override
	public AuthenticationOrganization findOneByObj(AuthenticationOrganization authenticationOrganization) {
		QueryWrapper<AuthenticationOrganization> qw = new QueryWrapper<AuthenticationOrganization>(authenticationOrganization);
		return authenticationOrganizationDao.selectOne(qw);
	}

	@Override
	public List<AuthenticationOrganization> findByObj(AuthenticationOrganization authenticationOrganization) {
		QueryWrapper<AuthenticationOrganization> qw = new QueryWrapper<AuthenticationOrganization>(authenticationOrganization);
		return authenticationOrganizationDao.selectList(qw);
	}

	@Override
	public Page selectMyPage(Page page, Map<String, Object> params) {
		return authenticationOrganizationDao.selectMyPage(page, params);
	}

}
