package model.entities;

import java.util.Date;

public class BloodPressure {
    private Double value;
    private Date date;

    public BloodPressure() {
    }

    public BloodPressure(Double value, Date date) {
        this.value = value;
        this.date = date;
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
}
