package com.cloud.reptile.dao;

import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import com.cloud.reptile.model.GrassrootLegalServiceWorker;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

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
public interface GrassrootLegalServiceWorkerDao extends BaseMapper<GrassrootLegalServiceWorker> {

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
