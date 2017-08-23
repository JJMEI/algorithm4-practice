package cn.meijunjie.web.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

@Repository
public interface SpitterMapper {

//    @Insert(value = "insert into spitter(username,password,")
//    void insertSpitter(Spitter spitter);

//    @Update(value = "update spitter set username=#{username},password=#{password},email=#{email}")
//    void updateSpitterById(long id);

    @Select(value = "select * from spitter where id=#{id}")
    Spitter findSpitterById(long id);

    @Select(value = "select * from spitter where username=#{username}")
    Spitter findSpitterByUserName(String userName);
}
