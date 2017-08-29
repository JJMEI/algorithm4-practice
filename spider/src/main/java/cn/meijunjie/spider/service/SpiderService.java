package cn.meijunjie.spider.service;

import cn.meijunjie.spider.entity.GoodsInfo;

import java.util.List;

public interface SpiderService {

    List<GoodsInfo> parseHtml(String html);
}
