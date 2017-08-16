package cn.meijunjie.testng;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Order implements Serializable {

    private String orderId;
    private String orderName;
}
