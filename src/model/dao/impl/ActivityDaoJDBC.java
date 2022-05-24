package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.ActivityDao;
import model.entities.Activity;
import model.entities.ActivityType;
import model.entities.User;
import model.entities.Weight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityDaoJDBC implements ActivityDao {

    private Connection conn;

    public ActivityDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Activity> getAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM t_det_atv_fisica"
            );
            rs = st.executeQuery();

            List<Activity> list = new ArrayList<>();
            while(rs.next()){
                Activity activity = instantiateActivity(rs);
                list.add(activity);
            }
            return list;
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }

    @Override
    public void insert(Activity obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO t_det_atv_fisica (dt_atividade,t_tipo_atv_id_atividade,ds_atividade,vl_caloria_atv,t_user_id_usuario) " +
                    "VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setDate(1, new java.sql.Date(obj.getDate().getTime()));
            st.setInt(2,obj.getActivityType().getId());
            st.setString(3, obj.getName());
            st.setDouble(4,obj.getKcalSpent());
            st.setInt(5,obj.getUser().getId());

            int rowsAffected = st.executeUpdate();

            if (rowsAffected > 0){
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }

                DB.closeResultSet(rs);
            }
            else{
                throw new DbException("Nenhuma linha afetada!");
            }

        }
        catch (SQLException e){
            throw new DbException(e.getMessage());

        }
        finally {
            DB.closeStatement(st);
        }

    }

    private static Activity instantiateActivity(ResultSet rs) throws SQLException {
        Activity activity = new Activity();
        User user = new User();
        ActivityType activityType = new ActivityType();
        activity.setId(rs.getInt("id_atividade"));
        activity.setName(rs.getString("ds_atividade"));
        activity.setDate(rs.getDate("dt_atividade"));
        activity.setKcalSpent(rs.getInt("vl_caloria_atv"));
        activity.setUser(user);
        activity.setActivityType(activityType);
       //activity.setActivityTime(rs.getDate(""));
        return activity;
    }
}
