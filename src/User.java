
import java.util.ArrayList;
import java.util.List;

public class User implements UserInterface {
    private String userName;
    List<Task> Task=new ArrayList<>();
    public String getUserName() {
        return userName;
    }
    User(String username){
        this.userName=username;
    }
    public List<Task> getTask() {
      return Task;
    }
     }
