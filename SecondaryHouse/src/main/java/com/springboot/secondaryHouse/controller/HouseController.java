package com.springboot.secondaryHouse.controller;

import com.springboot.secondaryHouse.entity.House;
import com.springboot.secondaryHouse.entity.HouseEvaluate;
import com.springboot.secondaryHouse.entity.House_re;
import com.springboot.secondaryHouse.entity.Location;
import com.springboot.secondaryHouse.service.HouseService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * (House)表控制层
 *
 * @author makejava
 * @since 2021-10-22 17:03:38
 */
@RestController
@RequestMapping("")
public class HouseController {
    /**
     * 服务对象
     */
    @Resource
    private HouseService houseService;

    private House_re convert(House origin){
        House_re one = new House_re();
        one.setLocation(origin.getLocation());
        one.setPrice(origin.getPrice());
        one.setArea(origin.getArea());
        return one;
    }

    /**
     * 查询所有数据
     *
     * @return 单条数据
     */
    @GetMapping("house")
    public List<House> select() {
        return houseService.query();
    }

    @PostMapping("changeHouse")
    public House_re change(@RequestBody House_re re){
        int evaluate= houseService.queryById(re.getLocation()).getEvaluate();
        House one = new House();
        one.setEvaluate(evaluate);
        one.setArea(re.getArea());
        one.setPrice(re.getPrice());
        one.setLocation(re.getLocation());
        return convert(houseService.update(one));
    }

    @PostMapping("addHouse")
    public House_re add(@RequestBody House_re re){
        House one = new House();
        one.setEvaluate(0);
        one.setArea(re.getArea());
        one.setPrice(re.getPrice());
        one.setLocation(re.getLocation());
        return convert(houseService.insert(one));
    }

    @PostMapping("deleteHouse")
    public boolean delete(@RequestBody Location location){
        return houseService.deleteById(location.getLocation());
    }

    @PostMapping("evaluateHouse")
    public String evaluate(@RequestBody HouseEvaluate houseEvaluate){
        House house= houseService.queryById(houseEvaluate.getLocation());
        house.setEvaluate(houseEvaluate.getEvaluate());
        houseService.update(house);
        return "success";
    }
}
