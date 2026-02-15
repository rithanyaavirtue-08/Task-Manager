import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserManager implements UserManagerInterface {
   //private User[] existingUser=new User[5];
   private List<User> existingUser=new ArrayList<>();

   // User []existingUser;
    //int size;
    Scanner sc = new Scanner(System.in);
       public UserInterface CheckUser() {
           System.out.println("Welcome to Task Manager");
        System.out.println("Enter Username:");
           String username = sc.nextLine();
           System.out.print("Welcome ");
        System.out.println(username);
        User currentUser=null;
        boolean isExistingUser = false;
        for (int i = 0; i < existingUser.size(); i++) {
            if (existingUser.get(i).getUserName().equals(username)) {
                currentUser=existingUser.get(i);
                isExistingUser = true;
                System.out.println("Happy To See you Again :) :)");
                break;
            }
        }
        if (!isExistingUser) {
            currentUser = new User(username);
            existingUser.add(currentUser);      }
           return currentUser;
}

}
