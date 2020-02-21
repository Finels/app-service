package com.crow32.market.appservice.dao;

import com.crow32.market.appservice.entity.User;
import com.crow32.market.appservice.entity.Wares;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Description:  com.crow32.market.appservice.dao
 * Copyright: © 2020 Foxconn. All rights reserved.
 * Company: Foxconn
 *
 * @author FL
 * @version 1.0
 * @timestamp 2020/2/20
 */
@Repository
public interface WaresDao extends JpaRepository<Wares, String> {
    //根据种类和是否上架是否显示来查询
    List<Wares> findByTypeAndDisplayAndDisable(String type, int display, int disable);

    List<Wares> findByNameLike(String name);
}
