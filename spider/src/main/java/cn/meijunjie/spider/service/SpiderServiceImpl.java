package cn.meijunjie.spider.service;

import cn.meijunjie.spider.common.GoodsInfoUtils;
import cn.meijunjie.spider.common.HttpClientUtils;
import cn.meijunjie.spider.entity.GoodsInfo;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.List;
import java.util.Map;

@Slf4j
public class SpiderServiceImpl {

    private static String HTTPS_PROTOCOL = "https:";

    public static void spiderData(String url, Map<String,String> headers,Map<String,String> params)
    {
        String html = HttpClientUtils.sendGet(url,null,params);
        if(!StringUtils.isEmpty(html))
        {
            List<GoodsInfo> goodsInfos = parseHtml(html);
            GoodsInfoUtils.saveBatch(goodsInfos,"mybatis/mybatis-config.xml");
        }
    }

    private static List<GoodsInfo> parseHtml(String html) {

        List<GoodsInfo> goods = Lists.newArrayList();

        //获取dom并解析

        Document document = Jsoup.parse(html);
        Elements elements = document.select("ul[class=gl-warp clearfix]").select("li[class=gl-item]");
        int index = 0;
        for(Element element : elements)
        {
            String goods_id = element.attr("data-sku");
            String  goods_name = element.select("div[class=p-name p-name-type-2]").select("em").text();
            String goods_price = element.select("div[class=p-price]").select("strong").select("i").text();
            String image_url = HTTPS_PROTOCOL + element.select("div[class=p-img]").select("a").select("img").attr("src");

            GoodsInfo goodsInfo = new GoodsInfo(goods_id,goods_name,image_url,goods_price);
            goods.add(goodsInfo);
        }
        return goods;
    }
}
