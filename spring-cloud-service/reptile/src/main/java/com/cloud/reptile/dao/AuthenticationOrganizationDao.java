package com.cloud.reptile.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.cloud.reptile.model.AuthenticationOrganization;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:鉴定机构
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
public interface AuthenticationOrganizationDao extends BaseMapper<AuthenticationOrganization> {

	/**
	 * 
	 * <p>
	 * Description:分页
	 * </p>
	 * @param rowBounds
	 * @param params
	 * @return
	 */
	Page selectMyPage(Page page, @Param(value = "p") Map<String, Object> params);

}
