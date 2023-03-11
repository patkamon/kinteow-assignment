package ku.kinteow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import ku.kinteow.dto.RestaurantDto;
import ku.kinteow.service.RestaurantService;

@Controller
public class RestaurantController {

    @Autowired
    private RestaurantService restaurantService;

    @GetMapping("/restaurant")
    public String getRestaurantPage(Model model) {
        model.addAttribute("restaurants", restaurantService.getRestaurants());
        return "restaurant";
    }

    @GetMapping("/restaurant/add")
    public String getAddPage() {
        return "restaurant-add";  // return restaurant-add.html
    }

    @PostMapping("/restaurant/add")
    public String addRestaurant(@ModelAttribute RestaurantDto restaurant,
                                Model model) {
        restaurantService.create(restaurant);
        return "redirect:/restaurant";
    }

}
