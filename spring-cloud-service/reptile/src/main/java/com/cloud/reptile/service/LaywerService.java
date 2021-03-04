package com.cloud.reptile.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.reptile.model.Laywer;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:律师
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
public interface LaywerService extends IService<Laywer> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param saleArea
	 */
	Laywer findById(Long laywerId);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param laywer
	 */
	void insertObj(Laywer laywer);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param laywer
	 */
	void deleteObj(Laywer laywer);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param laywer
	 */
	void updateObj(Laywer laywer);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param laywer
	 * @return
	 */
	Laywer findOneByObj(Laywer laywer);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param laywer
	 * @return
	 */
	List<Laywer> findByObj(Laywer laywer);

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
