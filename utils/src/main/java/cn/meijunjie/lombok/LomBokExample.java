package cn.meijunjie.lombok;

import lombok.*;
import lombok.extern.java.Log;

@Getter             //生成getter方法
@Setter             //生成setter方法
@ToString           //生成toString方法
@EqualsAndHashCode //equals和hashcode方法
@NoArgsConstructor //无参构造函数
@AllArgsConstructor //全参构造函数
public class LomBokExample {

    private String userName;
    private String password;
}
