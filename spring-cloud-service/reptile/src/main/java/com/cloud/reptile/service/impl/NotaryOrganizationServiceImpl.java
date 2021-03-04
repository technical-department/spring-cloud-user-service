package com.cloud.reptile.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.reptile.model.NotaryOrganization;
import com.cloud.reptile.dao.NotaryOrganizationDao;
import com.cloud.reptile.service.NotaryOrganizationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:公证机构
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
@Service
public class NotaryOrganizationServiceImpl extends ServiceImpl<NotaryOrganizationDao, NotaryOrganization> implements NotaryOrganizationService {

	@Autowired
	NotaryOrganizationDao notaryOrganizationDao;
	
	@Override
	public NotaryOrganization findById(Long notaryOrganizationId) {
		return notaryOrganizationDao.selectById(notaryOrganizationId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertObj(NotaryOrganization notaryOrganization) {
		notaryOrganizationDao.insert(notaryOrganization);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(NotaryOrganization notaryOrganization) {
		notaryOrganizationDao.updateById(notaryOrganization);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(NotaryOrganization notaryOrganization) {
		notaryOrganizationDao.updateById(notaryOrganization);
	}

	@Override
	public NotaryOrganization findOneByObj(NotaryOrganization notaryOrganization) {
		QueryWrapper<NotaryOrganization> qw = new QueryWrapper<NotaryOrganization>(notaryOrganization);
		return notaryOrganizationDao.selectOne(qw);
	}

	@Override
	public List<NotaryOrganization> findByObj(NotaryOrganization notaryOrganization) {
		QueryWrapper<NotaryOrganization> qw = new QueryWrapper<NotaryOrganization>(notaryOrganization);
		return notaryOrganizationDao.selectList(qw);
	}

	@Override
	public Page selectMyPage(Page page, Map<String, Object> params) {
		return notaryOrganizationDao.selectMyPage(page, params);
	}

}
