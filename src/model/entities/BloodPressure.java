package model.entities;

import java.io.Serializable;
import java.util.Date;

public class BloodPressure implements Serializable {

    private Integer id;
    private Double value;
    private Date date;

    private User user;

    public BloodPressure() {
    }

    public BloodPressure(Integer id,Double value, Date date, User user) {
        this.id = id;
        this.value = value;
        this.date = date;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
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
    public String toString() {
        return "BloodPressure{" +
                "id=" + id +
                ", value=" + value +
                ", date=" + date +
                ", user=" + user +
                '}';
    }
}
