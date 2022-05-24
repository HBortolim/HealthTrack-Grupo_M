package model.dao.impl;

import db.DB;
import db.DbException;
import model.entities.Weight;
import model.dao.WeightDao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class WeightDaoJDBC implements WeightDao {

    private Connection conn;

    public WeightDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Weight> getAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM t_peso"
                    );
            rs = st.executeQuery();

            List<Weight> list = new ArrayList<>();
            while(rs.next()){
                Weight weight = instantiateWeight(rs);
                list.add(weight);
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
    public void insert(Weight obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO t_peso (dt_peso,vl_peso,t_user_id_usuario) " +
                    "VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setDate(1, new java.sql.Date(obj.getDate().getTime()));
            st.setDouble(2,obj.getWeight());
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

    @Override
    public void update(Weight obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("UPDATE t_peso " +
                    "SET dt_peso = ?, " +
                    "t_user_id_usuario = ?," +
                    "vl_peso = ?");
            st.setDate(1,new java.sql.Date(obj.getDate().getTime()));
            st.setInt(2,obj.getId());
            st.setDouble(3,obj.getWeight());

            st.executeUpdate();
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());

        }
        finally {
            DB.closeStatement(st);
        }
    }

    @Override
    public void delete(Integer id) {
        PreparedStatement st = null;
        try{
            st = conn.prepareStatement("DELETE FROM t_peso WHERE id_peso = ?");
            st.setInt(1,id);

            st.executeUpdate();
        }
        catch (SQLException e){
            throw new DbException(e.getMessage());
        }
        finally {
            DB.closeStatement(st);
        }
    }

    private static Weight instantiateWeight(ResultSet rs) throws SQLException {
        Weight weight = new  Weight();

        weight.setDate(rs.getDate("dt_peso"));
        weight.setId(rs.getInt("t_user_id_usuario"));
        weight.setWeight(rs.getDouble("vl_peso"));
        return weight;
    }
}
