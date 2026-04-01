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
    private static List<Task>tasks = op.viewAllTasks();
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

                default:
                    System.out.println("Please enter a valid input. ");
            }

        }
    }

    public static void addTaskMenu(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
        System.out.println("=========================");
        System.out.println("   ADD TASK");
        System.out.println("=========================");

        System.out.print("Name: ");
        String name = input.nextLine();
        input.nextLine();
        System.out.print("Description: ");
        String description = input.nextLine();
        System.out.print("Date(use this format dd/month/year): ");
        String date = input.nextLine();

        System.out.println("Press enter to add user");
        op.createTask(name,description,convertToDate(date));
        System.out.println("Task added successfully!! ");


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
                 for(Task task :tasks){
                     System.out.println(task.displayInfo());
                 }
                 break;
             case 2:
                 System.out.println("Not yet implemented");
                 break;
             case 3:
                 System.out.println("Not yet implemented");
                 break;
             case 4:
                 displayMenu();
                 break;
             default:
                 System.out.println("Invalid choice.");

         }
    }

    public static void markTaskComplete(){
        //List all tasks
        //ask user to choose task
        //check if task is already complete and sedn error message if complete
        //if not complete set it to complete and return success

        List<Task>taskList = op.viewAllTasks();
        for(int i = 0;i < taskList.size();i++) {

            Task task = taskList.get(i);
            String taskView = (i + 1) +"." + task.getName() + " | "+task.getDescription()+" | "+ task.getDate();
            System.out.println(taskView);
        }
        




    }

}
