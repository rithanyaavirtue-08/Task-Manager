import java.util.Scanner;

public class UserManager implements UserManagerInterface {
    private User[] existingUser=new User[5];
    Scanner sc = new Scanner(System.in);
       public UserInterface CheckUser() {
           System.out.println("Welcome to Task Manager");
        System.out.println("Enter Username:");
        String username = sc.nextLine();
        System.out.print("Welcome ");
        System.out.println(username);
        User currentUser=null;
        boolean isExistingUser = false;
        for (int i = 0; i < existingUser.length; i++) {
            if (existingUser[i] == null) {
                continue;
            }
            if (existingUser[i].getUserName().equals(username)) {
                currentUser=existingUser[i];
                isExistingUser = true;
                System.out.println("Happy To See you Again :) :)");
                break;
            }
        }
        if (!isExistingUser) {
            currentUser = new User(username);
            for (int i = 0; i < existingUser.length; i++) {
                if (existingUser[i] == null) {
                    existingUser[i]= currentUser;
                    break;
                }
            }


        }
           return currentUser;
}
}
