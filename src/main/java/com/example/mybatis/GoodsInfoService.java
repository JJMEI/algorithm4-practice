package com.example.mybatis;

import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by meijunjie on 2017/9/3.
 */
@Slf4j
@Service
public class GoodsInfoService {


    @Autowired
    private GoodsInfoMapper goodsInfoMapper;

    public void insertData(GoodsInfo goodsInfo)
    {
        goodsInfoMapper.insert(goodsInfo);
        log.info("GoodsInfoService: insertData={},executor={}",goodsInfo,goodsInfoMapper);
    }

    public GoodsInfo getDataById(Integer id)
    {
        GoodsInfo goodsInfo = goodsInfoMapper.selectGoodsInfoById(id);
        log.info("GoodsInfoService: getDataById  Id={},executor={},result={}",id,goodsInfoMapper,goodsInfo.toString());
        return goodsInfo;
    }
}
