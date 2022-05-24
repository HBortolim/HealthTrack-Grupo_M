package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.ActivityDao;
import model.dao.ActivityTypeDao;
import model.entities.ActivityType;
import model.entities.Weight;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActivityTypeDaoJDBC implements ActivityTypeDao {

    private Connection conn;

    public ActivityTypeDaoJDBC(Connection conn) {
        this.conn = conn;
    }
    @Override
    public List<ActivityType> getAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM t_tipo_atv"
            );
            rs = st.executeQuery();

            List<ActivityType> list = new ArrayList<>();
            while(rs.next()){
                ActivityType activityType = instantiateActivityType(rs);
                list.add(activityType);
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
    public void insert(ActivityType obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO t_tipo_atv (id_atividade,nm_atividade) " +
                    "VALUES (?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setInt(1, obj.getId());
            st.setString(2,obj.getName());

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
    private static ActivityType instantiateActivityType(ResultSet rs) throws SQLException {
        ActivityType activityType = new  ActivityType();

        activityType.setId(rs.getInt("id_atividade"));
        activityType.setName(rs.getString("nm_atividade"));
        return activityType;
    }
}
