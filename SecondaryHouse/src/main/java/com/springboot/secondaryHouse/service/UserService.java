package com.springboot.secondaryHouse.service;

import com.springboot.secondaryHouse.entity.User;
import com.springboot.secondaryHouse.entity.UserInformation;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2021-10-21 17:28:54
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param username 主键
     * @return 实例对象
     */
    User queryById(String username);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<User> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User insert(User user);

    /**
     * 修改数据
     *
     * @param user 实例对象
     * @return 实例对象
     */
    User update(User user);

    /**
     * 通过主键删除数据
     *
     * @param username 主键
     * @return 是否成功
     */
    boolean deleteById(String username);


}