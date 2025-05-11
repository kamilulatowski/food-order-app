package pl.kulatowski.food_order.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Food {

    private final Type type;
    private String name;
    private List<Ingredient> ingrediens;

    public enum Type {
        PIZZA, BURGER, TACO, KEBAB, SUSHI
    }
}
