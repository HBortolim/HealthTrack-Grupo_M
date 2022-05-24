package model.dao;

import db.DB;
import model.dao.impl.ActivityDaoJDBC;
import model.dao.impl.WeightDaoJDBC;
import model.dao.impl.ActivityTypeDaoJDBC;

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
}
