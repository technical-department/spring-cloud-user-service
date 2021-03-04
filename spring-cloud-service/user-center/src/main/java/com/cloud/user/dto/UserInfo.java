/**
  * Copyright 2021 bejson.com 
  */
package com.cloud.user.dto;
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
public class UserInfo implements Serializable {

    private List<String> scope;
    private String name;
    private String id;
    private long exp;
    private List<String> authorities;
    private String jti;
    private String client_id;
    private String userCode;
    private String userName;

}