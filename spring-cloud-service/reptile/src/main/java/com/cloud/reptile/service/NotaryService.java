package com.cloud.reptile.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.reptile.model.Notary;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:公证员
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
public interface NotaryService extends IService<Notary> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param saleArea
	 */
	Notary findById(Long notaryOrganizationId);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param notary
	 */
	void insertObj(Notary notary);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param notary
	 */
	void deleteObj(Notary notary);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param notary
	 */
	void updateObj(Notary notary);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param notary
	 * @return
	 */
	Notary findOneByObj(Notary notary);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param notary
	 * @return
	 */
	List<Notary> findByObj(Notary notary);

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
