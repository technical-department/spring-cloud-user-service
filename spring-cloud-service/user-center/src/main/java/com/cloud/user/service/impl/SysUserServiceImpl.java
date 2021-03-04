package com.cloud.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.user.mapper.SysUserMapper;
import com.cloud.user.model.SysBaseInfo;
import com.cloud.user.model.SysRole;
import com.cloud.user.model.SysUser;
import com.cloud.user.service.SysBaseInfoService;
import com.cloud.user.service.SysRoleService;
import com.cloud.user.service.SysUserRolesService;
import com.cloud.user.service.SysUserService;
import com.cloud.user.vo.SysUserSetRoleVo;
import com.cloud.user.vo.SysUserVo;
import com.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title: SysBaseInfoServiceImpl
 * </p>
 * <p>
 * Description:
 * </p>
 * @author carter
 * @since 2021-02-10
 */
@Slf4j
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

	@Autowired
	private SysUserMapper sysUserMapper;

	@Autowired
	private DozerBeanMapper dozerBeanMapper;

	@Autowired
	private SysRoleService sysRoleService;

	@Autowired
	private SysBaseInfoService sysBaseInfoService;

	@Autowired
	private SysUserRolesService sysUserRolesService;

	public SysUser findOneByObj(SysUser sysUser) {
		Wrapper<SysUser> wrapper = new LambdaQueryWrapper<>(sysUser);
		return sysUserMapper.selectOne(wrapper);
	}

	@Override
	public SysUser findByUserCode(String userCode) {
		SysUser sysUser = new SysUser();
		sysUser.setUserCode(userCode);
		return findOneByObj(sysUser);
	}

	@Override
	public Page<SysUser> selectSysUserPage(SysUserVo vo) {
		Map<String, Object> params = dozerBeanMapper.map(vo, Map.class);
		Page<SysUser> page = new Page<>(vo.getCurrent(), vo.getSize());
		List<SysUser> sysUsers = sysUserMapper.selectSysUserPage(page, params);
		page.setRecords(sysUsers);
		return page;
	}

	@Override
	public List<SysRole> getRoleLst(String userCode) {
		List<SysRole> roleLst = sysRoleService.findLstByUserCode(userCode);
		return roleLst;
	}

	@Override
	public void editRole(SysUserSetRoleVo vo) throws Exception {
		SysUser sysUser = this.findByUserCode(vo.getUserCode());
		if (sysUser == null) {
			throw new BusinessException("xxx", "无当前用户数据");
		}
		String systemCode = sysUser.getSystemCode();
		SysBaseInfo sysBaseInfo = sysBaseInfoService.findSystemCode(systemCode);
		if (sysBaseInfo == null || systemCode == null) {
			throw new BusinessException("xxx", "参数非法");
		}
		sysUserRolesService.editRole(vo);
	}

}
