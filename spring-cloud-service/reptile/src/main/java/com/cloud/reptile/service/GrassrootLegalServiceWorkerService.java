package com.cloud.reptile.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.reptile.model.GrassrootLegalServiceWorker;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:法律服务工作者
 * </p>
 * @author chenyouhong
 * @date 2021-02-27
 */
public interface GrassrootLegalServiceWorkerService extends IService<GrassrootLegalServiceWorker> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param saleArea
	 */
	GrassrootLegalServiceWorker findById(Long laywerId);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param grassrootLegalServiceWorker
	 */
	void insertObj(GrassrootLegalServiceWorker grassrootLegalServiceWorker);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param grassrootLegalServiceWorker
	 */
	void deleteObj(GrassrootLegalServiceWorker grassrootLegalServiceWorker);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param grassrootLegalServiceWorker
	 */
	void updateObj(GrassrootLegalServiceWorker grassrootLegalServiceWorker);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param grassrootLegalServiceWorker
	 * @return
	 */
	GrassrootLegalServiceWorker findOneByObj(GrassrootLegalServiceWorker grassrootLegalServiceWorker);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param grassrootLegalServiceWorker
	 * @return
	 */
	List<GrassrootLegalServiceWorker> findByObj(GrassrootLegalServiceWorker grassrootLegalServiceWorker);

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
