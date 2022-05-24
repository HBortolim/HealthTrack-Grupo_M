//package model.dao.impl;
//
//import model.dao.UserDao;
//
//import model.entities.User;
//
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.List;
//
//public class UserDaoJDBC implements UserDao {
//    private Connection conn;
//
//    public UserDaoJDBC(Connection conn) {
//        this.conn = conn;
//    }
//
//    @Override
//    public List<User> getAll() {
//        return null;
//    }
//
//    @Override
//    public void insert(User obj) {
//
//    }
//
//    private User instantiateUser(ResultSet rs) throws SQLException {
//        User user = new User();
//        user.setId(rs.getInt("id_refeicao"));
//        user.setName(rs.getString("dt_alimento"));
//        return user;
//    }
//}
