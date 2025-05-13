package pl.kulatowski.food_order.model;

import lombok.Data;

@Data
public class Payment {

    private String ccNumber;
    private String ccExpiration;
    private String ccCVV;
}
