package com.crow32.market.appservice.service.intf;

import com.crow32.market.appservice.entity.Wares;

import java.util.List;

/**
 * Description:  com.crow32.market.appservice.service.intf
 * Copyright: © 2020 Foxconn. All rights reserved.
 * Company: Foxconn
 *
 * @author FL
 * @version 1.0
 * @timestamp 2020/2/20
 */
public interface WarsServiceIntf {
    List getByCatalog(String catalog);

    List getByNameLike(String nameLike);

    Wares getById(String id);

    void persist(Wares wares);

}
