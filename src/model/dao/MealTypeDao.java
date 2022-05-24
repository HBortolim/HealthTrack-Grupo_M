package model.dao;

import model.entities.MealType;

import java.util.List;

public interface MealTypeDao {

    List<MealType> getAll();
    void insert(MealType obj);
}
