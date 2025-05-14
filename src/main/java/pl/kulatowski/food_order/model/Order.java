package pl.kulatowski.food_order.model;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Order {

    private final String id;
    private final String orderNumber;
    @Size(min = 1, message = "Musi zawierać przynajmniej jedno danie.")
    private List<Food> foodList;
    private Address address;
    private Payment payment;
}
