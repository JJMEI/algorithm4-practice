package com.example.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by meijunjie on 2017/9/3.
 */

@RestController
@RequestMapping("/mybatis")
public class GoodsInfoController {

    @Autowired
    private GoodsInfoService goodsInfoService;

    @RequestMapping(value = "/getGoodsInfo/{id}")
    public GoodsInfo getGoodsInfoById(@PathVariable(name = "id",required = true) Integer id)
    {
        return goodsInfoService.getDataById(id);
    }
}
