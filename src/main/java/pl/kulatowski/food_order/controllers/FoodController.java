package pl.kulatowski.food_order.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {

    @GetMapping("/")
    public String getFoodType() {
        return "home";
    }
}
