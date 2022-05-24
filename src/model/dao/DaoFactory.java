package model.dao;

import db.DB;
import model.dao.impl.*;

public class DaoFactory {
    public static WeightDaoJDBC createWeightDao(){
        return new WeightDaoJDBC(DB.getConnection());
    }

    public static ActivityDaoJDBC createActivityDao(){
        return new ActivityDaoJDBC(DB.getConnection());
    }

    public static ActivityTypeDaoJDBC createActivityTypeDao(){
        return new ActivityTypeDaoJDBC(DB.getConnection());
    }
    public static BloodPressureDaoJDBC createBloodPressureDao(){
        return new BloodPressureDaoJDBC(DB.getConnection());
    }
    public static MealTypeDaoJDBC createMealTypeDao(){
        return new MealTypeDaoJDBC(DB.getConnection());
    }
    public static MealDaoJDBC createMealDao(){
        return new MealDaoJDBC(DB.getConnection());
    }
}
