package taskmanager.ui;

import org.springframework.stereotype.Component;
import taskmanager.data.DataAccessException;
import taskmanager.domain.TaskResult;
import taskmanager.domain.TaskService;
import taskmanager.models.Task;

import java.util.List;

// it mediates between the view and the domain layer
// it has 2 dependencies view, service
// you will NEVER use the console inside of your controller
@Component
public class Controller {
    private final View view;
    private final TaskService service;

    public Controller(View view, TaskService service) {
        this.view = view;
        this.service = service;
    }

    //to run our app
    public void run() {
        view.displayHeader("Welcome to the Task Manager");
        try{
            runMenu();
        }catch (DataAccessException ex){
            view.displayText("Something went wrong");
            view.displayText(ex.getMessage());
        }
        view.displayText("Goodbye!");
    }

    // we probably want a run menu method
    private void runMenu() throws DataAccessException {
        boolean exit = false;
        while(!exit){
            int selection = view.getMenuOption();
            switch(selection){
                case 1:
                    addTask();
                    break;
                case 2:
                    viewTasks();
                    break;
                case 3:
                    updateTask();
                    break;
                case 4:
                    deleteTask();
                    break;
                case 5:
                    exit = true;
                    break;
            }
        }
    }

    //Create
    private void addTask() throws DataAccessException {
        Task task = view.makeTask();

        TaskResult result = service.create(task);

        if(result.isSuccess()){
            view.displayText("Your Task was successfully created!");
        }else{
            view.displayErrors(result.getMessages());
        }
    }

    //Read
    private void viewTasks() throws DataAccessException {
        List<Task> tasks = service.findaAll();
        view.displayTasks(tasks);
    }

    //update
    private void updateTask() throws DataAccessException {
        view.displayHeader("Update a Task");
        int id = view.updateById();
        Task task = service.findById(id);
        if(task != null){
            Task updatedTask = view.makeTask();
            updatedTask.setId(task.getId());
            TaskResult result = service.update(updatedTask);
            if(result.isSuccess()){
                view.displayText("Success, your task has been updated!");
            }
        }else{
            view.displayErrors(List.of(String.format("There is no Task with an id %s", id)));
        }
    }

    //delete
    private void deleteTask() throws DataAccessException {
        view.displayHeader("Delete a Task");
        Task task = service.findById(view.updateById());

        if(task != null){
            TaskResult result = service.deleteById(task.getId());
            if(result.isSuccess()){
                view.displayText("Your task was successfully deleted!");
            }
        }else{
            view.displayErrors(List.of("There are no tasks with that id."));
        }
    }
}
