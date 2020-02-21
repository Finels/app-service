package com.crow32.market.appservice.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Description:  com.crow32.market.appservice.dto
 * Copyright: © 2020 Foxconn. All rights reserved.
 * Company: Foxconn
 *
 * @author FL
 * @version 1.0
 * @timestamp 2020/2/21
 */
@Data
@NoArgsConstructor
public class RestResponse {
    private boolean result;
    private String msg;
    private int code;
    private Object data;

    public static RestResponse unauthorized() {
        RestResponse restResponse = new RestResponse();
        restResponse.setResult(false);
        restResponse.setCode(401);
        restResponse.setData("unauthorized");
        return restResponse;
    }

    public static RestResponse unauthorized(String msg) {
        RestResponse restResponse = new RestResponse();
        restResponse.setResult(false);
        restResponse.setCode(401);
        restResponse.setData(msg);
        return restResponse;
    }

    @Override
    public String toString() {
        return "{" +
                "result=" + result +
                ", msg='" + msg + '\'' +
                ", code=" + code +
                ", data=" + data +
                '}';
    }
}
