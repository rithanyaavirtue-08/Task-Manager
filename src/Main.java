import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User[] userArray = new User[5];
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.println("Welcome To Task Management");
            System.out.println("Enter your Username:");
            String username = new String(sc.nextLine());

            boolean isExistingUser = false;
            int isCurrentPosition = 0;
            for (int count = 0; count < userArray.length; count++) {
                if (userArray[count] == null) {
                    continue;
                }
                if (userArray[count].getUsername().equals(username)) {
                    isExistingUser = true;
                    isCurrentPosition = count;
                    break;
                }
            }

            User currentUser;
            if (!isExistingUser) {
                currentUser = new User(username);
                for (int count = 0; count < userArray.length; count++) {
                    if (userArray[count] != null) {
                        continue;
                    }

                    userArray[count] = currentUser;
                    break;


                }
            }
            else {
                currentUser = userArray[isCurrentPosition];
            }
            Integer choice = 0;//this is called autoboxing
            while (choice != 5) //this is unboxing
            {
                System.out.print("Welcome ");
                System.out.println(currentUser.getUsername());
                System.out.println("1.Add task");
                System.out.println("2 List the tasks");
                System.out.println("3.Update");
                System.out.println("4 Delete");
                System.out.println("5 Exit");
                System.out.println("Enter your choice:");
                choice = new Integer(sc.nextLine());

                Task userTask;
                if (choice == 1) {
                    System.out.println("Enter your Task Description:");
                    String taskDescription = new String(sc.nextLine());
                    userTask = new Task(taskDescription);
                    for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                        if (currentUser.getTaskArray()[count] == null) {
                            currentUser.getTaskArray()[count] = userTask;
                            System.out.println("Task Added successfully :) :) ");
                            break;
                        }

                    }
                }
                else if (choice == 2) {
                    boolean isTaskAvailable = false;
                    for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                        if (currentUser.getTaskArray()[count] != null) {
                            String taskDescription = currentUser.getTaskArray()[count].getTaskDescription();
                            int num=count+1;
                            System.out.print(num);
                            System.out.print(".");
                            System.out.println(taskDescription);
                            isTaskAvailable = true;

                        }
                    }
                    if (!isTaskAvailable) {
                        System.out.println("No task Available");
                    }
                }

                else if (choice == 3) {
                    boolean istaskUpdated = false;
                    for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                        if (currentUser.getTaskArray()[count] != null)
                        {
                            int num=count+1;
                            String taskDescription = currentUser.getTaskArray()[count].getTaskDescription();
                            System.out.print(num );
                            System.out.print(".");
                            System.out.println(taskDescription);
                            istaskUpdated = true;

                        }
                     }
                    System.out.println("Enter the task number to update:");
                    Integer updatenum = new Integer(sc.nextLine());
                    int replacement = updatenum - 1;
                    System.out.println("What task you want to replace?");
                    Task update = new Task(sc.nextLine());//task is also formed as string because of array creation
                    currentUser.getTaskArray()[replacement] = update;
                    System.out.println("Your task is updated!!");
                    if (!istaskUpdated) {
                        System.out.println("No task updated now");
                    }




                    }

                else if (choice == 4) {
                    boolean isTaskDeleted = false;
                    for (int count = 0; count < currentUser.getTaskArray().length; count++)
                    {
                        if (currentUser.getTaskArray()[count] != null)
                        {
                            String taskDescription = currentUser.getTaskArray()[count].getTaskDescription();
                            int num=count+1;
                            System.out.print(num);
                            System.out.print(".");
                            System.out.println(taskDescription);
                            isTaskDeleted = true;

                        }}
                    System.out.println("Enter the task number to delete:");
                    Integer delnum = new Integer(sc.nextLine());
                    currentUser.getTaskArray()[delnum - 1] = null;
                    System.out.println("Your Task Deleted");

                    if (!isTaskDeleted) {
                            System.out.println("No task Deleted");

                        }

                }
                else{
                    System.out.println("Thank for Using us!");
                }
            }

        }
    }
}

