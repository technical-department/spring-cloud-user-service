package com.cloud.reptile.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.reptile.model.Identifier;
import com.cloud.reptile.dao.IdentifierDao;
import com.cloud.reptile.service.IdentifierService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:鉴定员
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
@Service
public class IdentifierServiceImpl extends ServiceImpl<IdentifierDao, Identifier> implements IdentifierService {

	@Autowired
	IdentifierDao identifierDao;
	
	@Override
	public Identifier findById(Long identifierId) {
		return identifierDao.selectById(identifierId);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertObj(Identifier identifier) {
		identifierDao.insert(identifier);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(Identifier identifier) {
		identifierDao.updateById(identifier);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(Identifier identifier) {
		identifierDao.updateById(identifier);
	}

	@Override
	public Identifier findOneByObj(Identifier identifier) {
		QueryWrapper<Identifier> qw = new QueryWrapper<Identifier>(identifier);
		return identifierDao.selectOne(qw);
	}

	@Override
	public List<Identifier> findByObj(Identifier identifier) {
		QueryWrapper<Identifier> qw = new QueryWrapper<Identifier>(identifier);
		return identifierDao.selectList(qw);
	}

	@Override
	public Page selectMyPage(Page page, Map<String, Object> params) {
		return identifierDao.selectMyPage(page, params);
	}

}
