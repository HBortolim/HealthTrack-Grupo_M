package model.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Activity implements Serializable {

    private Integer id;
    private String name;
    private Date date;
    private Date activityTime;
    private Integer kcalSpent;
    private User user;

    private ActivityType activityType;

    private List<Activity> activities = new ArrayList<>();


    public Activity(String name, Date date, Date activityTime, Integer kcalSpent, User user, ActivityType activityType) {
        this.name = name;
        this.date = date;
        this.activityTime = activityTime;
        this.kcalSpent = kcalSpent;
        this.user = user;
        this.activityType = activityType;
    }

    public Activity(Integer id, String name, Date date, Date activityTime, Integer kcalSpent, ActivityType activityType, User user) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.activityTime = activityTime;
        this.kcalSpent = kcalSpent;
        this.activityType = activityType;
        this.user = user;
    }

    public Activity() {
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

    public Date getActivityTime() {
        return activityTime;
    }

    public void setActivityTime(Date activityTime) {
        this.activityTime = activityTime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Integer getKcalSpent() {
        return kcalSpent;
    }

    public void setKcalSpent(Integer kcalSpent) {
        this.kcalSpent = kcalSpent;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public Integer totalKcalSpent(int kcalSpent){
        int kcals = 0;
        for (Activity activity : activities) {
            kcals+= activity.getKcalSpent();
        }
        return kcals;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Activity activity = (Activity) o;
        return id.equals(activity.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date=" + date +
                ", activityTime=" + activityTime +
                ", kcalSpent=" + kcalSpent +
                ", user=" + user.getName() +
                '}';
    }
}
