package todolist;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Operations {
    private List<Task> tasks;

    //crreate a task
    //mark task as complete
    //view all tasks
    //view complete tasks
    //delete tasks
    public Operations(){
        tasks = new ArrayList<>();
    }

    public void createTask(String name, String description, LocalDateTime dateDone){
        //create a task
        Task newTask = new Task(name,description,dateDone);
        tasks.add(newTask);
    }
    public void markComplete(Task task){
        task.setComplete(true);
    }
    public void viewAllTasks(){
        for(Task task: tasks){
            System.out.println(task.displayInfo());
            System.out.println("--------------------------------------------");
            System.out.println();
        }
    }

    public void setComplete(Task task){
        task.setComplete(true);
    }

    public void deleteTask(Task task){
        tasks.remove(task);
    }
}
