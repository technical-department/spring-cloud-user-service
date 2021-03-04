package com.cloud.user.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.user.model.SysRole;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
* <p>
* Title: SysRoleDao
* </p>
* <p>
* Description:
* </p>
* @author chenyouhong
* @since 2021-02-16
*/
public interface SysRoleMapper extends BaseMapper<SysRole> {

   /**
    * <p>Description: </p>
    * @param page
    * @param params
    * @return
    */
   List selectMyPage(RowBounds page, Map<String, Object> params);

   /**
    * <p>Description: </p>
    * @param userCode
    */
   List<SysRole> findLstByUserCode(@Param("userCode") String userCode);

   List<SysRole> findLstByPositionId(@Param("positionId") Long positionId);

   List<SysRole> findLstByPositionIds(@Param("positionIds") List<Long> positionIds);

}
