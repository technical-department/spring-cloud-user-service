package com.cloud.vo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

/**
 * 项目名称：gateway
 * 类 名 称：LoginVo
 * 类 描 述：TODO
 * 创建时间：2021/2/7 下午11:19
 * 创 建 人：chenyouhong
 */
@Data
public class LoginVo {

//    @JSONField(name = "username")
    private String username;

    private String password;

}
