package cn.meijunjie.spider.test.dao;


import cn.meijunjie.spider.dao.GoodsInfoMapper;
import cn.meijunjie.spider.entity.GoodsInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;

@Slf4j
public class TestGoodsInfoDao {

    private static SqlSession sqlSession = null;

    @BeforeTest
    public void beforeTest()
    {
        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis/mybatis-config.xml"));
            sqlSession = sqlSessionFactory.openSession(false);
        } catch (IOException e) {
            e.printStackTrace();
            log.debug(e.getMessage());
        }
    }

    @Test
    public void testGoodsInfoDao()
    {
        GoodsInfoMapper goodsInfoMapper = sqlSession.getMapper(GoodsInfoMapper.class);
        ArrayList<GoodsInfo> list = new ArrayList<>();

        GoodsInfo goodsInfo = new GoodsInfo();
        goodsInfo.setGoods_id("da2e3fdfs");
        goodsInfo.setGoods_name("asdvd32");
        goodsInfo.setImage_url("dasdas");
        goodsInfo.setGoods_price("342.23");

        list.add(goodsInfo);

        GoodsInfo goodsInfo1 = new GoodsInfo();
        goodsInfo1.setGoods_id("cbkjbsdkj28199");
        goodsInfo1.setGoods_name("davhsdvhk1");
        goodsInfo1.setImage_url("dasdas");
        goodsInfo1.setGoods_price("342.23");

        list.add(goodsInfo1);

        try
        {
            goodsInfoMapper.saveBatch(list);
            sqlSession.commit();
        }catch (Exception e)
        {
            sqlSession.rollback();
            log.info("出现异常....");
        }finally {
            sqlSession.close();
        }

    }


}
