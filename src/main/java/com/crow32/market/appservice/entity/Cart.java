package com.crow32.market.appservice.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Description:  购物车
 * Copyright: © 2020 Foxconn. All rights reserved.
 * Company: Foxconn
 *
 * @author FL
 * @version 1.0
 * @timestamp 2020/2/20
 */
@Data
@Entity
@Table(name = "cart")
public class Cart implements Serializable {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid2")
    private String id;
    @Column(length = 64)
    private String userid;
    @Column(length = 64)
    private String wareid;
    private int num;
    @Column(length = 50)
    private int money;
    private int sort;
    private String createtime;
}
