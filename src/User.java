import java.util.Scanner;

public class User {
    private String userName;
    //private Tasks[] tasks1 =new Tasks[10];
    private Task[] task=new Task[10];
    Scanner sc = new Scanner(System.in);


    public String getUserName() {
        return userName;
    }


    User(String username){
        this.userName=username;
    }


    public Task[] getTask() {
        return task;
    }
    }
