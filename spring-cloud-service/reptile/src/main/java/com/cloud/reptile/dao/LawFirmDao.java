package com.cloud.reptile.dao;

import java.util.Map;

import com.cloud.reptile.model.LawFirm;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
public interface LawFirmDao extends BaseMapper<LawFirm> {

	/**
	 * 
	 * <p>
	 * Description:分页
	 * </p>
	 * @param rowBounds
	 * @param params
	 * @return
	 */
	Page selectMyPage(Page page, @Param(value = "p") Map<String, Object> params);

}
