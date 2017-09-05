package com.example.mybatis;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * Created by meijunjie on 2017/9/3.
 */

@Mapper
public interface GoodsInfoMapper {

    @Insert("insert into goods_info(goods_id,goods_name,image_url,goods_price} " +
            "values(#{goods_id},#{goods_name},#{image_url},#{goods_price})")
    void insert(GoodsInfo goodsInfo);

    @Select("select * from goods_info where id=#{id}")
    GoodsInfo selectGoodsInfoById(Integer id);
}
