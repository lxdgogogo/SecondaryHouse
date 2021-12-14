package com.springboot.secondaryHouse.service.impl;

import com.springboot.secondaryHouse.entity.House;
import com.springboot.secondaryHouse.dao.HouseDao;
import com.springboot.secondaryHouse.entity.User;
import com.springboot.secondaryHouse.service.HouseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (House)表服务实现类
 *
 * @author makejava
 * @since 2021-10-22 17:03:38
 */
@Service("houseService")
public class HouseServiceImpl implements HouseService {
    @Resource
    private HouseDao houseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param location 主键
     * @return 实例对象
     */
    @Override
    public House queryById(String location) {
        return this.houseDao.queryById(location);
    }

    /**
     * 查询数据
     *
     * @return 对象列表
     */
    @Override
    public List<House> query() {
        return this.houseDao.query();
    }

    /**
     * 新增数据
     *
     * @param house 实例对象
     * @return 实例对象
     */
    @Override
    public House insert(House house) {
        this.houseDao.insert(house);
        return house;
    }

    /**
     * 修改数据
     *
     * @param house 实例对象
     * @return 实例对象
     */
    @Override
    public House update(House house) {
        this.houseDao.update(house);
        return this.queryById(house.getLocation());
    }

    /**
     * 通过主键删除数据
     *
     * @param location 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(String location) {
        return this.houseDao.deleteById(location) > 0;
    }

}