package com.cloud.reptile.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.reptile.model.Mediator;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:调解员
 * </p>
 * @author chenyouhong
 * @date 2021-02-27
 */
public interface MediatorService extends IService<Mediator> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param saleArea
	 */
	Mediator findById(Long mediatorId);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param mediator
	 */
	void insertObj(Mediator mediator);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param mediator
	 */
	void deleteObj(Mediator mediator);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param mediator
	 */
	void updateObj(Mediator mediator);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param mediator
	 * @return
	 */
	Mediator findOneByObj(Mediator mediator);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param mediator
	 * @return
	 */
	List<Mediator> findByObj(Mediator mediator);

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
