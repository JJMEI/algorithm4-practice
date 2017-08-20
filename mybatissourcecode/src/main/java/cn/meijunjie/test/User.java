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
    private String username;
    private String password;
}
