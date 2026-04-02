package todolist;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class FileManager {
    private static final String FILE_NAME = "tasks.txt";

    //save tasks
    //load task

    public static void saveTask(List<Task>tasks){
       try(BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))){
           for(Task task:tasks){
               writer.write(task.getName()+ ","+task.getDescription()+","+task.getDate()+","+task.isComplete());
               writer.newLine();
           }
           System.out.println("Task saved successfuly");
       }catch(IOException e){
           System.out.println("Error in saving tasks: "+ e.getMessage());
       }
    }

    public static List<Task>loadTasks(){
        List<Task>tasks = new ArrayList<>();
        File file = new File(FILE_NAME);
        if(!file.exists()){
            return tasks;
        }
        try(BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))){
            String line;
            while((line = reader.readLine())!= null){
                String []parts = line.split(",");
                if(parts.length == 4){

                    LocalDate date  = LocalDate.parse(parts[3]);
                    boolean isComplete = Boolean.parseBoolean(parts[3]);

                    Task task = new Task(parts[0],parts[1],date,isComplete);
                    tasks.add(task);
                }
            }
            System.out.println("Tasks loaded successfully");

        }catch(IOException e){
            System.out.println("Failed to load tasks: ");

        }
        return tasks;
    }
}
