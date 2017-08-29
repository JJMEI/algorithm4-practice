package cn.meijunjie.spider.common;

import cn.meijunjie.spider.dao.GoodsInfoMapper;
import cn.meijunjie.spider.entity.GoodsInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

@Slf4j
public class GoodsInfoUtils {

    private static SqlSession sqlSession = null;

    public static void saveBatch(List<GoodsInfo> goodsInfos, String configuration)
    {
        try {
            sqlSession = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(configuration)).openSession(false);
        } catch (IOException e) {
            log.error("配置文件错误....");
        }
        GoodsInfoMapper goodsInfoMapper = sqlSession.getMapper(GoodsInfoMapper.class);

       try{
           goodsInfoMapper.saveBatch(goodsInfos);
           sqlSession.commit();
       }catch (Exception e)
       {
           log.error("出现异常...请检查文件");
           sqlSession.rollback();
       }finally {
           sqlSession.close();
       }





    }
}
