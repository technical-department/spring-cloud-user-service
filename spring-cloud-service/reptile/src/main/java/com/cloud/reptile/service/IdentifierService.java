package com.cloud.reptile.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.reptile.model.Identifier;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:鉴定员
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
public interface IdentifierService extends IService<Identifier> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param saleArea
	 */
	Identifier findById(Long identifierId);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param identifier
	 */
	void insertObj(Identifier identifier);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param identifier
	 */
	void deleteObj(Identifier identifier);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param identifier
	 */
	void updateObj(Identifier identifier);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param identifier
	 * @return
	 */
	Identifier findOneByObj(Identifier identifier);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param identifier
	 * @return
	 */
	List<Identifier> findByObj(Identifier identifier);

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
