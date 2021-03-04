package com.cloud.reptile.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.reptile.model.Laywer;
import com.cloud.reptile.dao.LaywerDao;
import com.cloud.reptile.service.LaywerService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:律师
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
@Service
public class LaywerServiceImpl extends ServiceImpl<LaywerDao, Laywer> implements LaywerService {

	@Autowired
	LaywerDao laywerDao;
	
	@Override
	public Laywer findById(Long laywerId) {
		return laywerDao.selectById(laywerId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertObj(Laywer laywer) {
		laywerDao.insert(laywer);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(Laywer laywer) {
		laywerDao.updateById(laywer);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(Laywer laywer) {
		laywerDao.updateById(laywer);
	}

	@Override
	public Laywer findOneByObj(Laywer laywer) {
		QueryWrapper<Laywer> qw = new QueryWrapper<Laywer>(laywer);
		return laywerDao.selectOne(qw);
	}

	@Override
	public List<Laywer> findByObj(Laywer laywer) {
		QueryWrapper<Laywer> qw = new QueryWrapper<Laywer>(laywer);
		return laywerDao.selectList(qw);
	}

	@Override
	public Page selectMyPage(Page page, Map<String, Object> params) {
		return laywerDao.selectMyPage(page, params);
	}

}
