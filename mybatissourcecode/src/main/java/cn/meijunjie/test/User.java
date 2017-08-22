package cn.meijunjie.test;

import lombok.*;

import java.io.Serializable;

//java bean

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class User implements Serializable{

    private Integer id;
    private String username;
    private String password;
}
