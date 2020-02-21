package com.crow32.market.appservice.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Description:  收货地址
 * Copyright: © 2020 Foxconn. All rights reserved.
 * Company: Foxconn
 *
 * @author FL
 * @version 1.0
 * @timestamp 2020/2/20
 */
@Data
@Entity
@Table(name = "address")
public class Address implements Serializable{
    @Id
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid2")
    private String id;
    private String add1;
    private String add2;
    private String add3;
    private String add4;
    private String add5;
    private String receiver;
    private String tel;
    @Column(length = 64)
    private String userid;
    private int sort;
    @Column(length = 50)
    private String createtime;
}
