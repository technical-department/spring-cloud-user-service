package com.cloud.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.user.model.SysResource;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
 * <p>
 * Title: SysResourceDao
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
public interface SysResourceMapper extends BaseMapper<SysResource> {

	List<SysResource> findSysResourceByParam(@Param("userCode") String userCode,
                                             @Param("systemCode") String systemCode);

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param page
	 * @param params
	 * @return
	 */
	List<SysResource> selectMyPage(RowBounds page, Map<String, Object> params);

	SysResource selectOneByParam(Map<String, Object> map);

	List<SysResource> findResourceBySystemCodeAndRoleCode(@Param("systemCode") String systemCode, @Param("roleCode") String roleCode) throws Exception;

	List<SysResource> findSysResourceBySystemCodeAndUserCode(@Param("systemCode") String systemCode, @Param("userCode") String userCode) throws Exception;

}
