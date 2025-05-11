package pl.kulatowski.food_order.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kulatowski.food_order.model.Food;
import pl.kulatowski.food_order.model.Ingredient;
import pl.kulatowski.food_order.model.Ingredient.Type;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderFoodController {

    @GetMapping
    public String showDesignForm(Model model) {
        List<Ingredient> ingredients = Arrays.asList(
                new Ingredient("FLOTO", "pszenna", Type.WRAP),
                new Ingredient("COTO", "kukurydziana", Type.WRAP),
                new Ingredient("GRBF", "mielona wołowina", Type.PROTEIN),
                new Ingredient("CARN", "kawałki mięsa", Type.PROTEIN),
                new Ingredient("IMTO", "pomidory", Type.VEGGIES),
                new Ingredient("LETC", "sałata", Type.VEGGIES),
                new Ingredient("CHED", "cheddar", Type.CHEESE),
                new Ingredient("MOZA", "mozzarella", Type.CHEESE),
                new Ingredient("SLSA", "salsa", Type.SAUCE),
                new Ingredient("SRCR", "śmietana", Type.SAUCE)
        );

        Type[] types = Ingredient.Type.values();
        for (Type type : types) {
            model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
        }
        model.addAttribute("order", new Food(Food.Type.TACO));
        return "order";
    }

    private List<Ingredient> filterByType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }
}
