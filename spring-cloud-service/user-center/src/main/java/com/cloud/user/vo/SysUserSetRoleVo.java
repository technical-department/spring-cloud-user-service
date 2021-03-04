/**  

* <p>Title: SysUserRegisterDTO.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2018</p>  

* <p>Company: lianzhongjinrong</p>  

* @author sine  

* @date 2018年3月14日  

* @version 1.0  

*/
package com.cloud.user.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.List;

/**
 * 
 * <p>
 * Title: SysUserAddDTO
 * </p>
 * 
 * <p>
 * Description: 后台用户注册类
 * </p>
 * 
 * @author sine
 * 
 * @date 2018年3月14日
 * 
 */
@Data
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
public class SysUserSetRoleVo implements Serializable {

	@NotNull(message = "用户code为空")
	private String userCode;

	private List<String> roleCodes;

}
