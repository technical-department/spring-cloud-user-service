package com.cloud.user.service.impl;


import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cloud.user.mapper.SysBaseInfoMapper;
import com.cloud.user.model.SysBaseInfo;
import com.cloud.user.service.SysBaseInfoService;
import com.common.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
public class SysBaseInfoServiceImpl extends ServiceImpl<SysBaseInfoMapper, SysBaseInfo> implements SysBaseInfoService {

	@Autowired
	private SysBaseInfoMapper sysBaseInfoMapper;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.cloud.user.service.SysBaseInfoService#insertObj(com.cloud.user.model.SysBaseInfo)
	 */
	@Override
	@Transactional(rollbackFor = Exception.class)
//	@ServiceLog(description = "插入对象")
	public void edit(SysBaseInfo sysBaseInfo) throws BusinessException {
		this.saveOrUpdate(sysBaseInfo);
		if (StringUtils.isBlank(sysBaseInfo.getSystemCode())) {
			sysBaseInfo.setSystemCode(sysBaseInfo.getId().toString());
			this.saveOrUpdate(sysBaseInfo);
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * com.cloud.user.service.SysBaseInfoService#getByObj(com.cloud.user.model.SysBaseInfo)
	 */
	@Override
//	@ServiceLog(description = "findOneByObj")
	public SysBaseInfo findOneByObj(SysBaseInfo sysBaseInfo) {
		Wrapper<SysBaseInfo> wrapper = new LambdaQueryWrapper<>(sysBaseInfo);
		return sysBaseInfoMapper.selectOne(wrapper);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cloud.user.service.SysBaseInfoService#findSystemCode(java.lang.String)
	 */
	@Override
//	@ServiceLog(description = "通过systemCode查找对象")
	public SysBaseInfo findSystemCode(String systemCode) {
		SysBaseInfo sysBaseInfo = new SysBaseInfo();
		sysBaseInfo.setSystemCode(systemCode);
		return findOneByObj(sysBaseInfo);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see com.cloud.user.service.SysBaseInfoService#findAdminSys()
	 */
	@Override
	public List<SysBaseInfo> findAdminSys() {
		Wrapper<SysBaseInfo> wrapper = new LambdaQueryWrapper<>();
		List<SysBaseInfo> sysBaseInfos = sysBaseInfoMapper.selectList(wrapper);
		return sysBaseInfos;
	}

	@Override
	public List<SysBaseInfo> findSysBaseInfoByUserCode(String userCode) {
		List<SysBaseInfo> sysBaseInfos = sysBaseInfoMapper.findSysBaseInfoByUserCode(userCode);
		return sysBaseInfos;
	}

	@Override
	public List<SysBaseInfo> findAllSys() {
		Wrapper<SysBaseInfo> wrapper = new LambdaQueryWrapper<SysBaseInfo>();
		List<SysBaseInfo> sysBaseInfos = sysBaseInfoMapper.selectList(wrapper);
		return sysBaseInfos;
	}

}
