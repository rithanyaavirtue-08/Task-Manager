
import java.util.Scanner;

public class TaskManager implements TaskManagerInterface
{
    Scanner sc=new Scanner(System.in);
    private User currentUser;
    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }
    boolean exit = false;
    String addedTask;
    String action;
    boolean yes=false;
    boolean no=false;
    Task task;
    public void addTask()
    {
        //static method
        boolean Description=TaskUtil.Description(currentUser);

        if (!Description) {
            System.out.println("No Task Added!");
        }
        else {
            System.out.println("Previous Task Displayed!");
        }

        while (!exit)
        {
            try {
                System.out.println("Enter your Title or  give 'exit' to Exit:");
                addedTask = sc.nextLine();
                if (addedTask.equals("exit")) {
                    throw new Exception();
                }

                    Task task = new Task(addedTask, "To Do");
                    currentUser.getTask().add(task);
                    System.out.println("Your Task Added Successfully :) :) ");
                while(!no)
                {
                    System.out.println("Do you want to Add Description?(yes/no)");
                    String desc = sc.nextLine();
                    if (desc.equals("yes")) {
                        System.out.println("Enter your Description:");
                        String taskDes = sc.nextLine();
                        task.setDescription(taskDes);
                        break;
                    }
                    else if(desc.equals("no")){
                    break;
                }
                else{
                        System.out.println("Enter proper value");
                    }

                }
                    while(!yes)
                    {
                    System.out.println("Do you want to Continue?(yes/no) or give 'exit' to Exit");
                    action = sc.nextLine();
                    TaskUtil.Continue(action);
                    if (action.equals("no") || action.equals("exit")) {
                        throw new Exception();
                    }
                    else if (action.equals("yes")) {
                        break;
                    }
                    else{
                        System.out.println("Enter proper value");
                    }
                }
            } catch (Exception e) {
                System.out.println("Add Task Exited!");
                break;
            }
        }
    }
    public  void listChoice(){
        String listChoice = " ";
        boolean exit = false;
        int i = 0;
        while(!no||!yes||!exit) {
            try {
                System.out.println("Which you want to Display! ");
                System.out.println("1.List the Task in ToDo");
                System.out.println("2.List  the Status of Task 'On Progress'!");
                System.out.println("3.List the Status of Task 'Progress Done'");
                System.out.println("4.Display All");
                System.out.println("Enter your Choice which you want to display?or give 'exit' to Exit");
                listChoice = (sc.nextLine());
                if (listChoice.equals("exit") || listChoice.equals("no")) {
                    throw new Exception();
                }
                if (listChoice.equals("1")) {
                    String action = "";
                    boolean isToDo = false;
                    try {
                        int displayCount=1;
                        for (i = 0; i < currentUser.getTask().size(); i++) {
                            if( currentUser.getTask().get(i).getStatus().equals("ToDO")) {
                                System.out.print(displayCount);
                                    TaskUtil.Common(currentUser, i);
                                    System.out.println("To DO");
                                    isToDo = true;
                                    displayCount++;
                                        }
                                else {
                                    continue;
                                }
                            }


                        if (!isToDo) {
                            System.out.println("There is no Task!");
                        }
                        while (!yes) {
                            System.out.println("Do you want to Continue?(yes/no) or give 'exit' to Exit");
                            action = sc.nextLine();
                            if (action.equals("no") || (action.equals("exit"))) {
                                throw new Exception();
                            }
                            else if (action.equals("yes")) {
                                throw new Exception();
                            }
                            else {
                                System.out.println("Enter valid String");
                            }

                        }
                    } catch (Exception e) {

                        if (action.equals("yes")) {
                            continue;
                        }
                        else if (action.equals("no") || action.equals("exit")) {
                            break;
                        }
                    }
                }
                else if (listChoice.equals("2")) {
                    String action = "";
                    boolean isOnProgress = false;
                    int displayCount=1;
                    try {
                        for (i = 0; i < currentUser.getTask().size(); i++) {
                                if (currentUser.getTask().get(i).getStatus().equals("On Progress")) {
                                    System.out.print(displayCount);
                                    TaskUtil.Common(currentUser, i);
                                    System.out.println(currentUser.getTask().get(i).getStatus());
                                    isOnProgress = true;
                                    displayCount++;

                                }
                                else if (currentUser.getTask().get(i) == null) {
                                    break;
                                }

                            }


                        if (!isOnProgress) {
                            System.out.println("There is no Task in 'On Progress'");
                        }
                        while (!yes) {
                            System.out.println("Do you want to Continue?(yes/no) or give 'exit' to Exit");
                            action = sc.nextLine();
                            //Main.Continue(action);
                            if (action.equals("no") || (action.equals("exit"))) {
                                throw new Exception();
                            }
                            else if (action.equals("yes")) {
                                throw new Exception();
                            }
                            else {
                                System.out.println("Enter valid String");
                            }
                        }
                    } catch (Exception e) {

                        if (action.equals("yes")) {
                            continue;
                        }
                        else if (action.equals("no") || action.equals("exit")) {
                            break;
                        }
                        else {
                            System.out.println("There is no Task");
                        }
                    }
                }

                else if (listChoice.equals("3")) {
                    String action = "";
                    int displayCount=1;
                    boolean isProgressDone = false;
                    try {
                        for (i = 0; i < currentUser.getTask().size(); i++) {
                                if (currentUser.getTask().get(i).getStatus().equals("Progress Done")) {
                                    System.out.print(displayCount+".");
                                    TaskUtil.Common(currentUser, i);
                                    System.out.println(currentUser.getTask().get(i).getStatus());
                                    isProgressDone = true;
                                    displayCount++;
                                }
                                else {
                                    continue;
                                }
                            }

                        if (!isProgressDone) {
                            System.out.println("There is no Task in 'Progress Done' ");
                        }
                        while (!yes) {
                            System.out.println("Do you want to Continue?(yes/no) or give 'exit' to Exit");
                            action = sc.nextLine();
                            if (action.equals("no") || (action.equals("exit"))) {
                                throw new Exception();
                            }
                            else if (action.equals("yes")) {
                                throw new Exception();
                            }
                            else {
                                System.out.println("Enter valid String");

                            }
                        }
                    } catch (Exception r) {
                        if (action.equals("yes")) {
                            continue;
                        }
                        else if (action.equals("no") || action.equals("exit")) {
                            break;
                        }
                        else {
                            System.out.println("There is no Task");
                        }
                    }

                }
                else if (listChoice.equals("4")) {
                    String action = "";
                    try {
                        boolean Description = TaskUtil.Description(currentUser);//static method
                        if (!Description) {
                            System.out.println("No task Available to List!!");

                        }
                        while (!yes) {
                            System.out.println("Do you want to Continue?(yes/no) or give 'exit' to Exit");
                            action = sc.nextLine();
                            if (action.equals("no") || (action.equals("exit"))) {
                                throw new Exception();
                            }
                            else if (action.equals("yes")) {
                                throw new Exception();
                            }
                            else {
                                System.out.println("Enter valid String");
                                continue;
                            }
                        }
                    } catch (Exception e) {
                        if (action.equals("yes")) {
                            continue;
                        }
                        else if (action.equals("no") || action.equals("exit")) {
                            break;
                        }
                        else {
                            System.out.println("There is no Task");
                        }
                    }

                }
                else{
                    System.out.println("Enter the valid Choice!");
                }
            }
            catch (Exception c) {
                if (listChoice.equals("exit")) {
                    System.out.println("Display List Exited!");
                    break;
                }
                else  {
                    System.out.println("No task Available To Display!!");
                    break;
                }
            }

        }

    }
    public void Update() {

        boolean exit = false;
        String whatUpdate;
        String action;
        boolean taskOnly=false;
        while (!exit) {
            // boolean Description= TaskUtil.Description(currentUser);//static method
            for(int i=0;i<currentUser.getTask().size();i++) {
                TaskUtil.taskOnly(currentUser, i);
                taskOnly=true;
            }
            if (!taskOnly) {
                System.out.println("No Task to Update");
                break;
            }
            try {
                    Integer indexValue = 0;
                    //while (indexValue != currentUser.getTask().size()) {

                            try {
                                if (currentUser.getTask().get(indexValue) == null) {
                                    System.out.println("There is No task in Update!");
                                    break;
                                }
                                else {
                                    while (true) {
                                        System.out.println("Enter the number of Task to update:");
                                        Integer taskNum = Integer.valueOf(sc.nextLine());
                                        indexValue = TaskUtil.indexValue(taskNum);
                                        // if (indexValue != taskNum) {
                                        //   throw new Exception();
                                        //}

                                        String status = currentUser.getTask().get(indexValue).getStatus();
                                        String des = currentUser.getTask().get(indexValue).getDescription();
                                        if (status == null) {
                                            System.out.println("Status:" + "TO Do");
                                        }
                                        else {
                                            System.out.println("Status:" + status);
                                        }
                                        System.out.println("Description:" + des);
                                        if (indexValue >= 0 && indexValue < currentUser.getTask().size()) {
                                            if (indexValue != indexValue) {
                                                throw new Exception();
                                            }
                                            if (indexValue < currentUser.getTask().size()) {
                                                break;
                                            }
                                            else {
                                                System.out.println("Give the valid Task Number!");

                                            }
                                        }
                                        else {
                                            System.out.println("Enter Proper value!");

                                        }
                                    }
                                }

                            }catch(Exception e) {
                                System.out.println("Enter a proper value in list");
                                continue;

                    }

                    if(currentUser.getTask().get(indexValue)!=null) {
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
                            if (indexValue < currentUser.getTask().size() && currentUser.getTask().get(indexValue)!= null) {
                                System.out.println("Enter the Task to Update:");
                                String updateTask = sc.nextLine();
                                currentUser.getTask().get(indexValue).setTitle(updateTask);
                                System.out.println("Your Task Updated!");
                            }
                            else {

                                System.out.println("Enter proper number to Update ");
                            }
                        }
                        else if (whatUpdate.equals("2")) {

                            if (indexValue < currentUser.getTask().size() && currentUser.getTask().get(indexValue) != null) {
                                System.out.println("What is your Status now?");
                                System.out.println("1.To Do");
                                System.out.println("2.On Progress");
                                System.out.println("3.Progress Done");
                                System.out.println("Enter your current Status choice:");
                                Integer statusChoice = new Integer(sc.nextLine());
                                if (statusChoice == 1) {
                                    currentUser.getTask().get(indexValue).setStatus(null);
                                    System.out.println("Your Status Updated!");

                                }
                                if (statusChoice == 2) {
                                    currentUser.getTask().get(indexValue).setStatus("On Progress");
                                    System.out.println("Your Status Updated!");


                                }
                                if (statusChoice == 3) {
                                    currentUser.getTask().get(indexValue).setStatus("Progress Done");
                                    System.out.println("Your Status Updated!");
                                }
                            }
                            else {
                                System.out.println("Enter the Valid Status Choice!");
                            }
                        }

                        else if (whatUpdate.equals("3")) {
                            if (indexValue < currentUser.getTask().size()&& currentUser.getTask().get(indexValue) != null) {
                                System.out.println("Enter your Description:");
                                String description = sc.nextLine();
                                currentUser.getTask().get(indexValue).setDescription(description);
                            }

                            else {
                                System.out.println("Please Enter Proper choice!");
                                continue;
                            }

                        }
                        else {
                            System.out.println("Enter the valid choice!");
                            continue;
                        }
                        while (!yes) {
                            System.out.println("Do you want to Continue?(yes/no) or give 'exit' to Exit");
                            action = sc.nextLine();
                            TaskUtil.Continue(action);
                            if (action.equals("no") || (action.equals("exit"))) {
                                throw new Exception();
                            }
                            else if (action.equals("yes")) {
                                break;
                            }
                            else {
                                System.out.println("Enter valid String");

                            }
                        }
                    }
                    else{
                        break;
                    }
                }
                catch (Exception e) {
                    System.out.println("It is Exited!");
                    break;
                }

        }
    }
    public void Delete() {
        // boolean Description= TaskUtil.Description(currentUser);
        //static method
        boolean taskOnly=false;
        for(int i=0;i<currentUser.getTask().size();i++){
            TaskUtil.taskOnly(currentUser,i);
            taskOnly=true;}
        if (!taskOnly) {
            System.out.println("No task to Delete!");

        }
        else {
            boolean exit = false;
            String delNum;

            while (!exit) {
                try {
                    // if(currentUser.getTask().get(indexValue)==null){
                    //   System.out.println("There is No task in Delete!");
                    // break;
                    //}

                        System.out.println("Enter the number of Task to delete or give 'exit' to Exit:");
                        delNum = sc.nextLine();
                        // int delnum = Integer.parseInt(sc.nextLine());
                        if (delNum.equals("exit")) {
                            throw new Exception();
                        }
                        //static method

                        try {
                            int index=((Integer.valueOf(delNum)));
                           // Integer dulNum = new Integer(delNum);
                            int indexValue = TaskUtil.indexValue(index);//static method
                            if ( indexValue < currentUser.getTask().size()) {
                                currentUser.getTask().remove(indexValue);
                                System.out.println("Your Task Deleted!");
                            }
                            else {
                                throw new Exception();
                            }
                            // if (currentUser.getTask() == null) {
                            //   System.out.println("You Don't have task to delete! ");
                            //}
                            //  else {
                            // if (indexValue < currentUser.getTask().size()&& currentUser.getTask().get(indexValue) != null) {
                            //   currentUser.getTask().get(indexValue) = null;
                            // for ( i = 0; i < currentUser.getTask().size(); i++) {
                            //   if (currentUser.getTask().get(i) == null) {
                            //     for (int j = i + 1; j < currentUser.getTask().size(); j++) {
                            //       if (currentUser.getTask()[j] != null) {//Swap method
                            //         Task temp = currentUser.getTask()[j];
                            //       currentUser.getTask()[j] = currentUser.getTask()[i];
                            //     currentUser.getTask()[i] = temp;
                            //}
                            // }
                            // }
                            //}

                            // }
                            // else {

                            // System.out.println(" Enter proper number to delete!!,if no task in list give exit");
                            //
                            //}}}
                        } catch (Exception e) {
                            System.out.println("Enter a valid task Number!");
                            continue;
                        }
                        while (!yes) {
                            System.out.println("Do you want to Continue?(yes/no)or give 'exit");
                            action = sc.nextLine();
                            if (action.equals("no") || action.equals("exit")) {
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
                        System.out.println("Delete Exited!");//static method
                        break;
                    }
                }
            }
        }
    }


