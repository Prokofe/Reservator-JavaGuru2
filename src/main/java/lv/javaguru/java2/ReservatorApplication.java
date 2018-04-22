package lv.javaguru.java2;

import lv.javaguru.java2.config.SpringAppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Scanner;

public class ReservatorApplication {
    public static void main(String[] args) {

        ApplicationContext applicationContext
                = new AnnotationConfigApplicationContext(SpringAppConfig.class);

//        ReservationDatabase database = new ReservationInMemoryDatabase();
//
//        View addReservationView = new AddReservationView(database);
//        View removeReservationView = new RemoveReservationView(database);
//        View showReservationList = new ShowReservationListView(database);
//        View programExitView = new ProgramExitView();
//
//        Map<Integer, View> actionMap = new HashMap<>();
//        actionMap.put(1, addReservationView);
//        actionMap.put(2, removeReservationView);
//        actionMap.put(3, showReservationList);
//        actionMap.put(4, programExitView);
//
//        while (true) {
//            printProgramMenu();
//            int menuItem = gerFromUserMenuItemToExecute();
//            View view = actionMap.get(menuItem);
//            view.execute();
//        }
    }

        private static void printProgramMenu(){
        System.out.println("1. Add new reservation");
        System.out.println("2. Remove reservation");
        System.out.println("3. Print all reservations");
        System.out.println("4. Exit");
    }

        private static int gerFromUserMenuItemToExecute(){
            System.out.print("Please enter menu item number to execute: ");
            Scanner sc = new Scanner(System.in);
            return Integer.parseInt(sc.nextLine());
        }
    }
