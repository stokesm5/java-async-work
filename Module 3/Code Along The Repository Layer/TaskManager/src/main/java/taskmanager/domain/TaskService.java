package taskmanager.domain;

import taskmanager.data.DataAccessException;
import taskmanager.data.TaskRepository;
import taskmanager.models.Task;

import java.util.List;

public class TaskService {
    private final TaskRepository repository;

    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    //Read
    public List<Task> findaAll() throws DataAccessException{
        return repository.findAll();
    }

    public Task findById(int taskId) throws DataAccessException {
        return repository.findById(taskId);
    }

    //CREATE
    public TaskResult create(Task task) throws DataAccessException {
        TaskResult result = validate(task); //enforce our business rules
        if(!result.isSuccess()){
            return result;
        }

        if(task == null){
            result.addMessage("Task cannot be null");
            return result;
        }

        //check id
        if(task.getId() > 0){
            result.addMessage("Cannot create existing task");
            return result;
        }

        task = repository.create(task);
        //ser the payload
        result.setTask(task);
        return result;
    }

    //UPDATE
    public TaskResult update(Task task) throws DataAccessException {
        TaskResult result = validate(task);
        if(!result.isSuccess()){
            return result;
        }
        boolean updated = repository.update(task); //we are trying to update - if this fails its because the id we are trying to update doesn't exist

        if(!updated){
            result.addMessage(String.format("Task with id: %s does not exist", task.getId()));
        }
        return result;
    }

    //DELETE
    public TaskResult deleteById(int taskId) throws DataAccessException {
        TaskResult result = new TaskResult();
        if(!repository.delete(taskId)){
            result.addMessage(String.format("Task with id: %s does not exist", taskId));
        }
        return result;
    }


    //helper method
    /*
    we cannot add a task with id > 0
    we need to check that createdOn exists
    we need to check that a title exists and it cannot be greater than 50 char
    ween need to make sure there is a description and the description cannot be less than 20 chars
    wee need to make sure there is a due date
    whe need to ensure the task has a status
    if anything fails we need to let the user know
    */
    public TaskResult validate(Task task){
        TaskResult result = new TaskResult();
        if(task == null){
            result.addMessage("Task cannot be null");
            return result;
        }
        if(task.getCreatedOn() == null || task.getCreatedOn().isBlank()){
            result.addMessage("Created on date is required");
            return result;
        }
        if(task.getTitle() == null || task.getTitle().isBlank() || task.getTitle().length() > 50){
            result.addMessage("Title must exist and cannot be longer than 50 characters");
            return result;
        }if(task.getDescription() == null || task.getDescription().isBlank()){
            result.addMessage("Description is required");
        }
        if(task.getDescription().length() < 20){
            result.addMessage("Description must be more than 20 characters");
            return result;
        }
        if(task.getDueDate() == null || task.getDueDate().isBlank()){
            result.addMessage("Due date is required.");
            return result;
        }
        if(task.getStatus() == null){
            result.addMessage("Status is required");
            return result;
        }
        return result;
    }
}
