package com.cloud.user.fegin.server.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class WeiXinBody implements Serializable {

	private WeiXinBaseInfo baseInfo;
	private WeiXinToken token;

}
