public class User {
    private String userName;
    private Task[] taskArray=new Task[5];
    User(String username){
        this.userName=username;
    }

    public String getUserName() {
        return userName;
    }

    public Task[] getTaskArray(){
        return this.taskArray;
    }

}
