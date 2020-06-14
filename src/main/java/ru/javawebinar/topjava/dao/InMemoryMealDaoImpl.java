package ru.javawebinar.topjava.dao;

import org.slf4j.Logger;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.web.MealServlet;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.slf4j.LoggerFactory.getLogger;

public class InMemoryMealDaoImpl implements MealDao {
    private static final Logger log = getLogger(MealServlet.class);
    private Storage storage;

    public InMemoryMealDaoImpl() {
        storage = new Storage();
    }

    @Override
    public List<Meal> getAllMeal() {
        log.debug("dao getAll");
        return new ArrayList<>(storage.getMealsMap().values());
    }

    @Override
    public void delete(int mealId) {
        log.debug("deleting mealId {}", mealId);
//        allMeal.removeIf(meal -> meal.getId() == mealId);
        storage.getMealsMap().remove(mealId);

    }

    @Override
    public Meal getById(int mealId) {
        return storage.getMealsMap().get(mealId);
    }

    @Override
    public void save(Meal meal) {
        if (meal.getId() != 0) {
            Meal meal1 = storage.getMealsMap().get(meal.getId());
            meal1.setCalories(meal.getCalories());
            meal1.setDescription(meal.getDescription());
        } else {
            storage.getMealsMap().put(storage.getMealsMap().size()+1,meal);
        }
    }
}
