/**  

* <p>Title: SysUserRegisterDTO.java</p>  

* <p>Description: </p>  

* <p>Copyright: Copyright (c) 2018</p>  

* <p>Company: lianzhongjinrong</p>  

* @author sine  

* @date 2018年3月14日  

* @version 1.0  

*/
package com.cloud.user.fegin.server.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 
 * <p>
 * Title: SysUserRegisterDTO
 * </p>
 * 
 * <p>
 * Description: 用户修改类
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
public class UserCertificationInfoDTO {
	private String idno;
	private String type;
	private String mobile;
	private String userName;
}
