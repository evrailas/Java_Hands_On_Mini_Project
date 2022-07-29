package Team3.JavaMiniProject.types;

import java.math.BigDecimal;

public enum CustomerType {
    B2C(new BigDecimal("0.0")),
    B2B(new BigDecimal("0.2")),
    B2G(new BigDecimal("0.5"));

    private final BigDecimal discountValue;

    CustomerType(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public BigDecimal getClientDiscount() {
        return discountValue;
    }
}
