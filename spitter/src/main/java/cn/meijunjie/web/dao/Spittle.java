package cn.meijunjie.web.dao;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Spittle implements Serializable{

    private static final long serialVersionUID = 423423412423L;

    private Long id;
    private String spittleText;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date postedTime;

    //1对1,每一篇对应一个spitter
    private Spitter spitter;

}
