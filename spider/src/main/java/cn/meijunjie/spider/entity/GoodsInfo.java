package cn.meijunjie.spider.entity;

import lombok.*;

@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class GoodsInfo {

    private int id;
    private String goods_id;
    private String goods_name;
    private String image_url;
    private String goods_price;

    public GoodsInfo(String goods_id, String goods_name, String image_url, String goods_price) {
        this.goods_id = goods_id;
        this.goods_name = goods_name;
        this.image_url = image_url;
        this.goods_price = goods_price;
    }
}
