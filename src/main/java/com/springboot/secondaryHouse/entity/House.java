package com.springboot.secondaryHouse.entity;

import java.io.Serializable;

/**
 * (House)实体类
 *
 * @author makejava
 * @since 2021-10-22 17:03:36
 */
public class House implements Serializable {
    private static final long serialVersionUID = -50442681318072962L;

    private Integer evaluate;

    private Integer price;

    private Integer area;

    private String location;


    public Integer getEvaluate() {
        return evaluate;
    }

    public void setEvaluate(Integer evaluate) {
        this.evaluate = evaluate;
    }

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