import model.dao.*;
import model.entities.*;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


//        System.out.println("--------- Peso ------------");
//
//        WeightDao weightDao = DaoFactory.createWeightDao();
//        List<Weight> list;
//        list = weightDao.getAll();
//
//        for (Weight obj : list) {
//            System.out.println(obj);
//        }
//
//        User user = new User(3,"Clóvis da Silva","123456789","clov1234@gmail.com");
//        Weight weight = new Weight(null,80.0,new Date(),user);
//        weightDao.insert(weight);
//        System.out.println("Novo peso inserido! id = "+ weight.getId());
//
//        System.out.println("</--------- Peso ------------>");
//
//
//        System.out.println("--------- Atividade ------------");
//        ActivityTypeDao activityTypeDao = DaoFactory.createActivityTypeDao();
//        ActivityDao activityDao = DaoFactory.createActivityDao();
//        List<Activity> list1;
//        list1 = activityDao.getAll();
//
//        for (Activity obj : list1) {
//            System.out.println(obj);
//        }
//
//        ActivityType activityType = new ActivityType(3,"Teste");
//        activityTypeDao.insert(activityType);
//        Activity activity = new Activity(null,"Agachamento",new Date(),new Date(),90, activityType,user);
//        activityDao.insert(activity);
//        System.out.println("Nova atividade inserido! id = "+ activity.getId());
//
//        System.out.println("</--------- Atividade ------------>");


//        System.out.println("--------- Pressão ------------");
//
//        User user = new User(3,"Clóvis da Silva","123456789","clov1234@gmail.com");
//        BloodPressureDao bloodPressureDao = DaoFactory.createBloodPressureDao();
//        BloodPressure bloodPressure = new BloodPressure(null,125d/45d,new Date(),user);
//        bloodPressureDao.insert(bloodPressure);
//        System.out.println("Novo peso inserido! id = "+ bloodPressure.getId());
//
//        List<BloodPressure> list2;
//        list2 = bloodPressureDao.getAll();
//
//        for (BloodPressure obj : list2) {
//            System.out.println(obj);
//        }
//
//        System.out.println("</--------- Pressão ------------>");

        System.out.println("--------- Refeição ------------");

        MealTypeDao mealTypeDao = DaoFactory.createMealTypeDao();
        MealType mealType = new MealType(null,"Almoço");
        mealTypeDao.insert(mealType);

        System.out.println("</--------- Refeição ------------>");

        sc.close();

    }
}