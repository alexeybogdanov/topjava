package ru.javawebinar.topjava.web.meal;

import org.springframework.stereotype.Controller;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.service.MealService;

import java.util.List;

@Controller
public class MealRestController {

    private MealService service;

    public MealRestController(MealService service) {
        this.service = service;
    }

    public Meal create(Meal meal) {
        return service.create(meal);
    }

    public void delete(int id, int userId) {
        service.delete(id, userId);
    }

    public Meal get(int id, int userId) {
        return service.get(id, userId);
    }

    public List<Meal> getAll(int userId) {
        return (List<Meal>) service.getAll(userId);
    }

    public void update(Meal meal) {
        service.create(meal);
    }


}