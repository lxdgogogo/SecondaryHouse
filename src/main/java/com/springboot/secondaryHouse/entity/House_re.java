package com.springboot.secondaryHouse.entity;

import java.io.Serializable;

/**
 * (House)实体类
 *
 * @author makejava
 * @since 2021-10-21 16:55:24
 */
public class House_re implements Serializable {
    private static final long serialVersionUID = -81013186360497142L;

    private Integer price;

    private Integer area;

    private String location;


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getArea() {
        return area;
    }

    public void setArea(Integer area) {
        this.area = area;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

}