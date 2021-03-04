package com.cloud.reptile.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.reptile.model.DictionaryRegion;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:地区国标
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
public interface DictionaryRegionService extends IService<DictionaryRegion> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param saleArea
	 */
	DictionaryRegion findById(Long id);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param dictionaryRegion
	 */
	void insertObj(DictionaryRegion dictionaryRegion);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param dictionaryRegion
	 */
	void deleteObj(DictionaryRegion dictionaryRegion);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param dictionaryRegion
	 */
	void updateObj(DictionaryRegion dictionaryRegion);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param dictionaryRegion
	 * @return
	 */
	DictionaryRegion findOneByObj(DictionaryRegion dictionaryRegion);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param dictionaryRegion
	 * @return
	 */
	List<DictionaryRegion> findByObj(DictionaryRegion dictionaryRegion);

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
