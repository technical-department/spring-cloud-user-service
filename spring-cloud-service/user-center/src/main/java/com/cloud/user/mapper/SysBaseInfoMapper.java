package com.cloud.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.user.model.SysBaseInfo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Title: SysBaseInfoDao
 * </p>
 * <p>
 * Description:
 * </p>
 * @author chenyouhong
 * @since 2021-02-16
 */
public interface SysBaseInfoMapper extends BaseMapper<SysBaseInfo> {

	/**
	 * <p>
	 * Description:
	 * </p>
	 * @param userCode
	 * @return
	 */
	List<SysBaseInfo> findSysBaseInfoByUserCode(@Param("userCode") String userCode);

}
