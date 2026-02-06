import java.util.*;

import static java.lang.String.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        TaskManagerInterface taskManager = new TaskManager();
        UserManagerInterface userManager = new UserManager();


        while (true) {

            User currentUser = (User) userManager.CheckUser();
            taskManager.setCurrentUser(currentUser);
            Integer choice = 0;//declare it
            while (choice != 5) //unboxing
            {
                System.out.println("1.Add Task");
                System.out.println("2.List all Tasks");
                System.out.println("3.Update");
                System.out.println("4.Delete");
                System.out.println("5.Exit");
                try {
                    System.out.println("Enter your Choice:");
                    choice = new Integer(sc.nextLine());
                } catch (Exception e) {
                    System.out.println("You have to enter only numbers!");
                    continue;
                }

                if (choice == 1) {
                    taskManager.addTask();

                }
                else if (choice == 2) {
                    taskManager.listChoice();

                }
                else if (choice == 3) {
                    taskManager.Update();
                }

                else if (choice == 4) {
                    taskManager.Delete();
                }
                else if (choice == 5) {
                    System.out.println("Thanks for Using!");
                }
                else {
                    System.out.println("Your choice is Invalid");
                }
            }
        }
    }

}
