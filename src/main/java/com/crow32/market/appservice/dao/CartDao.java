package com.crow32.market.appservice.dao;

import com.crow32.market.appservice.entity.Cart;
import com.crow32.market.appservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
public interface CartDao extends JpaRepository<Cart,String>{
}
