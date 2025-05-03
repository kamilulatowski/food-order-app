package pl.kulatowski.food_order.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api")
public class FoodController {

    @GetMapping("/food-type")
    public String getFoodType() {
        return "home";
    }
}
