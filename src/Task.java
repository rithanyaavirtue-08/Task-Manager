//import java.util.Scanner;

public class Task {
    private String title;
    private String Status;
    private String description;


    public Task(String Status,String Description,String title){
this.title=title;
this.Status=Status;
this.description=Description;
    }
    public String getStatus() {
        return Status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String task) {
        this.title = task;
    }

    Task(String title){
        this.title=title;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }



}
