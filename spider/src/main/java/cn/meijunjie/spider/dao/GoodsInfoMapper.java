package cn.meijunjie.spider.dao;


import cn.meijunjie.spider.entity.GoodsInfo;
import org.apache.ibatis.annotations.Insert;


import java.util.List;

public interface GoodsInfoMapper {

    @Insert("<script>"+
    "insert into goods_info(goods_id,goods_name,image_url,goods_price)"
    + "values"
    + "<foreach collection=\"list\" item=\"info\" index=\"index\" separator=\",\">"
    + "(#{info.goods_id},#{info.goods_name},#{info.image_url},#{info.goods_price})"
    +"</foreach>"
    +"</script>")
    void saveBatch(List<GoodsInfo> infos);
}
