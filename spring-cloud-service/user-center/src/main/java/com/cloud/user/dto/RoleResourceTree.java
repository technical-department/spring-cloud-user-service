/**
  * Copyright 2021 bejson.com 
  */
package com.cloud.user.dto;
import com.cloud.user.model.SysResource;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Auto-generated: 2021-02-17 13:31:21
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@Data
public class RoleResourceTree implements Serializable {

    private List<String> resourceTreeCheckedKeys;

    private List<SysResource> sysResources;

}