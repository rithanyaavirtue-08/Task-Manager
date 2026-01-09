public class User {
    private String username;
    private Task[] taskArray=new Task[5];

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        username = username;
    }

    public Task[] getTaskArray() {
        return taskArray;
    }

    User(String username){
        this.username=username;
    }
}
