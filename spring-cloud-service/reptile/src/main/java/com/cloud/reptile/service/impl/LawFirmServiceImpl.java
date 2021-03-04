package com.cloud.reptile.service.impl;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.cloud.reptile.dao.LawFirmDao;
import com.cloud.reptile.model.LawFirm;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.reptile.service.LawFirmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:律师事务所
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
@Service
public class LawFirmServiceImpl extends ServiceImpl<LawFirmDao, LawFirm> implements LawFirmService {

	@Autowired
	LawFirmDao lawFirmDao;
	
	@Override
	public LawFirm findById(Long id) {
		return lawFirmDao.selectById(id);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void insertObj(LawFirm lawFirm) {
		lawFirmDao.insert(lawFirm);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(LawFirm lawFirm) {
		lawFirmDao.updateById(lawFirm);

	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(LawFirm lawFirm) {
		lawFirmDao.updateById(lawFirm);
	}

	@Override
	public LawFirm findOneByObj(LawFirm lawFirm) {
		QueryWrapper<LawFirm> qw = new QueryWrapper<LawFirm>(lawFirm);
		return lawFirmDao.selectOne(qw);
	}

	@Override
	public List<LawFirm> findByObj(LawFirm lawFirm) {
		QueryWrapper<LawFirm> qw = new QueryWrapper<LawFirm>(lawFirm);
		return lawFirmDao.selectList(qw);
	}

	@Override
	public Page selectMyPage(Page page, Map<String, Object> params) {
		return lawFirmDao.selectMyPage(page, params);
	}

}
