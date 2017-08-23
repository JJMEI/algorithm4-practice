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
    @Pattern(regexp = "w{3,8}",message = "用户名不符合规范，请检查重新输入！")
    private String username;

    @Pattern(regexp = "w{6,15}",message = "密码不符合规范，请重新输入")
    private String password;

    @Size(min = 2, max = 12,message = "真实姓名必须在2-12个字符之间")
    private String fullName;
    private List<Spittle> spittles;

    @Email
    private String email;

    @NotNull
    private boolean updateByEmail;
}
