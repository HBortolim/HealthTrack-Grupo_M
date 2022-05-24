package model.entities;

import java.util.Date;

public class ActivityFootage extends Activity{
    private Float distance;

    public ActivityFootage(Integer id,String name, Date date, Date activityTime, Integer kcalSpent, Float distance, ActivityType activityType,User user) {
        super(id,name, date, activityTime, kcalSpent, activityType,user);
        this.distance = distance;
    }

    public ActivityFootage() {
    }

    public Float getDistance() {
        return distance;
    }

    public void setDistance(Float distance) {
        this.distance = distance;
    }

    public float totalDistance(float distance){
        return this.distance += distance;
    }

    @Override
    public Integer totalKcalSpent(int kcalSpent) {
        return super.totalKcalSpent(kcalSpent);
    }
}
