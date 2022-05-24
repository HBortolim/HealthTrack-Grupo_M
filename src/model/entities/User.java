package model.entities;

import model.enums.MealType;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Integer id;
    private String name;
    private String password;
    private String email;
    private String phone;
    private String cpf;
    private String address;
    private Integer age;
    private Float height;
    private Character gender;

    private MealType mealType;

    private List<User> subscribedUser = new ArrayList<>();
    private List<Meal> meals = new ArrayList<>();
    private List<BloodPressure> bloodPressureList = new ArrayList<>();
    private List<SleepTime> sleepTimeList = new ArrayList<>();
    private List<Activity> activities = new ArrayList<>();
    private List<Weight> weights = new ArrayList<>();

    public User() {
    }

    public User(Integer id,String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCpf() {
        return cpf;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getAge() {
        return age;
    }

    public Float getHeight() {
        return height;
    }

    public Character getGender() {
        return gender;
    }

    public List<Weight> getWeights() {
        return weights;
    }

    public void addMeal(Meal meal){
        meals.add(meal);
    }

    public void removeMeal(Meal meal){
        meals.remove(meal);
    }

    public void addBloodPressure(BloodPressure bp){
        bloodPressureList.add(bp);
    }

    public void removeBloodPressure(BloodPressure bp){
        bloodPressureList.remove(bp);
    }

    public void addSleepTime(SleepTime time){
        sleepTimeList.add(time);
    }

    public void removeSleepTime(SleepTime time){
        sleepTimeList.remove(time);
    }

    public void addActivity(Activity activity){
        activities.add(activity);
    }

    public void removeActivity(Activity activity){
        activities.remove(activity);
    }

    public void addWeight(Weight weight){
        weights.add(weight);
    }

    public void removeWeight(Weight weight){
        weights.remove(weight);
    }

}
