import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        User[] userArray = new User[5];
        Scanner sc = new Scanner(System.in);
        while (true)
        {
            System.out.println("Welcome to Task Manager");
            System.out.println("Enter the username:");
            String username = sc.nextLine();
            //user has 5 ,looping is needed so we use for loop
            boolean isExistingUser = false;
            int currentUserPosition = 0;
            for (int count = 0; count < userArray.length; count++) {
                if (userArray[count] == null) {//loop continue
                    continue;
                }
                if (userArray[count].getUserName().equals(username)) {
                    isExistingUser = true;
                    currentUserPosition = count;
                    break;
                }

            }
            User currentUser;//new user means
            if (!isExistingUser) {
                currentUser = new User(username);
                // userArray[0]=currentUser; stores in only in 0 index do for
                for (int count = 0; count < userArray.length; count++) {
                    if (userArray[count] != null) {
                        continue;
                    }
                    userArray[count] = currentUser;
                    break;
                }
            }
            else {
                currentUser = userArray[currentUserPosition];
            }

            Integer choice = 0;//ref type then direct value(this taken from one Box)
            //AutoBoxing primitive-obj(address change agirchu)(0> obj > unbox it change respective)
            while (choice != 2) {
                System.out.print("Welcome ");
                System.out.println(currentUser.getUserName());
                System.out.println("1.Add Task");
                System.out.println("2.List all my Task");
                System.out.println("3.Update");
                System.out.println("4.Delete");
                System.out.println("5.Exit");
                System.out.println("Enter your Choice :");
                choice = new Integer(sc.nextLine());
                Task userTask;
                if (choice == 1) {
                    System.out.println("Enter your Task Description: ");

                    String taskDescription = (sc.nextLine());
                    userTask = new Task(taskDescription);
                    for (int count = 0; count < currentUser.getTaskArray().length; count++) {
                        if (currentUser.getTaskArray()[count] == null) {
                            currentUser.getTaskArray()[count] = userTask;
                            break;
                        }
                    }
                    System.out.println("Your task added successfully");

                }
                else if (choice == 2)
                {//getting task
                    boolean isThereAnyTask = false;
                    for (int i = 0; i < currentUser.getTaskArray().length; i++)
                    {
                        if (currentUser.getTaskArray()[i] != null)
                        {
                            String taskDescription = currentUser.getTaskArray()[i].getTaskDescription();
                            System.out.println(taskDescription);
                            isThereAnyTask=true;

                        }
                        if (!isThereAnyTask) {
                            System.out.println("There is no task now,so please create new");
                        }
                    }

                }
                else if (choice == 3)
                {
                    boolean isTaskUpdated = false;
                    for (int i = 0; i < currentUser.getTaskArray().length; i++)
                    {
                        if (currentUser.getTaskArray()[0] != null)
                        {

                                System.out.println("Which you need to Update:");
                                Integer update = new Integer(sc.nextLine());
                                int index = update +1;
                                System.out.println("What Update:");
                                Task newUpdate = new Task(sc.nextLine());
                                currentUser.getTaskArray()[index] = newUpdate;
                                System.out.println("Your task updated!");
                                isTaskUpdated=true;
                                continue;

                        }
                            if( !isTaskUpdated)
                            {
                                System.out.println("No task updated");
                            }
                    }


                }
                else if(choice==4){
                    boolean isChoiceDelete=false;
                     for(int count=0;count<currentUser.getTaskArray().length;count++){
                         if (currentUser.getTaskArray()[0] != null){
                             System.out.println("Which task given want to delete:");
                             Integer delete=new Integer(sc.nextLine());
                             int index=delete-1;
                             currentUser.getTaskArray()[index] = null;
                             System.out.println("The task Deleted");
                             isChoiceDelete=true;

                         }
                         if(!isChoiceDelete){
                             System.out.println("There is no Deletion of Task");
                         }
                     }
                }
            }

        }

    }
}

