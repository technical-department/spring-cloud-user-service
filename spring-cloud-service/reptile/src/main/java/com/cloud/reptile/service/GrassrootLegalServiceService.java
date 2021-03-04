package com.cloud.reptile.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.reptile.model.GrassrootLegalService;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:基层法律服务所
 * </p>
 * @author chenyouhong
 * @date 2021-02-27
 */
public interface GrassrootLegalServiceService extends IService<GrassrootLegalService> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param saleArea
	 */
	GrassrootLegalService findById(Long grassrootLegalServiceId);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param grassrootLegalService
	 */
	void insertObj(GrassrootLegalService grassrootLegalService);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param grassrootLegalService
	 */
	void deleteObj(GrassrootLegalService grassrootLegalService);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param grassrootLegalService
	 */
	void updateObj(GrassrootLegalService grassrootLegalService);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param grassrootLegalService
	 * @return
	 */
	GrassrootLegalService findOneByObj(GrassrootLegalService grassrootLegalService);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param grassrootLegalService
	 * @return
	 */
	List<GrassrootLegalService> findByObj(GrassrootLegalService grassrootLegalService);

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
