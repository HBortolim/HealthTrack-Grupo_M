package model.entities;

import java.util.Date;

public class SleepTime {
    private Date date;
    private Date timeSleeping;

    public SleepTime() {
    }

    public SleepTime(Date date, Date timeSleeping) {
        this.date = date;
        this.timeSleeping = timeSleeping;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getTimeSleeping() {
        return timeSleeping;
    }

    public void setTimeSleeping(Date timeSleeping) {
        this.timeSleeping = timeSleeping;
    }
}
