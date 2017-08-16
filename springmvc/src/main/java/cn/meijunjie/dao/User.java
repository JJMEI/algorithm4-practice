package cn.meijunjie.dao;

import lombok.*;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@ToString
@EqualsAndHashCode
public class User implements Serializable{

    @Pattern(regexp = "w{4,30}")  //用户名可以为字符 数字 下划线长度在4-30之间
    private String userName;

    @Pattern(regexp = "S{6,30}") //密码为非空字符，长度在6-30之间
    private String password;

    @Email   //必须符合邮件规则
    private String email;

    @Length(min = 2, max = 100) //针对字符串而言 其长度在2-100之间
    private String realName;

    @Past   //生日必须为一个过去的时间
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date birthday;

    @DecimalMin(value = "1000.00")
    @DecimalMax(value = "10000.00")
//    @NumberFormat(pattern = "#,###.##")  //薪水必须在1000.00到10000.00之间
    private long salary;

}
