package cn.meijunjie.test;

import lombok.*;

import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Classes {

    private Integer id;
    private String name;
    private  Teacher teacher;
    List<Student> students;
}
