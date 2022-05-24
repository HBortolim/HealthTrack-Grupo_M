package model.dao;

import model.entities.BloodPressure;

import java.util.List;

public interface BloodPressureDao {
    List<BloodPressure> getAll();

    void insert(BloodPressure obj);
}
