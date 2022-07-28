package Team3.JavaMiniProject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

import java.math.BigDecimal;
@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class Product extends BaseModel {

    private String productName;
    private BigDecimal productPrice;
    private String productInfo;
}
