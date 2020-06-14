package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Storage {

    public Map<Integer, Meal> getMealsMap() {
        return map;
    }

    public void seMealstMap(Map<Integer, Meal> map) {
        this.map = map;
    }

    private Map<Integer, Meal> map;

//    public List<Meal> getMeals() {
//        return meals;Map
//    }

    List<Meal> meals;

    public Storage() {
        meals = new ArrayList<>(Arrays.asList(
                new Meal(1,LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Завтрак", 500),
                new Meal(2,LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Обед", 1000),
                new Meal(3,LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Ужин", 500),
                new Meal(4,LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Еда на граничное значение", 100),
                new Meal(5,LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Завтрак", 1000),
                new Meal(6,LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Обед", 500),
                new Meal(7,LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Ужин", 410)
        ));

        map = new HashMap<>();
        for (int i = 1; i <= meals.size(); i++) {
            map.put(i, meals.get(i-1));
        }
    }
}
