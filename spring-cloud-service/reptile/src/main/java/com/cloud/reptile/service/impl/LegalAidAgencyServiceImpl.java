package com.cloud.reptile.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.reptile.model.LegalAidAgency;
import com.cloud.reptile.dao.LegalAidAgencyDao;
import com.cloud.reptile.service.LegalAidAgencyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:法律援助中心
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
@Service
public class LegalAidAgencyServiceImpl extends ServiceImpl<LegalAidAgencyDao, LegalAidAgency> implements LegalAidAgencyService {

	@Autowired
	LegalAidAgencyDao legalAidAgencyDao;
	
	@Override
	public LegalAidAgency findById(Long laywerId) {
		return legalAidAgencyDao.selectById(laywerId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertObj(LegalAidAgency legalAidAgency) {
		legalAidAgencyDao.insert(legalAidAgency);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(LegalAidAgency legalAidAgency) {
		legalAidAgencyDao.updateById(legalAidAgency);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(LegalAidAgency legalAidAgency) {
		legalAidAgencyDao.updateById(legalAidAgency);
	}

	@Override
	public LegalAidAgency findOneByObj(LegalAidAgency legalAidAgency) {
		QueryWrapper<LegalAidAgency> qw = new QueryWrapper<LegalAidAgency>(legalAidAgency);
		return legalAidAgencyDao.selectOne(qw);
	}

	@Override
	public List<LegalAidAgency> findByObj(LegalAidAgency legalAidAgency) {
		QueryWrapper<LegalAidAgency> qw = new QueryWrapper<LegalAidAgency>(legalAidAgency);
		return legalAidAgencyDao.selectList(qw);
	}

	@Override
	public Page selectMyPage(Page page, Map<String, Object> params) {
		return legalAidAgencyDao.selectMyPage(page, params);
	}

}
