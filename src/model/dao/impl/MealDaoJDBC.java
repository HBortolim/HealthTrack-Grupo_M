package model.dao.impl;

import db.DB;
import db.DbException;
import model.dao.DaoFactory;
import model.dao.MealDao;
import model.entities.Activity;
import model.entities.Meal;
import model.entities.MealType;
import model.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MealDaoJDBC implements MealDao {
    private Connection conn;

    public MealDaoJDBC(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Meal> getAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            st = conn.prepareStatement("SELECT * FROM t_det_alim"
            );
            rs = st.executeQuery();

            List<Meal> list = new ArrayList<>();
            while(rs.next()){

                Meal meal = instantiateMeal(rs);
                list.add(meal);
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
    public void insert(Meal obj) {
        PreparedStatement st = null;
        try {
            st = conn.prepareStatement("INSERT INTO t_det_alim (dt_alimento,t_tipo_ref_id_refeicao,nm_alimento,vl_calorias,t_usuario_id_usario) " +
                    "VALUES (?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);

            st.setDate(1, new java.sql.Date(obj.getDate().getTime()));
            st.setInt(2,obj.getMealType().getId());
            st.setString(3, obj.getName());
            st.setInt(4,obj.getKcal());
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

    private Meal instantiateMeal(ResultSet rs) throws SQLException {
        Meal meal = new Meal();
        User user = new User();
        MealType mealType = new MealType();
        meal.setId(rs.getInt("id_refeicao"));
        meal.setDate(rs.getDate("dt_alimento"));
        meal.setMealType(mealType);
        meal.setName(rs.getString("nm_alimento"));
        meal.setKcal(rs.getInt("vl_calorias"));
        meal.setUser(user);
        return meal;
    }
}
