package todolist;

import java.time.LocalDateTime;

public class Task {
    /*
    structure of each task.,for creating eeach task object.
     */
    private String name;
    private String description;
    private LocalDateTime date;
    boolean isComplete;

    public Task(String name,String description,LocalDateTime date){
        this.name = name;
        this.description = description;
        this.date = date;
        this.isComplete = false;
    }

    public void setName(String name){this.name = name;}
    public String getName(){return name;}

    public void setDescription(String description){this.description = description;}
    public String  getDescription(){return description;}

    public void setDate(LocalDateTime date){this.date = date;}
    public LocalDateTime getDate(){return date;}

    public void setComplete(boolean isComplete){this.isComplete = isComplete;}
    public boolean isComplete(){return isComplete;}

    public String displayInfo(){
        return "Title: "+ getName() + "\nDescription: "+ getDescription() + "\nDate: "+ getDate()
                + "\nStatus: "+ isComplete();
    }
}
