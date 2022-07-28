package Team3.JavaMiniProject.model;

import java.math.BigDecimal;

public class Wallet {
    float Value;

    public Wallet(float initialAmount) {
        Value = initialAmount;
    }

    public void AddMoney(float amount)
    {
        Value += amount;
    }

    public void SubMoney(float amount)
    {
        Value -= amount;
    }
}
