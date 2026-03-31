package todolist;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);
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
        input.next();

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
        System.out.println("Enter choice: ");
        int choice = input.nextInt();
         switch(choice){
             case 1:
                 System.out.println("To be added");
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

    }

}
