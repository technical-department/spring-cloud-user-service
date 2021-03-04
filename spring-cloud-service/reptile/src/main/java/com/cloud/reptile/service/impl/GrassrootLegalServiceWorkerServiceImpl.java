package com.cloud.reptile.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.reptile.model.GrassrootLegalServiceWorker;
import com.cloud.reptile.dao.GrassrootLegalServiceWorkerDao;
import com.cloud.reptile.service.GrassrootLegalServiceWorkerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:法律服务工作者
 * </p>
 * @author chenyouhong
 * @date 2021-02-27
 */
@Service
public class GrassrootLegalServiceWorkerServiceImpl extends ServiceImpl<GrassrootLegalServiceWorkerDao, GrassrootLegalServiceWorker> implements GrassrootLegalServiceWorkerService {

	@Autowired
	GrassrootLegalServiceWorkerDao grassrootLegalServiceWorkerDao;
	
	@Override
	public GrassrootLegalServiceWorker findById(Long laywerId) {
		return grassrootLegalServiceWorkerDao.selectById(laywerId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertObj(GrassrootLegalServiceWorker grassrootLegalServiceWorker) {
		grassrootLegalServiceWorkerDao.insert(grassrootLegalServiceWorker);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(GrassrootLegalServiceWorker grassrootLegalServiceWorker) {
		grassrootLegalServiceWorkerDao.updateById(grassrootLegalServiceWorker);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(GrassrootLegalServiceWorker grassrootLegalServiceWorker) {
		grassrootLegalServiceWorkerDao.updateById(grassrootLegalServiceWorker);
	}

	@Override
	public GrassrootLegalServiceWorker findOneByObj(GrassrootLegalServiceWorker grassrootLegalServiceWorker) {
		QueryWrapper<GrassrootLegalServiceWorker> qw = new QueryWrapper<GrassrootLegalServiceWorker>(grassrootLegalServiceWorker);
		return grassrootLegalServiceWorkerDao.selectOne(qw);
	}

	@Override
	public List<GrassrootLegalServiceWorker> findByObj(GrassrootLegalServiceWorker grassrootLegalServiceWorker) {
		QueryWrapper<GrassrootLegalServiceWorker> qw = new QueryWrapper<GrassrootLegalServiceWorker>(grassrootLegalServiceWorker);
		return grassrootLegalServiceWorkerDao.selectList(qw);
	}

	@Override
	public Page selectMyPage(Page page, Map<String, Object> params) {
		return grassrootLegalServiceWorkerDao.selectMyPage(page, params);
	}

}
