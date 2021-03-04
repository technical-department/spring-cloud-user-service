package com.cloud.reptile.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.reptile.model.GrassrootLegalService;
import com.cloud.reptile.dao.GrassrootLegalServiceDao;
import com.cloud.reptile.service.GrassrootLegalServiceService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:基层法律服务所
 * </p>
 * @author chenyouhong
 * @date 2021-02-27
 */
@Service
public class GrassrootLegalServiceServiceImpl extends ServiceImpl<GrassrootLegalServiceDao, GrassrootLegalService> implements GrassrootLegalServiceService {

	@Autowired
	GrassrootLegalServiceDao grassrootLegalServiceDao;
	
	@Override
	public GrassrootLegalService findById(Long grassrootLegalServiceId) {
		return grassrootLegalServiceDao.selectById(grassrootLegalServiceId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertObj(GrassrootLegalService grassrootLegalService) {
		grassrootLegalServiceDao.insert(grassrootLegalService);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(GrassrootLegalService grassrootLegalService) {
		grassrootLegalServiceDao.updateById(grassrootLegalService);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(GrassrootLegalService grassrootLegalService) {
		grassrootLegalServiceDao.updateById(grassrootLegalService);
	}

	@Override
	public GrassrootLegalService findOneByObj(GrassrootLegalService grassrootLegalService) {
		QueryWrapper<GrassrootLegalService> qw = new QueryWrapper<GrassrootLegalService>(grassrootLegalService);
		return grassrootLegalServiceDao.selectOne(qw);
	}

	@Override
	public List<GrassrootLegalService> findByObj(GrassrootLegalService grassrootLegalService) {
		QueryWrapper<GrassrootLegalService> qw = new QueryWrapper<GrassrootLegalService>(grassrootLegalService);
		return grassrootLegalServiceDao.selectList(qw);
	}

	@Override
	public Page selectMyPage(Page page, Map<String, Object> params) {
		return grassrootLegalServiceDao.selectMyPage(page, params);
	}

}
