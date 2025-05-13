package pl.kulatowski.food_order.model;

import lombok.Data;

@Data
public class Address {

    private String name;
    private String street;
    private String city;
    private String state;
    private String zip;
}
