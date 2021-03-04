package com.cloud.reptile.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.reptile.model.AuthenticationOrganization;
import com.baomidou.mybatisplus.extension.service.IService;
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
public interface AuthenticationOrganizationService extends IService<AuthenticationOrganization> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param saleArea
	 */
	AuthenticationOrganization findById(Long authenticationOrganizationId);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param authenticationOrganization
	 */
	void insertObj(AuthenticationOrganization authenticationOrganization);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param authenticationOrganization
	 */
	void deleteObj(AuthenticationOrganization authenticationOrganization);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param authenticationOrganization
	 */
	void updateObj(AuthenticationOrganization authenticationOrganization);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param authenticationOrganization
	 * @return
	 */
	AuthenticationOrganization findOneByObj(AuthenticationOrganization authenticationOrganization);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param authenticationOrganization
	 * @return
	 */
	List<AuthenticationOrganization> findByObj(AuthenticationOrganization authenticationOrganization);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param page
	 * @param params
	 * @return
	 */
	Page selectMyPage(Page page, Map<String, Object> params);

}
