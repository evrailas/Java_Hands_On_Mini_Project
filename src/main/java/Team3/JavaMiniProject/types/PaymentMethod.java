package Team3.JavaMiniProject.types;

import java.math.BigDecimal;

public enum PaymentMethod {
    wireTransfer(new BigDecimal("0.1")),
    creditCard(new BigDecimal("0.15")),
    cash(new BigDecimal("0.0"));

    private final BigDecimal discountValue;

    PaymentMethod(BigDecimal discountValue) {
        this.discountValue = discountValue;
    }

    public BigDecimal getPaymentDiscount() {
        return discountValue;
    }
}
