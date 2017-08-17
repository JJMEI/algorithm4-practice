package cn.meijunjie.test;

import lombok.*;

//java bean
@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class User {

    private Integer id;
    private String userName;
    private String password;
}
