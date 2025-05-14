package pl.kulatowski.food_order.model;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class Address {

    @NotBlank(message = "Podanie imienia i nazwiska jest obowiązkowe.")
    private String name;
    @NotBlank(message = "Podanie ulicy jest obowiązkowe.")
    private String street;
    @NotBlank(message = "Podanie nazwy miejscowości jest obowiązkowe.")
    private String city;
    @NotBlank(message = "Podanie nazwy województwa jest obowiązkowe.")
    private String state;
    @NotBlank(message = "Podanie kodu pocztowego jest obowiązkowe.")
    private String zip;
}
