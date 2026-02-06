

public class User implements UserInterface {
    private String userName;
    private Task[] task=new Task[10];
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
