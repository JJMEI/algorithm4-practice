package cn.meijunjie.web.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpitterMapper {

    @Insert(value = "insert into spitter(username,password,")
    void insertSpitter(Spitter spitter);

    @Update(value = "update spitter set username=#{username},password=#{password},email=#{email}")
    void updateSpitterById(long id);

    @Select(value = "select * from spitter where id=#{id}")
    Spitter findSpitterById(long id);

    @Select(value = "select * from spitter where username=#{username}")
    Spitter findSpitterByUserName(String userName);


    @Insert(value = "insert into spitter(username,password,fullname,email,update_by_email) " +
            "values(#{username},#{password},#{fullname},#{email},#{updateByEmail})")
    void addSpitter(Spitter spitter);


    void saveSpitter(Spitter spitter);

    @Select(value = "select * from spitter where id=#{id}")
    Spitter getSpitterById(long id);

    @Select(value = "select * from spittle order by id desc limit #{shownum}")
    List<Spittle> getRecentSpittle(@Param("shownum") int shownum);


    @Insert(value = "insert into spittle(spitterId,spittleText,postedTime) values(#{spitterId},#{spittleText},#{postedTime})")
    void saveSpittle(Spittle spittle);

    @Select(value = "select * from spittle,spitter where spittle.spitter_id=spitter.id and spitter_id=#{id}")
    List<Spittle> getSpittlesForSpitter(Spitter spitter);

    @Select(value = "select * from spitter where username=#{username}")
    Spitter getSpitterByUsername(String username);

    @Delete(value = "delete from spittle where id=#{id}")
    void deleteSpittle(long id);

    @Select(value = "select * from spittle where id=#{id}")
    Spittle getSpittleById(long id);

    @Select(value = "select * from spitter")
    List<Spitter> findAllSpitters();
}
