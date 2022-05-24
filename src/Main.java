import model.dao.ActivityDao;
import model.dao.ActivityTypeDao;
import model.entities.Activity;
import model.entities.ActivityType;
import model.entities.User;
import model.entities.Weight;
import model.dao.DaoFactory;
import model.dao.WeightDao;

import java.text.ParseException;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ParseException {

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);


        System.out.println("--------- Peso ------------");
        WeightDao weightDao = DaoFactory.createWeightDao();
        List<Weight> list;
        list = weightDao.getAll();

        for (Weight obj : list) {
            System.out.println(obj);
        }

        User user = new User(3,"Clóvis da Silva","123456789","clov1234@gmail.com");
        Weight weight = new Weight(null,80.0,new Date(),user);
        weightDao.insert(weight);
        System.out.println("Novo peso inserido! id = "+ weight.getId());
        System.out.println("</--------- Peso ------------>");


        System.out.println("--------- Atividade ------------");
        ActivityTypeDao activityTypeDao = DaoFactory.createActivityTypeDao();
        ActivityDao activityDao = DaoFactory.createActivityDao();
        List<Activity> list1;
        list1 = activityDao.getAll();

        for (Activity obj : list1) {
            System.out.println(obj);
        }

        ActivityType activityType = new ActivityType(3,"Teste");
        activityTypeDao.insert(activityType);
        Activity activity = new Activity(null,"Agachamento",new Date(),new Date(),90, activityType,user);
        activityDao.insert(activity);
        System.out.println("Nova atividade inserido! id = "+ activity.getId());

        System.out.println("</--------- Atividade ------------>");




        sc.close();

    }
}