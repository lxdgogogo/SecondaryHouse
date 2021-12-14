package com.springboot.secondaryHouse.service;

import com.springboot.secondaryHouse.entity.House;
import java.util.List;

/**
 * (House)表服务接口
 *
 * @author makejava
 * @since 2021-10-22 17:03:37
 */
public interface HouseService {

    /**
     * 通过ID查询单条数据
     *
     * @param location 主键
     * @return 实例对象
     */
    House queryById(String location);

    /**
     * 查询多条数据
     *
     * @return 对象列表
     */
    List<House> query();

    /**
     * 新增数据
     *
     * @param house 实例对象
     * @return 实例对象
     */
    House insert(House house);

    /**
     * 修改数据
     *
     * @param house 实例对象
     * @return 实例对象
     */
    House update(House house);

    /**
     * 通过主键删除数据
     *
     * @param location 主键
     * @return 是否成功
     */
    boolean deleteById(String location);

}