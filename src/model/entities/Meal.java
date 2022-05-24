package model.entities;

import java.util.Date;

public class Meal {
    private String name;
    private Date date;
    private Integer kcal;

    public Meal() {
    }

    public Meal(String name, Date date, Integer kcal) {
        this.name = name;
        this.date = date;
        this.kcal = kcal;
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
}
