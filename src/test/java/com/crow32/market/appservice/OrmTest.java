package com.crow32.market.appservice;

import com.crow32.market.appservice.dao.AddressDao;
import com.crow32.market.appservice.dao.UserDao;
import com.crow32.market.appservice.entity.Address;
import com.crow32.market.appservice.entity.User;
import com.crow32.market.appservice.entity.Wares;
import com.crow32.market.appservice.service.WaresService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Description:  com.crow32.market.appservice
 * Copyright: © 2020 Foxconn. All rights reserved.
 * Company: Foxconn
 *
 * @author FL
 * @version 1.0
 * @timestamp 2020/2/20
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrmTest {
    @Autowired
    private AddressDao addressDao;
    @Autowired
    private WaresService waresService;
    @Autowired
    private UserDao userDao;

    @Before
    public void before() {
    }


    public void testAdd() {
        Address address = new Address();
        address.setAdd1("重庆市");
        address.setAdd2("重庆市");
        address.setAdd3("渝北区");
        address.setAdd4("人和街道");
        address.setAdd5("恒康路6号");
        address.setSort(1);
        address.setCreatetime("2020-02-14 10:12:33");
        addressDao.save(address);
    }

    public void wareAdd() {
        Wares wares = new Wares();
        wares.setName("奶酪纯正奶酪车轮奶酪大奶酪牛奶条即食奶酪");
        wares.setSort(1);
        wares.setType("零食");
        wares.setIndroduce("大号车轮奶酪，纯正进口");
        wares.setDisable(0);
        wares.setDisplay(0);
        wares.setCreatetime("2020-02-14 10:12:33");
        waresService.persist(wares);
    }

    @Test
    public void wareFind() {
        List a = waresService.getByNameLike("即食");
        List b = waresService.getByNameLike("即食");
        List c = waresService.getByNameLike("即食");
        System.out.println(b);
        System.out.println(c);
    }

    @Test
    public void userAdd() {
        User user = new User();
        user.setUserid("aabbcc");
        user.setUsertoken("测试1122");
        user.setCreatetime(new Date());
        userDao.save(user);
    }
}
