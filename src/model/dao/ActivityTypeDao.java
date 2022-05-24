package model.dao;

import model.entities.ActivityType;

import java.util.List;

public interface ActivityTypeDao {
    List<ActivityType> getAll();
    void insert(ActivityType obj);
}
