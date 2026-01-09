import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        User[] userArray=new User[5];
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("Welcome To Task Management");
            System.out.println("Enter your Username;");
            String username = new String(sc.nextLine());

           boolean isExistingUser=false;
           int isCurrentPosition=0;
           for(int count=0;count<userArray.length;count++)
           {
           if(userArray[count] == null)
           {
               continue;
           }
               if(userArray[count].getUsername().equals(username))
               {
                   isExistingUser = true;
                   isCurrentPosition = count;
                   break;
               }
           }

           User currentUser;
           if(!isExistingUser){
               currentUser=new User(username);
               for(int count=0;count<userArray.length;count++){
                  if(userArray[count]!=null)
                  {
                      continue;
                  }

                  userArray[count]=currentUser;
                  break;


              }
           }
           else{
               currentUser=userArray[isCurrentPosition];
           }
           Integer choice = 0;//this is called autoboxing
            while (choice != 4) //this is unboxing
            {
                System.out.print("Welcome ");
                System.out.println(currentUser.getUsername());
                System.out.println("1.Add task");
                System.out.println("2 List the tasks");
                System.out.println("3.Update");
                System.out.println("5 Exit");
                System.out.println("Enter your choice:");
                choice = new Integer(sc.nextLine());

                Task userTask;
                if (choice == 1)
                {
                    System.out.println("Enter your Task Description:");
                    String taskDescription = new String(sc.nextLine());
                     userTask = new Task(taskDescription);
                    for(int count = 0; count<currentUser.getTaskArray().length; count++)
                    {
                        if(currentUser.getTaskArray()[count]==null){
                        currentUser.getTaskArray()[count]=userTask;
                        System.out.println("Task Added successfully :) :) ");
                        break;
                        }

                    }
                }
                else if(choice==2){
                    boolean isTaskAvailable=false;
                    for(int count=0;count<currentUser.getTaskArray().length;count++)
                    {
                        if(currentUser.getTaskArray()[count]!=null){
                          String taskDescription=currentUser.getTaskArray()[count].getTaskDescription();
                          System.out.println(taskDescription);
                          isTaskAvailable=true;

                        }
                    }
                    if(!isTaskAvailable){
                        System.out.println("No task Available");
                    }
                }

                else if (choice == 3) {
                    boolean istaskUpdated=false;
                    System.out.println("Enter the task number to update:");
                    Integer updatenum=new Integer(sc.nextLine());
                    for(int count=0;count<currentUser.getTaskArray().length;count++){
                        if(currentUser.getTaskArray()!=null){
                            int replacement=updatenum-1;
                            System.out.println("Your updated Task Description");
                            System.out.println("What task you want to replace?");
                            Task update=new Task(sc.nextLine());//task is also formed as string because of array creation
                            currentUser.getTaskArray()[replacement]=update;
                            String taskDescription=currentUser.getTaskArray()[count].getTaskDescription();
                            System.out.println("Your updated Task Description");
                            System.out.println(taskDescription);
                            System.out.println("Your task is updated!!");
                            istaskUpdated=true;
                        }

                    }
                    if(!istaskUpdated){
                        System.out.println("No task updated now");
                    }
                }
                else if(choice==4){
                    boolean isTaskDeleted=false;
                    System.out.println("Enter the task number to delete:");
                    Integer delnum=new Integer(sc.nextLine());
                    int deletion=delnum-1;
                    for(int i=0;i<currentUser.getTaskArray().length;i++){
                        if(currentUser.getTaskArray()[i]==null){
                                   continue;
                        }
                        if (currentUser.getTaskArray()[i].equals(deletion)) {
                            Task delete=null;
                            currentUser.getTaskArray()[i]=delete;
                            String taskDescription=currentUser.getTaskArray()[i].getTaskDescription();
                            System.out.println(taskDescription);
                            System.out.println("Your Task Deleted!");
                            isTaskDeleted=true;

                        }
                    }
                    if(!isTaskDeleted){
                        System.out.println("No task Deleted");
                    }

                }

                else {
                    System.out.println("Thank for Using us!");
                }

            }

        }
    }
}
