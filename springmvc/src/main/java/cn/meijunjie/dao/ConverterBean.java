package cn.meijunjie.dao;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ConverterBean {

    private String name;
    private String password;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    @NumberFormat(pattern = "#,###.##")
    private long salay;
}
