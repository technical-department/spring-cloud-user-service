package com.cloud.user.fegin.server.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class WeiXinToken implements Serializable {

	private String access_token;
	private int expires_in;
	private String refresh_token;
	private String openid;
	private String scope;
	private String errcode;
	private String errmsg;

}
