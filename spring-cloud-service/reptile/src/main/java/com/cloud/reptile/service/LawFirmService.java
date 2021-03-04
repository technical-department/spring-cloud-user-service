package com.cloud.reptile.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cloud.reptile.model.LawFirm;

/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:律师事务所
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
public interface LawFirmService extends IService<LawFirm> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param saleArea
	 */
	LawFirm findById(Long id);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param lawFirm
	 */
	void insertObj(LawFirm lawFirm);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param lawFirm
	 */
	void deleteObj(LawFirm lawFirm);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param lawFirm
	 */
	void updateObj(LawFirm lawFirm);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param lawFirm
	 * @return
	 */
	LawFirm findOneByObj(LawFirm lawFirm);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param lawFirm
	 * @return
	 */
	List<LawFirm> findByObj(LawFirm lawFirm);

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
