package taskmanager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import taskmanager.data.DataAccessException;
import taskmanager.data.TaskFileRepository;
import taskmanager.domain.TaskService;
import taskmanager.models.Task;
import taskmanager.ui.Controller;
import taskmanager.ui.View;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@ComponentScan
@PropertySource("classpath:data.properties") //telling the app where to look
public class App {
    //We dont want main method to throw exception
    public static void main(String[] args){
        configureWithAnnotationAndRun();
    }

    /*ANNOTATION DEPENDENCY INJECTION*/
    private static void configureWithAnnotationAndRun(){
        ApplicationContext container = new AnnotationConfigApplicationContext(App.class);
        //Stays the same as XML
        Controller controller = container.getBean(Controller.class);
        controller.run();
    }

    /*XML DEPENDENCY INJECTION*/
    private static void configureWithXMLAndRun(){
        ApplicationContext container = new ClassPathXmlApplicationContext("dependency-config.xml");
        Controller controller = container.getBean(Controller.class);
        controller.run();
    }


    /*MANUAL DEPENDENCY INJECTION*/
    private static void configureManuallyAndRun(){
        TaskFileRepository repository = new TaskFileRepository("./data/tasks.csv");
        TaskService service = new TaskService(repository);
        View view = new View();
        Controller controller = new Controller(view, service);
        controller.run();
    }
}
