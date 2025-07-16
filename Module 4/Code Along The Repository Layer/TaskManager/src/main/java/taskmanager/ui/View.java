package taskmanager.ui;

import org.springframework.stereotype.Component;
import taskmanager.models.Status;
import taskmanager.models.Task;

import java.util.List;
import java.util.Scanner;
@Component
public class View {
    Scanner console = new Scanner(System.in);

    //get our menu option
    public int getMenuOption(){
        displayHeader("Welcome to the Main Menu");
        displayText("1. Add a Task");
        displayText("2. View all Tasks");
        displayText("3. Update a Task");
        displayText("4. Delete a Task");
        displayText("5. Exit the program");
        return readInt("What would you like to do? [1-5]", 1, 5);
    }

    //CREATE
    public Task makeTask(){
        Task result = new Task();
        result.setCreatedOn(readString("Enter the date: "));
        result.setTitle(readString("Enter the title: "));
        result.setDescription(readString("Enter the description: "));
        result.setDueDate(readString("Enter the due date: "));
        result.setStatus(readStatus("Enter the status: "));
        return result;
    }

    //READ
    public void displayTasks(List<Task> tasks){
        for(Task task : tasks){
            displayText(String.format("id: %s%nDate: %s%nTitle: %s%nDescription: %s%nDue Date: %s%nStatus: %s%n",
                    task.getId(),
                    task.getCreatedOn(),
                    task.getTitle(),
                    task.getDescription(),
                    task.getDueDate(),
                    task.getStatus().getDisplayText()));
        }
    }

    //UPDATE/DELETE
    public int updateById(){
        displayText("Which id would you like to modify?: ");
        int id = readInt("Enter the id: ", 1, 9999999);
        return id;
    }

    //helper methods
    public void displayHeader(String header){
        System.out.println();
        System.out.println(header);
        System.out.println("*".repeat(header.length()));
    }

    public void displayText(String line){
        System.out.println();
        System.out.print(line);
    }

    public void displayErrors(List<String> errors){
        displayHeader("Errors:");
        for(String error : errors){
            displayText(error);
        }
        displayText("");
    }

    public String readString(String prompt){
        displayText(prompt);
        String string = console.nextLine();
        if(string == null || string.isBlank()){
            displayText("You must enter a value!");
            string = readString(prompt); // re-prompt the user for an input
        }
        return string;
    }

    public int readInt(String prompt, int min, int max){
        while(true){
            String value = readString(prompt);
            try{
                int intValue = Integer.parseInt(value);
                if(intValue < min || intValue > max){
                    System.out.printf("Sorry, that's not a valid choice. Please choose another number between [%s - %s]%n", min, max);
                }else{
                    return intValue;
                }
            }catch (NumberFormatException ex) {
                System.out.printf("%s is not a valid number.%n", value);
            }
        }
    }

    public Status readStatus(String prompt){
        displayHeader("Task Status:");
        for(Status status : Status.values()){
            displayText(status.getDisplayText());
        }
        while(true){
            String selection = readString(prompt);
            // we want to take the user input and make it uppercase so it matches the enum
            selection = selection.toUpperCase();
            try{
                return Status.valueOf(selection);
            }catch (IllegalArgumentException ex){
                System.out.printf("%s is not a status%n", selection);
            }
        }
    }
}
