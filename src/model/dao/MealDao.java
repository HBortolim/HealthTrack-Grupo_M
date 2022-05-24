package model.dao;

import model.entities.Meal;

import java.util.List;

public interface MealDao {
    List<Meal> getAll();
    void insert(Meal obj);
}
