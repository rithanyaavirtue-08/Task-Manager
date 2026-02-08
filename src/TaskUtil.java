public class TaskUtil {
    public static boolean Description(User currentUser ) //Static Method
    {
        boolean isTaskListed = false;
       {
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
    public static void Common(User currentUser,int i) {
        String taskDescription = currentUser.getTask()[i].getDescription();
        String taskTitle = currentUser.getTask()[i].getTitle();
        System.out.print(".");
        System.out.println(taskTitle);
        System.out.print("Description:");
        System.out.println(taskDescription);
        System.out.print("Status:");
    }
    public static void taskOnly(User currentUser,int i ){
       {if(currentUser.getTask()[i]!=null) {
           String taskTitle = currentUser.getTask()[i].getTitle();
           System.out.print(i + 1);
           System.out.print(".");
           System.out.println(taskTitle);
       }

        }
    }
}
