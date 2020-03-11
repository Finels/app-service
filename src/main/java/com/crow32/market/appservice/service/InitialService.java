package com.crow32.market.appservice.service;

import com.crow32.market.appservice.entity.Wares;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Description:  com.crow32.market.appservice.service
 * Copyright: © 2020 Foxconn. All rights reserved.
 * Company: Foxconn
 *
 * @author FL
 * @version 1.0
 * @timestamp 2020/3/11
 */
@Component
@Log
public class InitialService implements CommandLineRunner, Serializable {
    @Autowired
    private CacheManager cacheManager;
    @Autowired
    private WaresService waresService;

    //初始化缓存，缓存全部数据
    public void initCache() {
        log.info("=============开始加载缓存...==============");
        Cache cache = cacheManager.getCache("wares");
        List<Wares> a = waresService.listAll();
        a.forEach(w -> {
            cache.put(w.getName(), w);
            cache.put(w.getType(), a);
        });
        log.info("=============缓存加载结束...==============");
    }

    @Override
    public void run(String... args) throws Exception {
        initCache();
    }
}
