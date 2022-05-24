package model.entities;

import java.io.Serializable;
import java.util.Date;

public class Meal implements Serializable {

    private Integer id;
    private String name;
    private Date date;
    private Integer kcal;

    private MealType mealType;

    private User user;

    public Meal() {
    }

    public Meal(Integer id,String name, Date date, Integer kcal,MealType mealType,User user) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.kcal = kcal;
        this.mealType = mealType;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getKcal() {
        return kcal;
    }

    public void setKcal(Integer kcal) {
        this.kcal = kcal;
    }

    public MealType getMealType() {
        return mealType;
    }

    public void setMealType(MealType mealType) {
        this.mealType = mealType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", kcal=" + kcal +
                ", mealType=" + mealType +
                ", user=" + user +
                '}';
    }
}
