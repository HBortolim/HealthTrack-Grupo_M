package model.dao;

import model.entities.SleepTime;

import java.util.List;

public interface SleepTimeDao {
    List<SleepTime> getAll();

    void insert(SleepTime obj);
}
