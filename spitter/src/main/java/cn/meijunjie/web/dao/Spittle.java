package cn.meijunjie.web.dao;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Spittle {
    private Long id;
    private Spitter spitter;
    private String text;

    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date when;
}
