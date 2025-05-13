package pl.kulatowski.food_order.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.kulatowski.food_order.model.Food;
import pl.kulatowski.food_order.model.Ingredient;
import pl.kulatowski.food_order.model.Ingredient.Type;
import pl.kulatowski.food_order.model.Order;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Slf4j
@Controller
@RequestMapping("/order")
public class OrderFoodController {

    @GetMapping
    public String showOrderForm(Model orderModel) {
        List<Food> foodList = Arrays.asList(
                new Food(Food.Type.TACO),
                new Food(Food.Type.BURGER),
                new Food(Food.Type.KEBAB),
                new Food(Food.Type.PIZZA),
                new Food(Food.Type.SUSHI)
        );

        Food.Type[] foodTypes = Food.Type.values();
        for (Food.Type type : foodTypes) {
            orderModel.addAttribute("foodOrder", filterByFoodType(foodList, type));
        }
        orderModel.addAttribute("order", new Order(String.valueOf(new Random().nextLong()), String.valueOf(new Random().nextLong())));

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
            orderModel.addAttribute(type.toString().toLowerCase(), filterByIngredientType(ingredients, type));
        }
        orderModel.addAttribute("order", new Food(Food.Type.TACO));
        return "order";
    }

    @PostMapping
    public String processOrder(Order order) {
        log.info("Creating new order: {}", order);
        return "redirect:/order/current";
    }

    @GetMapping("/current")
    public String orderForm(Model model) {
        model.addAttribute("order", new Order(String.valueOf(new Random().nextLong()), String.valueOf(new Random().nextLong())));
        return "orderForm";
    }

    @PostMapping("/create")
    public String createOrder(Order order) {
        log.info("Zamówienie zostało złożone: {}", order);
        return "redirect:/";
    }

    private List<Food> filterByFoodType(List<Food> foodList, Food.Type type) {
        return foodList.stream()
                .filter(food -> food.getType().equals(type))
                .collect(Collectors.toList());
    }

    private List<Ingredient> filterByIngredientType(List<Ingredient> ingredients, Type type) {
        return ingredients.stream()
                .filter(ingredient -> ingredient.getType().equals(type))
                .collect(Collectors.toList());
    }
}
