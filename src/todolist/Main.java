package todolist;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
    private static Operations op = new Operations();
    static void main() {
        displayMenu();
    }

    public static void displayMenu() {

        boolean state = true;

        while (state) {

            System.out.println("========================================");
            System.out.println("    WELCOME TO TODO LIST APP");
            System.out.println("========================================");

            System.out.println("1.Add task");
            System.out.println("2.View  tasks");
            System.out.println("3.Mark task complete ");
            System.out.println("4.Exit");
            System.out.print("Please select an option: ");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    addTaskMenu();
                    break;
                case 2:
                    viewTaskMenu();
                    break;
                case 3:
                   markTaskComplete();
                    break;
                case 4:
                    System.out.println("Thank you for visiting us,,Goodbye");
                    state = false;
                    break;

                default:
                    System.out.println("Please enter a valid input. ");
            }

        }
    }

    public static void addTaskMenu(){
        System.out.println("=========================");
        System.out.println("   ADD TASK");
        System.out.println("=========================");

        System.out.print("Name: ");
        String name = input.nextLine();
        System.out.print("Description: ");
        String description = input.nextLine();
        input.nextLine();
        System.out.print("Date(use this format dd/month/year): ");
        String date = input.next();

        System.out.println("Press enter to add task");
        op.createTask(name,description,convertToDate(date));

    }
    public static LocalDate convertToDate(String dateInput){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try{
            return LocalDate.parse(dateInput,dtf);

        }catch (DateTimeParseException e){
            System.err.println("Error parsing date "+ e.getMessage());
            return null;
        }
    }

    public static void viewTaskMenu(){
        System.out.println("1.View all tasks");
        System.out.println("2.Complete tasks only");
        System.out.println("3.Incomplete tasks only");
        System.out.println("4.Back to main menu.");
        System.out.print("Enter choice: ");
        int choice = input.nextInt();
         switch(choice){
             case 1:
                 op.viewAllTasks();
                 break;
             case 2:
                 op.viewCompleteTasks();
                 break;
             case 3:
                 List<Task>incompleteTasks = op.viewIncompleteTasks();
                 if(incompleteTasks.isEmpty()){
                     System.out.println("No incomplete tasks");
                 }
                 for(Task task : incompleteTasks){
                     System.out.println(task.getName() + "||"+task.getDescription()+"||"+task.getDate() + "||"+ task.isComplete());
                 }
                 break;
             case 4:
                 displayMenu();
                 break;
             default:
                 System.out.println("Invalid choice.");

         }
    }

    public static void markTaskComplete(){
        //List all incomplete tasks
        //choose a task to be marked complete
        //ask y or n to mark complete,,
        //if y,task get updated
        //if n task remains incomplete

        int taskmapper = 0;
        List<Task>incompleteTasks = op.viewIncompleteTasks();
        System.out.println("=======================");
        System.out.println("   INCOMPLETE TASKS    ");
        System.out.println("=======================");
        for(int i = 0;i < incompleteTasks.size();i++){
            taskmapper = i + 1;
            System.out.println( taskmapper + ". " +incompleteTasks.get(i).getName() + " || "
                    + incompleteTasks.get(i).isComplete());
        }
        System.out.println("========================");
        System.out.println();

        System.out.print("Select a task using visible values(1,2,3 etc: ");
        int choice = input.nextInt();

        if(choice > taskmapper){
            System.out.println("Enter a valid choice");
        }

        Task chosenTask = incompleteTasks.get(choice);
        //set to complete
        op.markComplete(chosenTask);


    }


        




    }


