package com.cloud.reptile.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.reptile.model.Mediator;
import com.cloud.reptile.dao.MediatorDao;
import com.cloud.reptile.service.MediatorService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:调解员
 * </p>
 * @author chenyouhong
 * @date 2021-02-27
 */
@Service
public class MediatorServiceImpl extends ServiceImpl<MediatorDao, Mediator> implements MediatorService {

	@Autowired
	MediatorDao mediatorDao;
	
	@Override
	public Mediator findById(Long mediatorId) {
		return mediatorDao.selectById(mediatorId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertObj(Mediator mediator) {
		mediatorDao.insert(mediator);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(Mediator mediator) {
		mediatorDao.updateById(mediator);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(Mediator mediator) {
		mediatorDao.updateById(mediator);
	}

	@Override
	public Mediator findOneByObj(Mediator mediator) {
		QueryWrapper<Mediator> qw = new QueryWrapper<Mediator>(mediator);
		return mediatorDao.selectOne(qw);
	}

	@Override
	public List<Mediator> findByObj(Mediator mediator) {
		QueryWrapper<Mediator> qw = new QueryWrapper<Mediator>(mediator);
		return mediatorDao.selectList(qw);
	}

	@Override
	public Page selectMyPage(Page page, Map<String, Object> params) {
		return mediatorDao.selectMyPage(page, params);
	}

}
