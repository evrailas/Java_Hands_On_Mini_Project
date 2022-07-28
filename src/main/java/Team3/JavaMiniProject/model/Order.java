package Team3.JavaMiniProject.model;

import Team3.JavaMiniProject.types.PaymentMethod;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
import java.util.List;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class Order extends BaseModel {

    private String deliveryAddress;
    private PaymentMethod paymentMethod;
    private BigDecimal paymentAmount;
    private Customer customer;
    private List<OrderItem> orderItemList;


}
