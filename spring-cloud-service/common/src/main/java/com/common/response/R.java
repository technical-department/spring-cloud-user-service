package com.common.response;

import com.common.enums.ResultEnum;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class R {

    private String code = ResultEnum.SUCCESS.getCode();

    private String msg = "success";

    private Object data;

    public R(){};

    public R(Object data){
        this.data = data;
    }

}
