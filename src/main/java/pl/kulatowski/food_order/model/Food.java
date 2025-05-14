package pl.kulatowski.food_order.model;

import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Food {

    private final Type type;
    private String name;
    @Size(min = 1, message = "Musisz wybrać przynajmniej jeden składnik.")
    private List<Ingredient> ingrediens;

    public enum Type {
        PIZZA, BURGER, TACO, KEBAB, SUSHI
    }
}
