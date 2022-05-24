package model.dao;

import model.entities.Activity;

import java.util.List;

public interface ActivityDao {

    List<Activity> getAll();
    void insert(Activity obj);
}
