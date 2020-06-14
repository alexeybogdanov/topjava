package ru.javawebinar.topjava.dao;

import ru.javawebinar.topjava.model.Meal;

import java.util.List;

public interface MealDao {
    List<Meal> getAllMeal();

    void delete(int mealId);

    Meal getById(int mealId);

    void  save(Meal meal);
}
