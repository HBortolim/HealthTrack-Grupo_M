package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.BloodPressureDao;
import model.entities.BloodPressure;
import model.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BloodPressureDaoJDBC implements BloodPressureDao {

    private Connection conn;

    public BloodPressureDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<BloodPressure> getAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM t_pressao"
            );
            rs = st.executeQuery();

            List<BloodPressure> list = new ArrayList<>();
            while(rs.next()){
                BloodPressure activity = instantiateBloodPressure(rs);
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
    public void insert(BloodPressure obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO t_pressao (dt_pressao,vl_pressao,t_user_id_usuario) " +
                    "VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setDate(1, new java.sql.Date(obj.getDate().getTime()));
            st.setDouble(2,obj.getValue());
            st.setInt(3,obj.getUser().getId());

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

    private static BloodPressure instantiateBloodPressure(ResultSet rs) throws SQLException {
        User user = new User();
        BloodPressure bloodPressure = new BloodPressure();
        bloodPressure.setId(rs.getInt("id_pressao"));
        bloodPressure.setDate(rs.getDate("dt_pressao"));
        bloodPressure.setValue(rs.getDouble("vl_pressao"));
        bloodPressure.setUser(user);
        return bloodPressure;
    }
}
