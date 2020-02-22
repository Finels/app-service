package com.crow32.market.appservice.controller;

import com.crow32.market.appservice.dto.RestResponse;
import com.crow32.market.appservice.entity.JwtRequest;
import com.crow32.market.appservice.entity.User;
import com.crow32.market.appservice.service.SecurityUserService;
import com.crow32.market.appservice.tools.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.Date;


/**
 * Description:  该类的接口不会被权限拦截
 * Copyright: © 2020 Foxconn. All rights reserved.
 * Company: Foxconn
 *
 * @author FL
 * @version 1.0
 * @timestamp 2020/2/21
 */
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private SecurityUserService userService;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Value("${jwt.tokenHead}")
    private String jwtHeader;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public RestResponse login(@RequestBody JwtRequest request) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
        final UserDetails userDetails = userService
                .loadUserByUsername(request.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        return RestResponse.ok(jwtHeader + token);
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public RestResponse register(@RequestBody User user) {
        if (!StringUtils.isEmpty(user.getUserid())) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            user.setUsertoken(encoder.encode(user.getUserid()));
            user.setCreatetime(new Date());
            userService.register(user);
        }
        return RestResponse.ok();

    }
}
