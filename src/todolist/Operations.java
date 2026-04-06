package todolist;

import java.time.LocalDate;
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
    public Operations(){tasks = FileManager.loadTasks(); }

    public void createTask(String name, String description, LocalDate dateDone){
        //create a task
        Task newTask = new Task(name,description,dateDone);
        tasks.add(newTask);
        FileManager.saveTask(tasks);
    }
    public void markComplete(Task task){
        task.setComplete(true);
    }
    public List<Task>viewAllTasks(){
        if(tasks.isEmpty()){
            return null;
        }
        return tasks;
    }

    //load all tasks


    public void setComplete(Task task){
        task.setComplete(true);
    }

    public void deleteTask(Task task){
        tasks.remove(task);
    }
}
