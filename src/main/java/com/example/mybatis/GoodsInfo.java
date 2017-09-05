package com.example.mybatis;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * Created by meijunjie on 2017/9/3.
 */
@ToString
public class GoodsInfo {
    @Getter
    private int id;

    @Setter
    @Getter
    private String goods_id;

    @Setter
    @Getter
    private String goods_name;

    @Setter
    @Getter
    private String image_url;

    @Setter
    @Getter
    private String goods_price;
}
