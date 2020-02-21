package com.crow32.market.appservice.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Description:  商品
 * Copyright: © 2020 Foxconn. All rights reserved.
 * Company: Foxconn
 *
 * @author FL
 * @version 1.0
 * @timestamp 2020/2/20
 */
@Data
@Entity
@Table(name = "wares")
public class Wares implements Serializable {
    @Id
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(generator = "uuid2")
    private String id;
    private String name;
    private String type;
    private String typename;
    private String indroduce;
    private String html; //商品的富文本信息
    private String img;
    private int disable; //商品是否下架
    private int display; //商品是否显示
    private int sort;
    private String createtime;

}
