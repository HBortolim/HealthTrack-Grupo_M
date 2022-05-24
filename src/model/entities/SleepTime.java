package model.entities;

import java.io.Serializable;
import java.util.Date;

public class SleepTime implements Serializable {

    private Integer id;
    private Date date;
    private Date timeSleeping;

    private User user;

    public SleepTime() {
    }

    public SleepTime(Integer id,Date date, Date timeSleeping,User user) {
        this.id = id;
        this.date = date;
        this.timeSleeping = timeSleeping;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Date getTimeSleeping() {
        return timeSleeping;
    }

    public void setTimeSleeping(Date timeSleeping) {
        this.timeSleeping = timeSleeping;
    }

    @Override
    public String toString() {
        return "SleepTime{" +
                "id=" + id +
                ", date=" + date +
                ", timeSleeping=" + timeSleeping +
                ", user=" + user +
                '}';
    }
}
