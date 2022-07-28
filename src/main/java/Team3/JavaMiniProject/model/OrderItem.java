package Team3.JavaMiniProject.model;

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
public class OrderItem extends BaseModel {

    private BigDecimal finalPrice;
    private List<Product> list;


}
