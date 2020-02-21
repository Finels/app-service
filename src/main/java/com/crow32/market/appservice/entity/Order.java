package com.crow32.market.appservice.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Description:  订单
 * Copyright: © 2020 Foxconn. All rights reserved.
 * Company: Foxconn
 *
 * @author FL
 * @version 1.0
 * @timestamp 2020/2/20
 */
@Data
@Entity
@Table(name = "order")
public class Order implements Serializable {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid2")
    private String id;
    private String code;
    private int m1;  //订单金额
    @Column(length = 64)
    private String a1; //订单关联收获地址uuid
    @Column(length = 64)
    private String u1; //订单关联用户uuid
    private String createtime;

}
