package model.dao;

import model.entities.Weight;

import java.util.List;

public interface UserDao {
    List<Weight> getAll();

    void insert(Weight obj);
}
