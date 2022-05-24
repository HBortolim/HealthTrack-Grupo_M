package model.dao;

import model.entities.Weight;

import java.util.List;

public interface WeightDao {
    List<Weight> getAll();
    void insert(Weight obj);
    void update(Weight obj);
    void delete(Integer id);

}
