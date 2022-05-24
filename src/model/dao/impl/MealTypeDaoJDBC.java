package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.MealTypeDao;
import model.entities.ActivityType;
import model.entities.MealType;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MealTypeDaoJDBC implements MealTypeDao {

    private Connection conn;

    public MealTypeDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<MealType> getAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM t_tipo_ref"
            );
            rs = st.executeQuery();

            List<MealType> list = new ArrayList<>();
            while(rs.next()){
                MealType mealType = instantiateMealType(rs);
                list.add(mealType);
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
    public void insert(MealType obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO t_tipo_ref (nm_refc) " +
                    "VALUES (?)", Statement.RETURN_GENERATED_KEYS);

            st.setString(1,obj.getdescTipo());

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

    private MealType instantiateMealType(ResultSet rs) throws SQLException {
        MealType mealType = new MealType();
        mealType.setId(rs.getInt("id_refc"));
        mealType.setdescTipo(rs.getString("nm_refc"));
        return mealType;
    }
}
