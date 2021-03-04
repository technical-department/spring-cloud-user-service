package com.cloud.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.user.mapper.SysRoleResourcesMapper;
import com.cloud.user.model.SysRole;
import com.cloud.user.model.SysRoleResources;
import com.cloud.user.service.SysRoleResourcesService;
import com.cloud.user.service.SysRoleService;
import com.cloud.user.vo.SysRoleResourceVo;
import com.common.enums.ResultEnum;
import com.common.exception.BusinessException;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title: SysRoleResourcesServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2018-05-21
 */
@Service
@Slf4j
public class SysRoleResourcesServiceImpl extends ServiceImpl<SysRoleResourcesMapper, SysRoleResources> implements SysRoleResourcesService {

	@Autowired
	private SysRoleResourcesMapper sysRoleResourcesMapper;

	@Autowired
	private SysRoleService sysRoleService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysRoleResourcesService#insertObj(com.cloud.user.model.
	 * SysRoleResources)
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
//	@ServiceLog(description = "插入对象")
	public void insertObj(SysRoleResources sysRoleResources) {
		sysRoleResourcesMapper.insert(sysRoleResources);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysRoleResourcesService#updateObj(com.cloud.user.model.
	 * SysRoleResources)
	 */
	@Override
//	@ServiceLog(description = "更新对象")
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(SysRoleResources sysRoleResources) {
		sysRoleResourcesMapper.updateById(sysRoleResources);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysRoleResourcesService#deleteObj(com.cloud.user.model.
	 * SysRoleResources)
	 */
	@Override
//	@ServiceLog(description = "删除对象")
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(SysRoleResources sysRoleResources) {
		sysRoleResourcesMapper.updateById(sysRoleResources);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysRoleResourcesService#findByObj(com.cloud.user.model.
	 * SysRoleResources)
	 */
	@Override
//	@ServiceLog(description = "findByObj")
	public List<SysRoleResources> findByObj(SysRoleResources sysRoleResources) {
//		Map<String, Object> columnMap = BeanCloneUtilsExt.copyTohumpToLine(sysRoleResources);
//		return baseMapper.selectByMap(columnMap);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysRoleResourcesService#getByObj(com.cloud.user.model.
	 * SysRoleResources)
	 */
	@Override
//	@ServiceLog(description = "findOneByObj")
	public SysRoleResources findOneByObj(SysRoleResources sysRoleResources) {
//		return sysRoleResourcesMapper.selectOne(sysRoleResources);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cloud.user.service.SysRoleResourcesService#selectMyPage(com.baomidou.mybatisplus.
	 * plugins.Page, java.util.Map)
	 */
	@Override
	public Page selectMyPage(Page page, Map<String, Object> params) {
//		page.setRecords(sysRoleResourcesMapper.selectMyPage((RowBounds) page, params));
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
	public void editResource(SysRoleResourceVo vo) throws Exception {
		SysRole sysRole = sysRoleService.findSysRoleByRoleCode(vo.getRoleCode());
		if (sysRole == null) {
			throw new BusinessException(ResultEnum.FAIL.getCode(), "角色不存在");
		}

		List<SysRoleResources> sysRoleResources = Lists.newArrayList();
		vo.getResourceCodes().forEach(e -> {
			SysRoleResources sysRoleResource = new SysRoleResources();
			sysRoleResource.setRoleCode(vo.getRoleCode());
			sysRoleResource.setResourceCode(e);
			sysRoleResources.add(sysRoleResource);
		});

		this.deleteResourceByRoleCode(vo.getRoleCode());
		this.saveBatch(sysRoleResources);
	}

	@Transactional(rollbackFor = Exception.class)
	public void deleteResourceByRoleCode(String roleCode) throws Exception {
		SysRoleResources sysRoleResource = new SysRoleResources();
		sysRoleResource.setRoleCode(roleCode);
		Wrapper<SysRoleResources> wrapper = new LambdaQueryWrapper<>(sysRoleResource);
		sysRoleResourcesMapper.delete(wrapper);
	}

	public List<SysRoleResources> findSysRoleResource(SysRoleResources sysRoleResource) throws Exception {
		Wrapper<SysRoleResources> wrapper = new LambdaQueryWrapper(sysRoleResource);
		return sysRoleResourcesMapper.selectList(wrapper);
	}

	@Override
	public List<SysRoleResources> findSysRoleResourceByRoleCode(String roleCode) throws Exception {
		SysRoleResources sysRoleResources = new SysRoleResources();
		sysRoleResources.setRoleCode(roleCode);
		return this.findSysRoleResource(sysRoleResources);
	}

}
