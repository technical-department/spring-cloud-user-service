package com.cloud.reptile.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.reptile.model.MediationOrganization;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:调解机构
 * </p>
 * @author chenyouhong
 * @date 2021-02-27
 */
public interface MediationOrganizationService extends IService<MediationOrganization> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param saleArea
	 */
	MediationOrganization findById(Long mediationOrganizationId);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param mediationOrganization
	 */
	void insertObj(MediationOrganization mediationOrganization);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param mediationOrganization
	 */
	void deleteObj(MediationOrganization mediationOrganization);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param mediationOrganization
	 */
	void updateObj(MediationOrganization mediationOrganization);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param mediationOrganization
	 * @return
	 */
	MediationOrganization findOneByObj(MediationOrganization mediationOrganization);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param mediationOrganization
	 * @return
	 */
	List<MediationOrganization> findByObj(MediationOrganization mediationOrganization);

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
