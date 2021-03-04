package com.cloud.reptile.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.reptile.model.NotaryOrganization;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:公证机构
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
public interface NotaryOrganizationService extends IService<NotaryOrganization> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param saleArea
	 */
	NotaryOrganization findById(Long notaryOrganizationId);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param notaryOrganization
	 */
	void insertObj(NotaryOrganization notaryOrganization);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param notaryOrganization
	 */
	void deleteObj(NotaryOrganization notaryOrganization);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param notaryOrganization
	 */
	void updateObj(NotaryOrganization notaryOrganization);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param notaryOrganization
	 * @return
	 */
	NotaryOrganization findOneByObj(NotaryOrganization notaryOrganization);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param notaryOrganization
	 * @return
	 */
	List<NotaryOrganization> findByObj(NotaryOrganization notaryOrganization);

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
