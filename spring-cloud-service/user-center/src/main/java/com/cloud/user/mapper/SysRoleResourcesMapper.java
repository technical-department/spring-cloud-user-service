package com.cloud.user.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cloud.user.model.SysRoleResources;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

/**
* <p>
* Title: SysRoleResourcesDao
* </p>
* <p>
* Description:
* </p>
* @author chenyouhong
* @since 2018-05-21
*/
public interface SysRoleResourcesMapper extends BaseMapper<SysRoleResources> {

   /**
    * <p>
    * Description:
    * </p>
    * @param page
    * @param params
    * @return
    */
   List<SysRoleResources> selectMyPage(RowBounds page, Map<String, Object> params);
}
