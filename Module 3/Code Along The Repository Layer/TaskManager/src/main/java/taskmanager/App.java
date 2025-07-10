package taskmanager;

import taskmanager.data.DataAccessException;
import taskmanager.data.TaskFileRepository;
import taskmanager.domain.TaskService;
import taskmanager.models.Task;
import taskmanager.ui.Controller;
import taskmanager.ui.View;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class App {
    //We dont want main method to throw exception
    public static void main(String[] args){
        TaskFileRepository repository = new TaskFileRepository("./data/tasks.csv");
        TaskService service = new TaskService(repository);
        View view = new View();
        Controller controller = new Controller(view, service);
        controller.run();
    }
}
