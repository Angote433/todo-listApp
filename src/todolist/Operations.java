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
    public void viewAllTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks to display");
        }
        for(Task task : tasks){
            System.out.println(task.getName() + "||"+task.getDescription()+"||"+task.getDate() + "||"+ task.isComplete());
        }
    }

    public void viewCompleteTasks(){
        if(tasks.isEmpty()){
            System.out.println("No tasks present");
        }
        List<Task>completeTasks = new ArrayList<>();
        //search for the task where status = true
        for(Task task : tasks){
            if(task.isComplete()){
                completeTasks.add(task);
            }
        }
        //display
        if(completeTasks.isEmpty()){
            System.out.println("No completed tasks");
        }
        for(Task task:completeTasks){
            System.out.println(task.getName() + "||"+task.getDescription()+"||"+task.getDate() + "||"+ task.isComplete());
        }
    }

    public List<Task> viewIncompleteTasks(){
        if(tasks.isEmpty()){
            return null;
        }
        List<Task>incompleteTasks = new ArrayList<>();

        for(Task task:tasks){
            if(!task.isComplete()){
               incompleteTasks.add(task);
            }
        }

        return incompleteTasks;
    }

    //load all tasks


    public void setComplete(Task task){
        task.setComplete(true);
    }

    public void deleteTask(Task task){
        tasks.remove(task);
    }
}
