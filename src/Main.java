import java.util.*;

import static java.lang.String.*;

public class Main
{
    public static void main(String []args) {
        User[] existingUser = new User[5];
        Scanner sc = new Scanner(System.in);
        while (true) {

            System.out.println("Welcome to Task Manager");
            System.out.println("Enter Username:");
            String username = sc.nextLine();
            System.out.print("Welcome ");
            System.out.println(username);
            User currentUser = null;
            boolean isExistingUser = false;
            for (int i = 0; i < existingUser.length; i++) {
                if (existingUser[i] == null) {
                    continue;
                }

                if (existingUser[i].getUserName().equals(username)) {
                    isExistingUser = true;
                    currentUser = existingUser[i];
                    System.out.println("Happy To See you Again :) :)");
                    break;
                }
            }
            if (!isExistingUser) {
                currentUser = new User(username);
                for (int i = 0; i < existingUser.length; i++) {
                    if (existingUser[i] == null) {
                        existingUser[i] = currentUser;
                        break;
                    }
                }

            }

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
                boolean no=false;
                boolean yes=false;
                if (choice == 1) {
                    boolean Description = Main.Description(currentUser);//static method
                    if (!Description) {
                        System.out.println("No Task Added!");
                    }
                    else {
                        System.out.println("Previous Task Displayed!");
                    }
                    boolean exit = false;
                    String addedTask;
                    String action;
                    while (!exit)
                    {
                        try {
                            System.out.println("Enter your Title or  give 'exit' to Exit:");
                            addedTask = sc.nextLine();
                            if (addedTask.equals("exit")) {
                                throw new Exception();
                            }
                            for (int i = 0; i < currentUser.getTask().length; i++) {
                                if (currentUser.getTask()[i] == null) {
                                    currentUser.getTask()[i] = new Task(addedTask);
                                    System.out.println("Your Task Added Successfully :) :) ");
                                    break;
                                }
                                if (currentUser.getTask()[i] != null) {
                                    continue;
                                }

                            }
                            while(!yes)
                            {
                            System.out.println("Do you want to Continue?(yes/no) or give 'exit' to Exit");
                            action = sc.nextLine();
                            Main.Continue(action);
                            if (action.equals("no") || action.equals("exit")) {
                                throw new Exception();
                            }
                            else if(action.equals("yes")){
                               break;
                            }

                            }

                        } catch (Exception e) {
                            System.out.println("Add Task Exited!");
                            break;
                        }
                    }

                }
                else if (choice == 2) {
                    String listChoice = " ";
                    boolean exit = false;
                    int i = 0;
                    while(!no||!yes||!exit)
                    {
                        try {
                            System.out.println("Which you want to Display! ");
                            System.out.println("1.List the Task in ToDo");
                            System.out.println("2.List  the Status of Task 'In Progress'!");
                            System.out.println("3.List the Status of Task 'Progress Done'");
                            System.out.println("4.Display All");
                            System.out.println("Enter your Choice which you want to display?or give 'exit' to Exit");
                            listChoice = (sc.nextLine());
                            if (listChoice.equals("exit") || listChoice.equals("no")) {
                                throw new Exception();
                            }
                            if (listChoice.equals("1")) {
                                String action = "";
                                try {
                                    for (i = 0; i < currentUser.getTask().length; i++) {
                                        if (currentUser.getTask()[i].getStatus() == null) {
                                            Main.Display(currentUser);
                                            if (currentUser.getTask()[i] == null) {
                                                System.out.println("There is no Task in List!");
                                                break;
                                            }
                                            else {
                                                break;
                                            }
                                        }
                                        else {
                                            System.out.println("There is no Task in 'To Do");
                                        }


                                    while (!yes) {
                                        System.out.println("Do you want to Continue?(yes/no) or give 'exit' to Exit");
                                        action = sc.nextLine();
                                        if (action.equals("no") || (action.equals("exit"))) {
                                            throw new Exception();
                                        }
                                        else if (action.equals("yes")) {
                                            break;
                                        }
                                        else {
                                            System.out.println("Enter valid String");
                                            continue;
                                        }
                                    }
                                }}
                                catch (Exception e) {
                                    if (currentUser.getTask()[i] != null && currentUser.getTask()[i].getStatus() == null) {
                                        System.out.println("Task Displayed");
                                    }
                                    else if(action.equals("no") || (action.equals("exit"))){
                                        System.out.println("Exited..");
                                        break;
                                    }
                                    else {
                                        System.out.println("There is no Task");
                                    }
                                }

                            }
                            else if (listChoice.equals("2")) {
                                String action = "";
                                try
                                {
                                    for (i = 0; i < currentUser.getTask().length; i++)
                                    {
                                        if (currentUser.getTask()[i].getStatus() != null) {
                                            if (currentUser.getTask()[i].getStatus().equals("On Progress")) {
                                                Main.Display(currentUser);
                                                throw new Exception();
                                            }
                                        }
                                        else {
                                            System.out.println("There is no Task in 'On Progress '");
                                            break;
                                        }
                                    }

                                while(!yes)
                                {
                                    System.out.println("Do you want to Continue?(yes/no) or give 'exit' to Exit");
                                    action = sc.nextLine();
                                    if (action.equals("no") || (action.equals("exit"))) {
                                        throw new Exception();
                                    }
                                    else if (action.equals("yes")) {
                                        break;}
                                    else {
                                        System.out.println("Enter valid String");
                                        continue;
                                    }
                                }
                                }
                                catch (Exception e) {
                                    if (currentUser.getTask()[i] != null && currentUser.getTask()[i].getStatus() == null) {
                                        System.out.println("Task Displayed");
                                    }
                                    else if(action.equals("no") || (action.equals("exit"))){
                                        System.out.println("Exited..");
                                        break;
                                    }
                                    else {
                                        System.out.println("There is no Task");
                                    }
                                }
                            }
                            else if (listChoice.equals("3")) {
                                String action = "";
                                try {
                                    for (i = 0; i < currentUser.getTask().length; i++) {
                                        if (currentUser.getTask()[i].getStatus() != null) {
                                            if (currentUser.getTask()[i].getStatus().equals("Progress Done")) {
                                                String taskDescription = currentUser.getTask()[i].getDescription();
                                                String taskTitle = currentUser.getTask()[i].getTitle();
                                                System.out.print(i + 1);
                                                System.out.print(".");
                                                System.out.println(taskTitle);
                                                System.out.print("Description:");
                                                System.out.println(taskDescription);
                                                System.out.print("Status:");
                                                System.out.println(currentUser.getTask()[i].getStatus());

                                            }
                                        }
                                        else {
                                            System.out.println("There is no Task in 'Progress Done'");
                                           break;
                                        }
                                    }

                                    while(!yes){
                                    System.out.println("Do you want to Continue?(yes/no) or give 'exit' to Exit");
                                    action = sc.nextLine();
                                    if (action.equals("no") || (action.equals("exit"))) {
                                        throw new Exception();
                                    }
                                    else if (action.equals("yes")) {
                                        break;
                                    }
                                    else {
                                        System.out.println("Enter valid String");
                                        continue;
                                    }}
                                } catch (Exception r) {
                                    {
                                        if (currentUser.getTask()[i] == null && currentUser.getTask()[i].getStatus() != null) {
                                            System.out.println("Task Displayed");
                                        }
                                        else if(action.equals("no") || (action.equals("exit"))){
                                            System.out.println("Exited..");
                                            break;
                                        }
                                        else {
                                            System.out.println("There is no Task");
                                        }
                                    }

                                }
                            }
                            else if (listChoice.equals("4")) {
                                String action = "";
                                boolean Description = Main.Description(currentUser);//static method
                                if (!Description) {
                                    System.out.println("No task Available to List!!");
                                }
                                else {
                                    try {
                                        System.out.println("Do you want to Continue?(yes/no) or give 'exit' to Exit");
                                        action = sc.nextLine();
                                        if (action.equals("no") || (action.equals("exit"))) {
                                            throw new Exception();
                                        }
                                        else if (action.equals("yes")) {
                                            break;
                                        }
                                        else {
                                            System.out.println("Enter valid String");
                                            continue;
                                        }
                                    } catch (Exception e){
                                        if (currentUser.getTask()[i] == null && currentUser.getTask()[i].getStatus() != null) {
                                            System.out.println("Task Displayed");
                                        }
                                        else if(action.equals("no") || (action.equals("exit"))){
                                            System.out.println("Exited..");
                                            break;
                                        }
                                        else {
                                            System.out.println("There is no Task");
                                        }
                                    }
                                }
                            }
                            else {
                                System.out.println("Enter the choice Properly!");
                            }

                        } catch (Exception c) {
                            if (listChoice.equals("exit")) {
                                System.out.println("Display List Exited!");
                                break;
                            }
                            else {
                                System.out.println("No task Available To Display!!");
                                break;
                            }
                        }
                    }
                }
                else if (choice == 3) {
                    boolean exit = false;
                    String whatUpdate;
                    String action ;
                    while (!exit) {
                        boolean Description = Main.Description(currentUser);//static method

                        if (!Description) {
                            System.out.println("No Task Updated");
                        }
                        else {
                            try {
                                Integer indexValue = 0;
                                while (indexValue != currentUser.getTask().length) {
                                    try {
                                        System.out.print("Enter the number of Task to update:");
                                        Integer taskNum = Integer.valueOf(sc.nextLine());
                                        indexValue = Main.indexValue(taskNum);
                                        if (indexValue >= 0 && indexValue < currentUser.getTask().length
                                                && currentUser.getTask()[indexValue] != null) {
                                            if (indexValue != indexValue) {
                                                throw new Exception();
                                            }
                                            if (indexValue < currentUser.getTask().length) {
                                                break;
                                            }
                                            else {
                                                System.out.println("Give the valid Task Number!");
                                            }
                                        }
                                        else {
                                            System.out.println("Enter Proper value!");
                                        }
                                    } catch (Exception e) {
                                        System.out.println("No string allowed for task Number!");
                                        continue;
                                    }
                                }
                                System.out.println("What would you like to update?");
                                System.out.println("1.Title");
                                System.out.println("2.Status");
                                System.out.println("3.Description");
                                System.out.println("Enter your choice or give 'exit':");
                                whatUpdate = (sc.nextLine());
                                if (whatUpdate.equals("exit")) {
                                    throw new Exception();
                                }
                                if (whatUpdate.equals("1")) {
                                    //changed into static
                                    if (indexValue < currentUser.getTask().length && currentUser.getTask()[indexValue] != null) {
                                        System.out.println("Enter the Task to Update:");
                                        String updateTask = sc.nextLine();
                                        currentUser.getTask()[indexValue].setTitle(updateTask);
                                        System.out.println("Your Task Updated!");
                                    }
                                    else {

                                        System.out.println("Enter proper number to Update");
                                    }
                                }
                                else if (whatUpdate.equals("2")) {

                                    if (indexValue < currentUser.getTask().length && currentUser.getTask()[indexValue] != null) {
                                        System.out.println("What is your Status now?");
                                        System.out.println("1.To Do");
                                        System.out.println("2.On Progress");
                                        System.out.println("3.Progress Done");
                                        System.out.println("Enter your current Status choice:");
                                        Integer statusChoice = new Integer(sc.nextLine());
                                        if (statusChoice == 1) {
                                            currentUser.getTask()[indexValue].setStatus("To Do");
                                            System.out.println("Your Status Updated!");
                                        }
                                        if (statusChoice == 2) {
                                            currentUser.getTask()[indexValue].setStatus("On Progress");
                                            System.out.println("Your Status Updated!");
                                        }
                                        if (statusChoice == 3) {
                                            currentUser.getTask()[indexValue].setStatus("Progress Done");
                                            System.out.println("Your Status Updated!");
                                        }
                                    }
                                    else {
                                        System.out.println("Enter the Valid Status Choice!");
                                    }

                                }
                                else if (whatUpdate.equals("3")) {
                                    if (indexValue < currentUser.getTask().length && currentUser.getTask()[indexValue] != null) {
                                        System.out.println("Enter your Description:");
                                        String description = sc.nextLine();
                                        currentUser.getTask()[indexValue].setDescription(description);
                                    }
                                }
                                else {
                                    System.out.println("Please Enter Proper choice!");
                                    continue;
                                }while(!yes){
                                System.out.println("Do you want to Continue?(yes/no) or give 'exit' to Exit");
                                action = sc.nextLine();
                                Main.Continue(action);
                                if (action.equals("no") || (action.equals("exit"))) {
                                    throw new Exception();
                                }
                                else if (action.equals("yes")) {
                                    break;
                                }
                                else {
                                    System.out.println("Enter valid String");
                                    continue;
                                }
                                }

                            } catch (Exception e) {
                                System.out.println("It is Exited!");
                                break;
                            }
                        }
                    }
                }

                else if (choice == 4) {
                    boolean Description = Main.Description(currentUser);//static method
                    if (!Description) {
                        System.out.println("No Deleted Task!");
                    }
                    else {
                        boolean exit = false;
                        String delNum;
                        while (!exit) {
                            try {
                                //static method

                                System.out.print("Enter the number of Task to delete or give 'exit' to Exit:");
                                delNum = sc.nextLine();
                                if (delNum.equals("exit")) {
                                    throw new Exception();
                                }
                                Integer indexValue = Main.indexValue(Integer.valueOf(delNum));//static method
                                if (currentUser.getTask() == null) {
                                    System.out.println("You Don't have task to delete! ");
                                }
                                else {
                                    if (indexValue < currentUser.getTask().length && currentUser.getTask()[indexValue] != null) {
                                        currentUser.getTask()[indexValue] = null;
                                        for (int i = 0; i < currentUser.getTask().length; i++) {
                                            if (currentUser.getTask()[i] == null) {
                                                for (int j = i + 1; j < currentUser.getTask().length; j++) {
                                                    if (currentUser.getTask()[j] != null) {//Swap method
                                                        Task temp = currentUser.getTask()[j];
                                                        currentUser.getTask()[j] = currentUser.getTask()[i];
                                                        currentUser.getTask()[i] = temp;
                                                    }
                                                }
                                            }
                                        }
                                        System.out.println("Your Task Deleted!");
                                    }
                                    else {
                                        System.out.println(" Enter proper number to delete!!,if no task in list give exit");
                                    }
                                }while(!yes){
                                System.out.println("Do you want to Continue?(yes/no)or give 'exit");
                                String action = sc.nextLine();
                                if (action.equals("no") || action.equals("exit")) {
                                    throw new Exception();
                                }
                                else if (action.equals("yes")) {
                                    break;
                                }
                                else {
                                    System.out.println("Enter valid String");
                                    continue;
                                }}
                            } catch (Exception e) {
                                System.out.println("Delete Exited!");//static method
                                break;
                            }
                        }
                    }
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

    public static boolean Description(User currentUser) //Static Method
    {
        boolean isTaskListed = false;
        for (int i = 0; i < currentUser.getTask().length; i++) {
            if (currentUser.getTask()[i]!= null) {
                String taskTitle = currentUser.getTask()[i].getTitle();
                String taskStatus=currentUser.getTask()[i].getStatus();
                String taskDescription=currentUser.getTask()[i].getDescription();
                System.out.print(i + 1);
                System.out.print(".");
                System.out.println(taskTitle);
                System.out.print("Status:");
                if(taskStatus==null){
                    System.out.println("To Do");
                }
                else{
                    System.out.println(taskStatus);
                }
                    System.out.print("Description:");
                    System.out.println(taskDescription);
                    isTaskListed = true;
            }
            if (currentUser.getTask()[i] == null) {
                continue;
            }
        }
        return isTaskListed;
    }

    public static Integer indexValue(int index){
        int originalIndex = index- 1;
        return originalIndex;
    }

    public static void Continue(String action)
    {boolean no = false;
        boolean exit=false;
        boolean yes = false;
        while (!no || !exit || !yes) {

            if (action.equals("no") || (action.equals("exit"))) {
                break;
            }
            else if (action.equals("yes")) {
                break;
            }
            else {
                System.out.println("Give a valid String!");
                break;
            }
        }
    }
    public static void Display(User currentUser){
        for (int i = 0; i < currentUser.getTask().length; i++) {
            if (currentUser.getTask()[i] != null) {
                String taskDescription = currentUser.getTask()[i].getDescription();
                String taskTitle = currentUser.getTask()[i].getTitle();
                System.out.print(i + 1);
                System.out.print(".");
                System.out.println(taskTitle);
                System.out.print("Description:");
                System.out.println(taskDescription);
                System.out.print("Status:");
                if (currentUser.getTask()[i].getStatus() == null) {
                    System.out.println("To Do");
                }
                else {
                   System.out.println(currentUser.getTask()[i].getStatus());
                }
            }

        }

    }
 }




