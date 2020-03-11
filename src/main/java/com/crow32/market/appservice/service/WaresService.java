package com.crow32.market.appservice.service;

import com.crow32.market.appservice.dao.WaresDao;
import com.crow32.market.appservice.entity.Wares;
import com.crow32.market.appservice.service.intf.WarsServiceIntf;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Description:  com.crow32.market.appservice.service
 * Copyright: © 2020 Foxconn. All rights reserved.
 * Company: Foxconn
 *
 * @author FL
 * @version 1.0
 * @timestamp 2020/2/20
 */
@Service
@Transactional
public class WaresService implements WarsServiceIntf {
    @Autowired
    private WaresDao waresDao;

    @Override
    @Cacheable("wares")
    public List getByCatalog(String catalog) {
        return waresDao.findByTypeAndDisplayAndDisable(catalog, 0, 0);
    }

    @Override
    @Cacheable("wares")
    public List getByNameLike(String nameLike) {
        return waresDao.findByNameLike("%" + nameLike + "%");
    }

    @Override
    @Cacheable("wares")
    public Wares getById(String id) {
        return waresDao.getOne(id);
    }


    @Override
    @CacheEvict("wares")
    public void persist(Wares wares) {
        waresDao.save(wares);
    }

    @Override
    public List<Wares> listAll() {
        return waresDao.findAll();
    }

}
