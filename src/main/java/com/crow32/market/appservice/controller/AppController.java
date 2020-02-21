package com.crow32.market.appservice.controller;

import com.crow32.market.appservice.dto.RestResponse;
import com.crow32.market.appservice.service.WaresService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Description:  com.crow32.market.appservice.controller
 * Copyright: © 2020 Foxconn. All rights reserved.
 * Company: Foxconn
 *
 * @author FL
 * @version 1.0
 * @timestamp 2020/2/21
 */
@RestController
@RequestMapping("/app")
public class AppController {
    @Autowired
    private WaresService waresService;

    @RequestMapping(value = "/wares", method = RequestMethod.GET, consumes = "application/json")
    public RestResponse getWaresByType(@RequestParam(value = "type", required = false) String type) {
        RestResponse result = new RestResponse();
        if (type != null) {
            result.setData(waresService.getByCatalog(type));
        }
        result.setResult(true);
        return result;
    }
}
