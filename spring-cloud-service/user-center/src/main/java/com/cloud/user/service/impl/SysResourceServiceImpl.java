package com.cloud.user.service.impl;


import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.user.dto.RoleResourceTree;
import com.cloud.user.mapper.SysResourceMapper;
import com.cloud.user.model.SysResource;
import com.cloud.user.model.SysRoleResources;
import com.cloud.user.service.SysResourceService;
import com.cloud.user.service.SysRoleResourcesService;
import com.cloud.user.service.SysRoleService;
import com.common.constants.Constants;
import com.common.util.ListTransferTree;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mergeplus.core.MergeCore;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * <p>
 * Title: SysResourceServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
@Service
@Slf4j
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements SysResourceService {

	@Autowired
	private SysResourceMapper sysResourceMapper;

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysRoleResourcesService sysRoleResourcesService;

	public List<SysResource> findBySystemCode(String systemCode) {
		SysResource sysResource = new SysResource();
		sysResource.setSystemCode(systemCode);
		Wrapper<SysResource> wrapper = new LambdaQueryWrapper<>(sysResource);
		return sysResourceMapper.selectList(wrapper);
	}

	public SysResource findByResourceCode(String resourceCode) {
		SysResource sysResource = new SysResource();
		sysResource.setResourceCode(resourceCode);
		Wrapper<SysResource> wrapper = new LambdaQueryWrapper<>(sysResource);
		return sysResourceMapper.selectOne(wrapper);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysResourceService#findTreeLst(java.lang.String)
	 */
	@Override
//	@ServiceLog(description = "findTreeLst")
	public List<SysResource> findTreeLst(String systemCode) throws Exception {
		List<SysResource> sysResources = this.findBySystemCode(systemCode);
		if (CollectionUtils.isEmpty(sysResources)) {
			return sysResources;
		}
		try {
//			mergeCore.mergeResult(SysResource.class, all);
		}
		catch (Exception e) {
			e.printStackTrace();
		}


		SysResource sysResource = new SysResource();
		new ListTransferTree(sysResources, sysResource, SysResource::getResourceCode, SysResource::getParentResourceCode, SysResource::getChildren)
				.tree();

		return sysResource.getChildren();
	}

	@Override
	public RoleResourceTree findResourceBySystemCodeAndRoleCode(String systemCode, String roleCode) throws Exception {
		List<SysResource> sysResources = sysResourceMapper.findResourceBySystemCodeAndRoleCode(systemCode, roleCode);
		if (CollectionUtils.isEmpty(sysResources)) {
			return null;
		}
		RoleResourceTree roleResourceTree = new RoleResourceTree();
		List<String> resourceTreeCheckedKeys = sysResources.stream().filter(e -> StringUtils.isNotBlank(e.getSelectedResourceCode())).map(e -> e.getSelectedResourceCode()).collect(Collectors.toList());
		roleResourceTree.setResourceTreeCheckedKeys(resourceTreeCheckedKeys);
		SysResource sysResource = new SysResource();
		new ListTransferTree(sysResources, sysResource, SysResource::getResourceCode, SysResource::getParentResourceCode, SysResource::getChildren)
				.tree();

		roleResourceTree.setSysResources(sysResource.getChildren());
		return roleResourceTree;
	}

	@Override
	public List<SysResource> findSysResourceBySystemCodeAndUserCode(String systemCode, String userCode) throws Exception {
		List<SysResource> sysResources = sysResourceMapper.findSysResourceBySystemCodeAndUserCode(systemCode, userCode);
		if (CollectionUtils.isEmpty(sysResources)) {
			return null;
		}
		SysResource sysResource = new SysResource();
		new ListTransferTree(sysResources, sysResource, SysResource::getResourceCode, SysResource::getParentResourceCode, SysResource::getChildren)
				.tree();

		return sysResource.getChildren();
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void edit(SysResource sysResource) throws Exception {
		if (StringUtils.isNotBlank(sysResource.getResourceCode())) {
			SysResource query = this.findByResourceCode(sysResource.getResourceCode());
			sysResource.setId(query.getId());
		}
		this.saveOrUpdate(sysResource);
		if (StringUtils.isBlank(sysResource.getResourceCode())) {
			sysResource.setResourceCode(sysResource.getId().toString());
			if (sysResource.getSeq() == null) {
				sysResource.setSeq(sysResource.getId().intValue());
			}
		}
		this.saveOrUpdate(sysResource);
	}

}
