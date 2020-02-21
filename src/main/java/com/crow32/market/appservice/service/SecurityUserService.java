package com.crow32.market.appservice.service;

import com.crow32.market.appservice.dao.UserDao;
import com.crow32.market.appservice.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * Description:  com.crow32.market.appservice.service
 * Copyright: © 2020 Foxconn. All rights reserved.
 * Company: Foxconn
 *
 * @author FL
 * @version 1.0
 * @timestamp 2020/2/21
 */
@Service
public class SecurityUserService implements UserDetailsService {
    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
        User userDetail = userDao.findByUseridAndBlack(userid, 0);
        if (userDetail == null) {
            throw new UsernameNotFoundException(String.format("No userDetail found with username '%s'.", userid));
        }
        userDetail.setRole("ROLE_ADMIN");
        return userDetail;
    }
}
