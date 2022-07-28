package Team3.JavaMiniProject.model;

import Team3.JavaMiniProject.types.CustomerType;
import jdk.jshell.Snippet;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;


@Getter
@Setter
@ToString(callSuper = true)
@SuperBuilder
public class Customer extends BaseModel{

    private String fullName;
    private String address;
    private CustomerType customerType;
    private Wallet wallet;


}
