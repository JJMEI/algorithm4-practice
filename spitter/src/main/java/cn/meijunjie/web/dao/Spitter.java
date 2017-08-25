package cn.meijunjie.web.dao;

import lombok.*;
import org.hibernate.validator.constraints.Email;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Spitter implements Serializable{

    private static final Long serialVersionUID = 424124234234134L;

    private Long id;

//    @Pattern(regexp = "w{3,16}",message = "用户名不符合规范，请检查重新输入！")
    @Size(min = 4,max = 12,message = "用户名不符合规范，请检查重新输入！" )
    private String username;

    @Pattern(regexp = "[0-9a-z_]{6,16}$",message = "密码不符合规范，请重新输入")
    private String password;

    @Size(min = 2, max = 12,message = "真实姓名必须在2-12个字符之间")
    private String fullname;

    //一对多查询，每一个spitter 有多个Spittle
    private List<Spittle> spittles;

    @Email
    private String email;

    @NotNull
    private boolean updateByEmail;
}
