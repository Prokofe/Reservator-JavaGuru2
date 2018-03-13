package lv.javaguru.java2;

import lv.javaguru.java2.database.ContactDatabase;
import lv.javaguru.java2.database.ContactInMemoryDatabase;
import lv.javaguru.java2.view.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ContactApplication {

    public static void main(String[] args) {
        // Use cases:
        // 1.Add Client
        // 2.Remove Client
        // 3.Show Client list
        // 4.Exit

        ContactDatabase contactDatabase = new ContactInMemoryDatabase();

        View addContactView = new AddContactView(contactDatabase);
        View removeContactView = new RemoveContactView(contactDatabase);
        View showContactView = new ShowContactView(contactDatabase);
        View contactExitView = new ContactExitView();

        Map<Integer, View> actionMap = new HashMap<>();
        actionMap.put(1, addContactView);
        actionMap.put(2, removeContactView);
        actionMap.put(3, showContactView);
        actionMap.put(4, contactExitView);

        while (true) {
            printContactMenu();
            int menuItem = getFromUserMenuItemToExecute();
            View view = actionMap.get(menuItem);
            view.execute();
        }

    }

    private static void printContactMenu() {
        System.out.println("Contact Menu:");
        System.out.println("1. Add client to a list");
        System.out.println("2. Remove client from the list");
        System.out.println("3. Print client list");
        System.out.println("4. Exit");
    }

    private static int getFromUserMenuItemToExecute() {
        System.out.println("Please enter menu item number to execute:");
        Scanner sc = new Scanner(System.in);
        return Integer.parseInt(sc.nextLine());
    }

}
