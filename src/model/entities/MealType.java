package model.entities;

import java.io.Serializable;

public class MealType implements Serializable {

    private Integer id;
    private String descTipo;

    public MealType(Integer id, String descTipo) {
        this.id = id;
        this.descTipo = descTipo;
    }

    public MealType() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getdescTipo() {
        return descTipo;
    }

    public void setdescTipo(String descTipo) {
        this.descTipo = descTipo;
    }

    @Override
    public String toString() {
        return "MealType{" +
                "id=" + id +
                ", descTipo='" + descTipo + '\'' +
                '}';
    }
}
