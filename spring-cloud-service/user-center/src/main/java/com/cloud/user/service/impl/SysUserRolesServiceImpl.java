package com.cloud.user.service.impl;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.user.mapper.SysUserRolesMapper;
import com.cloud.user.model.SysBaseInfo;
import com.cloud.user.model.SysUser;
import com.cloud.user.model.SysUserRoles;
import com.cloud.user.service.SysUserRolesService;
import com.cloud.user.service.SysUserService;
import com.cloud.user.vo.SysUserSetRoleVo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title: SysUserRolesServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
@Service
@Slf4j
public class SysUserRolesServiceImpl extends ServiceImpl<SysUserRolesMapper, SysUserRoles> implements SysUserRolesService {

	@Autowired
	private SysUserRolesMapper sysUserRolesMapper;

//	@Autowired
//	private SysChangeLogService sysChangeLogService;
//
//	@Autowired
//	private SysUserService sysUserService;
//
//	@Autowired
//	private DozerBeanMapper dozerBeanMapper;
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cloud.user.service.SysUserRolesService#insertObj(com.cloud.user.model.SysUserRoles)
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
//	@ServiceLog(description = "插入对象")
	public void insertObj(SysUserRoles sysUserRoles) {
		sysUserRolesMapper.insert(sysUserRoles);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cloud.user.service.SysUserRolesService#updateObj(com.cloud.user.model.SysUserRoles)
	 */
	@Override
//	@ServiceLog(description = "更新对象")
	@Transactional(rollbackFor = Exception.class)
	public void updateObj(SysUserRoles sysUserRoles) {
		sysUserRolesMapper.updateById(sysUserRoles);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cloud.user.service.SysUserRolesService#deleteObj(com.cloud.user.model.SysUserRoles)
	 */
	@Override
//	@ServiceLog(description = "删除对象")
	@Transactional(rollbackFor = Exception.class)
	public void deleteObj(SysUserRoles sysUserRoles) {
		sysUserRolesMapper.updateById(sysUserRoles);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cloud.user.service.SysUserRolesService#findByObj(com.cloud.user.model.SysUserRoles)
	 */
	@Override
//	@ServiceLog(description = "findByObj")
	public List<SysUserRoles> findByObj(SysUserRoles sysUserRoles) {
//		Map<String, Object> columnMap = BeanCloneUtilsExt.copyTohumpToLine(sysUserRoles);
//		return baseMapper.selectByMap(columnMap);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cloud.user.service.SysUserRolesService#getByObj(com.cloud.user.model.SysUserRoles)
	 */
	@Override
//	@ServiceLog(description = "findOneByObj")
	public SysUserRoles findOneByObj(SysUserRoles sysUserRoles) {
//		return sysUserRolesMapper.selectOne(sysUserRoles);
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.cloud.user.service.SysUserRolesService#insertBatch(java.lang.Long,
	 * java.util.List)
	 */
	@Override
	public void insertBatch(Long userId, List<Long> roleIds) {
//		if (userId == null) {
//			return ;
//		}
//		SysUser dbSysUser=sysUserService.selectById(userId);
//		if(dbSysUser==null){
//			return ;
//		}
//		List<SysUserRoles> lst = Lists.newArrayList();
//		for (Long roleId : roleIds) {
//			SysUserRoles sur = new SysUserRoles();
//			sur.setUserId(userId);
//			sur.setRoleId(roleId);
//			lst.add(sur);
//		}
//		SysUserRoles del = new SysUserRoles();
//		del.setUserId(userId);
//		EntityWrapper<SysUserRoles> ew = new EntityWrapper<SysUserRoles>(del);
//		List<SysUserRoles> userRoles=this.selectList(ew);
//		if(CollectionUtils.isNotEmpty(userRoles)){
//			List<Long> dbRoles= Lists.newArrayList();
//			for(SysUserRoles role:userRoles){
//				dbRoles.add(role.getRoleId());
//			}
//			sysChangeLogService.roleChange(dbSysUser.getUserCode(), JSON.toJSONString(dbRoles), JSON.toJSONString(roleIds));
//			SysUser sysUser=sysUserService.selectById(userId);
//			/**
//			 * 数据库中的角色-前端传过来的角色 这些角色需要删除
//			 */
//			List<Long> dbRolesDel= (List<Long>) CollectionUtils.subtract(dbRoles, roleIds);
//			if(CollectionUtils.isNotEmpty(dbRolesDel)){
//				for(Long roleId:dbRolesDel){
//					sysChangeLogService.roleChange(sysUser.getUserCode(), roleId+"", null);
//				}
//			}
//			/**
//			 * 前端传过来的角色-数据库中的角色 这些角色需要新增
//			 */
//			List<Long> dbRolesAdd= (List<Long>) CollectionUtils.subtract(roleIds, dbRoles);
//
//			if(CollectionUtils.isNotEmpty(dbRolesAdd)){
//				for(Long roleId:dbRolesAdd){
//					sysChangeLogService.roleChange(sysUser.getUserCode(),null, roleId+"");
//				}
//			}
//		}
//		delete(ew);
//		if(CollectionUtils.isNotEmpty(lst)){
//			insertBatch(lst);
//		}


	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public void editRole(SysUserSetRoleVo vo) throws Exception {
		List<SysUserRoles> sysUserRoles = Lists.newArrayList();
		vo.getRoleCodes().stream().forEach(e -> {
			SysUserRoles sysUserRole = new SysUserRoles();
			sysUserRole.setUserCode(vo.getUserCode());
			sysUserRole.setRoleCode(e);
			sysUserRoles.add(sysUserRole);
		});

		this.deleteByUserCode(vo.getUserCode());
		this.saveBatch(sysUserRoles);
	}

//	@ServiceLog(description = "删除对象")
	@Transactional(rollbackFor = Exception.class)
	public void deleteByUserCode(String userCode) {
		SysUserRoles sysUserRoles = new SysUserRoles();
		sysUserRoles.setUserCode(userCode);
		Wrapper<SysUserRoles> wrapper = new LambdaQueryWrapper<>(sysUserRoles);
		sysUserRolesMapper.delete(wrapper);
	}


	@Override
	public void deleteByUserIdAndRoleId(List<Long> userIds, List<Long> dbRoleIds) {
//		SysUserRoles param = new SysUserRoles();
//		EntityWrapper<SysUserRoles> ew = new EntityWrapper<SysUserRoles>(param);
//		ew.in("user_id", userIds);
//		ew.and();
//		ew.in("role_id", dbRoleIds);
//		delete(ew);
		
	}

	@Override
	public void insertPositionBatch(Long userId, List<Long> roleIds) {
//		if (userId == null || CollectionUtils.isEmpty(roleIds)) {
//			return ;
//		}
//		List<SysUserRoles> lst = Lists.newArrayList();
//		for (Long roleId : roleIds) {
//			SysUserRoles sur = new SysUserRoles();
//			sur.setUserId(userId);
//			sur.setRoleId(roleId);
//			lst.add(sur);
//		}
//		SysUserRoles del = new SysUserRoles();
//		del.setUserId(userId);
//		EntityWrapper<SysUserRoles> ew = new EntityWrapper<SysUserRoles>(del);
//		ew.in("role_id", roleIds);
//		delete(ew);
//		insertBatch(lst);
	}
}
