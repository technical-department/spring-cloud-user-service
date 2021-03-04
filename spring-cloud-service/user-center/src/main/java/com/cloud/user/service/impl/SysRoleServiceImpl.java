package com.cloud.user.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.user.mapper.SysRoleMapper;
import com.cloud.user.model.SysBaseInfo;
import com.cloud.user.model.SysRole;
import com.cloud.user.model.SysRoleResources;
import com.cloud.user.service.SysBaseInfoService;
import com.cloud.user.service.SysRoleResourcesService;
import com.cloud.user.service.SysRoleService;
import com.cloud.user.service.SysUserService;
import com.cloud.user.vo.SysRoleVo;
import com.common.constants.Constants;
import com.common.exception.BusinessException;
import com.common.util.BeanCloneUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * <p>
 * Title: SysRoleServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
@Slf4j
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {

	@Autowired
	private SysRoleMapper sysRoleMapper;

	@Autowired
	private SysBaseInfoService sysBaseInfoService;

//	@Autowired
//	private SysRoleResourcesService sysRoleResourcesService;
	
//	@Autowired
//	private SysUserService sysUserService;
	
//	@Autowired
//	private SysPositionRoleService sysPositionRoleService;
//
//	@Autowired
//	private SysChangeLogService sysChangeLogService;

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysRoleService#insertObj(com.cloud.user.model.SysRole)
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
//	@ServiceLog(description = "插入对象")
	public void insertObj(SysRole sysRole) {
		sysRoleMapper.insert(sysRole);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysRoleService#updateObj(com.cloud.user.model.SysRole)
	 */
	@Override
//	@ServiceLog(description = "更新对象")
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(SysRole sysRole) {
		sysRoleMapper.updateById(sysRole);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysRoleService#deleteObj(com.cloud.user.model.SysRole)
	 */
	@Override
//	@ServiceLog(description = "删除对象")
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(SysRole sysRole) throws Exception {
		// 无效才能删除
		SysRole role = sysRoleMapper.selectById(sysRole.getId());
		if (role != null && role.getStatus().intValue() == Constants.YES) {
			throw new BusinessException("xxx", "请先置无效，再删除");
		}
		sysRoleMapper.deleteById(sysRole.getId());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysRoleService#findByObj(com.cloud.user.model.SysRole)
	 */
	@Override
//	@ServiceLog(description = "findByObj")
	public List<SysRole> findByObj(SysRole sysRole) {
		Wrapper<SysRole> wrapper = new LambdaQueryWrapper<>(sysRole);
		return sysRoleMapper.selectList(wrapper);
	}

	@Override
	public SysRole findSysRoleByRoleCode(String roleCode) {
		SysRole sysRole = new SysRole();
		sysRole.setRoleCode(roleCode);
		Wrapper<SysRole> wrapper = new LambdaQueryWrapper<>(sysRole);
		return sysRoleMapper.selectOne(wrapper);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysRoleService#getByObj(com.cloud.user.model.SysRole)
	 */
	@Override
//	@ServiceLog(description = "findOneByObj")
	public SysRole findOneByObj(SysRole sysRole) {
//		return sysRoleMapper.selectOne(sysRole);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cloud.user.service.SysRoleService#selectMyPage(com.baomidou.mybatisplus.plugins.
	 * Page, java.util.Map)
	 */
	@Override
	public Page selectMyPage(Page page, Map<String, Object> params) {
//		page.setRecords(sysRoleMapper.selectMyPage((RowBounds) page, params));
		return page;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysRoleService#selectByUserId(java.lang.Long)
	 */
	@Override
	public List<SysRole> findLstByUserCode(String userCode) {
		return sysRoleMapper.findLstByUserCode(userCode);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysRoleService#selectAllById(java.lang.Long)
	 */
	@Override
	public SysRole selectAllResourceByRoleCode(String roleCode) throws Exception {
//		SysRole role = selectById(id);
//		if (role == null) {
//			throw new BusinessException("xxx", "no data");
//		}
//		SysRoleResources sysRoleResources = new SysRoleResources();
//		sysRoleResources.setRoleId(id);
//		List<SysRoleResources> resourceLst = sysRoleResourcesService.findByObj(sysRoleResources);
//		if (CollectionUtils.isNotEmpty(resourceLst)) {
//			List<Long> resourcesIds = resourceLst.parallelStream().map(x -> x.getResourceId()).distinct()
//					.collect(Collectors.toList());
//			role.setResourcesIds(resourcesIds);
//		}
		return new SysRole();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysRoleService#findAllAvailable()
	 */
	@Override
	public List<SysRole> findAllAvailable() {
		SysRole search = new SysRole();
		search.setStatus(Constants.STATUS_YES);
		List<SysRole> roleLst = findByObj(search);
		List<SysBaseInfo> baseInfoLst = sysBaseInfoService.findAllSys();
		Map<String, String> baseMap = baseInfoLst.parallelStream()
				.collect(Collectors.toMap(SysBaseInfo::getSystemCode, SysBaseInfo::getSystemName));
		for (SysRole sysRole : roleLst) {
			sysRole.setSystemName(baseMap.get(sysRole.getSystemCode()));
		}
		return roleLst;
	}

	@Override
	public List<SysRole> findLstByPositionId(Long positionId) {
		return baseMapper.findLstByPositionId(positionId);
	}

	@Override
	public List<SysRole> findLstByPositionIds(List<Long> positionIds) {
		return baseMapper.findLstByPositionIds(positionIds);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void add(SysRoleVo vo) throws Exception {
		SysRole sysRole = BeanCloneUtils.copyTo(vo, SysRole.class);
		sysRoleMapper.insert(sysRole);
		sysRole.setRoleCode(sysRole.getId().toString());
		sysRoleMapper.updateById(sysRole);
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
//	@ServiceLog(description = "addMy")
	public void addMy(SysRole add) throws Exception {
//		OAuth2PrincipalUserDetails principalUser = SecurityUtils.getCurrentPrincipal();
//		SysUserVO vo = sysUserService.findMoreByUserCode(principalUser.getUserCode());
//		if(vo==null){
//			throw new BusinessException("没有该用户");
//		}
//		this.insertObj(add);
//		List<SysComDepPositionDTO> orgLst =vo.getOrgLst();
//		if(CollectionUtils.isNotEmpty(orgLst)){
//			for(SysComDepPositionDTO com:orgLst){
//				if(Constants.CONF_DEAPRTMENT_CODE.equals(com.getDepartment().getDepartCode())){
//					if(com.getPositionId()!=null){
//						Long positionId=com.getPositionId();
//						Wrapper<SysPositionRole> positionWrapper=new EntityWrapper<SysPositionRole>();
//						positionWrapper.eq("position_id", com.getPositionId());
//						List<SysPositionRole> positionRoles=sysPositionRoleService.selectList(positionWrapper);
//						if(CollectionUtils.isNotEmpty(positionRoles)){
//							List<Long> positionIds= Lists.newArrayList();
//							for(SysPositionRole role:positionRoles){
//								positionIds.add(role.getPositionId());
//							}
//							List<SysRole> roles=this.findLstByPositionIds(positionIds);
//							if(CollectionUtils.isNotEmpty(roles)){
//								Set<String> systemCodes= Sets.newConcurrentHashSet();
//								for(SysRole role:roles){
//									systemCodes.add(role.getSystemCode());
//								}
//								if(systemCodes.contains(add.getSystemCode())){
//									SysPositionRole pr=new SysPositionRole();
//									pr.setPositionId(positionId);
//									pr.setRoleId(add.getId());
//									sysPositionRoleService.insert(pr);
//								}
//							}
//						}
//					}
//				}
//			}
			
//		}
		
	}

	@Override
	public List<SysBaseInfo> getAllRolesTree() throws Exception {
		List<SysBaseInfo> sysBaseInfos = sysBaseInfoService.findAdminSys();
		if (CollectionUtils.isEmpty(sysBaseInfos)) {
			return sysBaseInfos;
		}
		List<SysRole> sysRoles = this.findAll();
		if (CollectionUtils.isEmpty(sysRoles)) {
			return sysBaseInfos;
		}
		Map<String, List<SysRole>> mapGroupBy = sysRoles.stream().collect(Collectors.groupingBy(SysRole::getSystemCode));
		sysBaseInfos.stream().forEach(e -> {
			e.setChildren(mapGroupBy.get(e.getSystemCode()));
		});

		return sysBaseInfos;
	}

	public List<SysRole> findAll() {
		SysRole sysRole = new SysRole();
		Wrapper<SysRole> wrapper = new LambdaQueryWrapper<>(sysRole);
		return sysRoleMapper.selectList(wrapper);
	}

}
