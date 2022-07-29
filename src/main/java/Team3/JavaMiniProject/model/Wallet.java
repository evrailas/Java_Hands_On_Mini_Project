package Team3.JavaMiniProject.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class Wallet {
    float Value;

    public Wallet(float initialAmount) {
        Value = initialAmount;
    }

    public void AddMoney(float amount) {
        Value += amount;
    }

    public void SubMoney(float amount) {
        Value -= amount;
    }
}
