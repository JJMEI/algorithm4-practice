package cn.meijunjie.test;

import org.apache.ibatis.annotations.*;

public interface BoardMapper {

    //注解用简单的可以使用
    @Select(value = "select * from t_board where board_id=#{id}")
    @Results(value = {
            @Result(id=true,column = "board_id",property = "id"),
            @Result(column = "board_name",property = "name"),
            @Result(column = "board_desc",property = "desc"),
            @Result(column = "topic_num",property = "num")
    })
    Board getBoardById(@Param("id") Integer id);



    @Insert("insert into t_board(board_name,board_desc,topic_num) values(#{board_name},#{board_desc},#{topic_num})")
    void insertBoard(Board board);
}
