package com.cloud.reptile.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.reptile.model.DictionaryRegion;
import com.cloud.reptile.dao.DictionaryRegionDao;
import com.cloud.reptile.service.DictionaryRegionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:地区国标
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
@Service
public class DictionaryRegionServiceImpl extends ServiceImpl<DictionaryRegionDao, DictionaryRegion> implements DictionaryRegionService {

	@Autowired
	DictionaryRegionDao dictionaryRegionDao;
	
	@Override
	public DictionaryRegion findById(Long id) {
		return dictionaryRegionDao.selectById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertObj(DictionaryRegion dictionaryRegion) {
		dictionaryRegionDao.insert(dictionaryRegion);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(DictionaryRegion dictionaryRegion) {
		dictionaryRegionDao.updateById(dictionaryRegion);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(DictionaryRegion dictionaryRegion) {
		dictionaryRegionDao.updateById(dictionaryRegion);
	}

	@Override
	public DictionaryRegion findOneByObj(DictionaryRegion dictionaryRegion) {
		QueryWrapper<DictionaryRegion> qw = new QueryWrapper<DictionaryRegion>(dictionaryRegion);
		return dictionaryRegionDao.selectOne(qw);
	}

	@Override
	public List<DictionaryRegion> findByObj(DictionaryRegion dictionaryRegion) {
		QueryWrapper<DictionaryRegion> qw = new QueryWrapper<DictionaryRegion>(dictionaryRegion);
		return dictionaryRegionDao.selectList(qw);
	}

	@Override
	public Page selectMyPage(Page page, Map<String, Object> params) {
		return dictionaryRegionDao.selectMyPage(page, params);
	}

}
