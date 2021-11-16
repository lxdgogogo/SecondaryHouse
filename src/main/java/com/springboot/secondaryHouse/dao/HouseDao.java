package com.springboot.secondaryHouse.dao;

import com.springboot.secondaryHouse.entity.House;

import java.util.List;

/**
 * (House)表数据库访问层
 *
 * @author makejava
 * @since 2021-10-22 17:03:37
 */
public interface HouseDao {

    /**
     * 通过ID查询单条数据
     *
     * @param location 主键
     * @return 实例对象
     */
    House queryById(String location);

    /**
     * 查询数据
     *
     * @return 对象列表
     */
    List<House> query();


    /**
     * 通过实体作为筛选条件查询
     *
     * @param house 实例对象
     * @return 对象列表
     */
    List<House> queryAll(House house);

    /**
     * 新增数据
     *
     * @param house 实例对象
     * @return 影响行数
     */
    int insert(House house);

    /**
     * 修改数据
     *
     * @param house 实例对象
     * @return 影响行数
     */
    int update(House house);

    /**
     * 通过主键删除数据
     *
     * @param location 主键
     * @return 影响行数
     */
    int deleteById(String location);

}