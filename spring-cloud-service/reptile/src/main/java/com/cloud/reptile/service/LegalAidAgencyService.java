package com.cloud.reptile.service;

import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cloud.reptile.model.LegalAidAgency;
import com.baomidou.mybatisplus.extension.service.IService;
/**
 * <p>
 * Title: 
 * </p>
 * <p>
 * Description:法律援助中心
 * </p>
 * @author chenyouhong
 * @date 2021-02-26
 */
public interface LegalAidAgencyService extends IService<LegalAidAgency> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param saleArea
	 */
	LegalAidAgency findById(Long laywerId);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param legalAidAgency
	 */
	void insertObj(LegalAidAgency legalAidAgency);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param legalAidAgency
	 */
	void deleteObj(LegalAidAgency legalAidAgency);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param legalAidAgency
	 */
	void updateObj(LegalAidAgency legalAidAgency);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param legalAidAgency
	 * @return
	 */
	LegalAidAgency findOneByObj(LegalAidAgency legalAidAgency);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param legalAidAgency
	 * @return
	 */
	List<LegalAidAgency> findByObj(LegalAidAgency legalAidAgency);

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
