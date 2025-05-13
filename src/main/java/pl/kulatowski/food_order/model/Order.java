package pl.kulatowski.food_order.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Order {

    private final String id;
    private final String orderNumber;
    private List<Food> foodList;
    private Address address;
    private Payment payment;
}
