package model.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Weight implements Serializable {

    private Integer id;
    private Double weight;
    private Date date;
    private User user;

    public Weight() {
    }

    public Weight(Integer id,Double weight, Date date,User user) {
        this.id = id;
        this.date = date;
        this.user = user;
        this.weight = weight;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Weight weight = (Weight) o;
        return id.equals(weight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Weight{" +
                "weight=" + weight +
                ", date=" + date +
                '}';
    }
}
