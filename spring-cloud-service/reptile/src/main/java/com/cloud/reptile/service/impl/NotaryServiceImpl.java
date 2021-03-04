package com.cloud.reptile.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.reptile.model.Notary;
import com.cloud.reptile.dao.NotaryDao;
import com.cloud.reptile.service.NotaryService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:公证员
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
@Service
public class NotaryServiceImpl extends ServiceImpl<NotaryDao, Notary> implements NotaryService {

	@Autowired
	NotaryDao notaryDao;
	
	@Override
	public Notary findById(Long notaryOrganizationId) {
		return notaryDao.selectById(notaryOrganizationId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertObj(Notary notary) {
		notaryDao.insert(notary);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(Notary notary) {
		notaryDao.updateById(notary);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(Notary notary) {
		notaryDao.updateById(notary);
	}

	@Override
	public Notary findOneByObj(Notary notary) {
		QueryWrapper<Notary> qw = new QueryWrapper<Notary>(notary);
		return notaryDao.selectOne(qw);
	}

	@Override
	public List<Notary> findByObj(Notary notary) {
		QueryWrapper<Notary> qw = new QueryWrapper<Notary>(notary);
		return notaryDao.selectList(qw);
	}

	@Override
	public Page selectMyPage(Page page, Map<String, Object> params) {
		return notaryDao.selectMyPage(page, params);
	}

}
