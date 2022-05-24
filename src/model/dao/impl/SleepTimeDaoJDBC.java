//package model.dao.impl;
//
//import model.dao.SleepTimeDao;
//import model.entities.Meal;
//import model.entities.MealType;
//import model.entities.SleepTime;
//import model.entities.User;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//public class SleepTimeDaoJDBC implements SleepTimeDao {
//    private Connection conn;
//
//    public SleepTimeDaoJDBC(Connection conn) {
//        this.conn = conn;
//    }
//
//    @Override
//    public List<SleepTime> getAll() {
//        return null;
//    }
//
//    @Override
//    public void insert(SleepTime obj) {
//
//    }
//
//    private SleepTime instantiateMeal(ResultSet rs) throws SQLException {
//        SleepTime sleepTime = new SleepTime();
//        User user = new User();
//        sleepTime.setId(rs.getInt("id_refeicao"));
//        sleepTime.setDate(rs.getDate("dt_alimento"));
//        sleepTime.setTimeSleeping(rs.getDate("nm_alimento"));
//        sleepTime.setUser(user);
//        return sleepTime;
//    }
//}
