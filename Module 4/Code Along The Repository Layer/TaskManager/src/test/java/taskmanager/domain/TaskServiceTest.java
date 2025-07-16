package taskmanager.domain;

import org.junit.jupiter.api.Test;
import taskmanager.data.DataAccessException;
import taskmanager.data.TaskRepository;
import taskmanager.data.TaskRepositoryDouble;
import taskmanager.models.Status;
import taskmanager.models.Task;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {
    TaskRepository repository = new TaskRepositoryDouble();
    TaskService service = new TaskService(repository);

    //Create Happy Path
    @Test
    public void shouldCreateTask() throws DataAccessException {
        TaskResult actual = service.create(new Task(0, "2023-05-09", "Prepare Snacks", "prepare apple slices and snack for soccer game", "2023-05-11",Status.COMPLETE));

        assertNotNull(actual.getTask());  //verify that payload is set
        assertTrue(actual.isSuccess());

        assertEquals(99,actual.getTask().getId());
    }

    @Test
    public void shouldNotCreateNullTask() throws DataAccessException {
        TaskResult actual = service.create(null);
        assertFalse(actual.isSuccess());
        assertNull(actual.getTask());
        assertEquals("Task cannot be null", actual.getMessages().get(0));
    }

    @Test
    public void shouldNotCreateTaskWithoutStartDate() throws DataAccessException {
        TaskResult actual = service.create(new Task(0, "", "Prepare Snacks", "prepare apple slices and snack for soccer game", "2023-05-11",Status.COMPLETE));
        assertFalse(actual.isSuccess());
        assertNull(actual.getTask());
        assertEquals("Created on date is required", actual.getMessages().get(0));
    }

    @Test
    public void shouldNotCreateTaskWithoutTitle() throws DataAccessException {
        TaskResult actual = service.create(new Task(0, "2023-05-09", "", "prepare apple slices and snack for soccer game", "2023-05-11",Status.COMPLETE));
        assertFalse(actual.isSuccess());
        assertNull(actual.getTask());
        assertEquals("Title must exist and cannot be longer than 50 characters", actual.getMessages().get(0));
    }

    @Test
    public void shouldNotCreateTaskWithTitleLongerThan50Char() throws DataAccessException {
        TaskResult actual = service.create(new Task(0, "2023-05-09", "prepare apple slices and snack for soccer game longer than 50 chars testing testing testing testing testing", "prepare apple slices and snack for soccer game", "2023-05-11",Status.COMPLETE));
        assertFalse(actual.isSuccess());
        assertNull(actual.getTask());
        assertEquals("Title must exist and cannot be longer than 50 characters", actual.getMessages().get(0));
    }

    @Test
    public void shouldNotCreateTaskWithoutDescription() throws DataAccessException {
        TaskResult actual = service.create(new Task(0, "2023-05-09", "prepare apple slices and snack for soccer game", "", "2023-05-11",Status.COMPLETE));
        assertFalse(actual.isSuccess());
        assertNull(actual.getTask());
        assertEquals("Description is required", actual.getMessages().get(0));
    }

    @Test
    public void shouldNotCreateTaskWithDescriptionLessThan20Char() throws DataAccessException {
        TaskResult actual = service.create(new Task(0, "2023-05-09", "prepare apple slices and snack for soccer game", "prepare", "2023-05-11",Status.COMPLETE));
        assertFalse(actual.isSuccess());
        assertNull(actual.getTask());
        assertEquals("Description must be more than 20 characters", actual.getMessages().get(0));
    }
    //SHOULD ALSO BE TESTING FOR DUE DATE AND STATUS

    //READ
    @Test
    public void shouldFindAll() throws DataAccessException {
        List<Task> actual = service.findaAll();

        assertEquals(actual.size(), 3);
        Task task = actual.get(0);

        //(1,"2024-08-01", "Bake Cake", "Bake a cake for Rover's birthday", "2024-08-22", Status.TODO)
        assertEquals(1, task.getId());
        assertEquals("2024-08-01", task.getCreatedOn());
        assertEquals("Bake Cake", task.getTitle());
        assertEquals("Bake a cake for Rover's birthday", task.getDescription());
        assertEquals("2024-08-22", task.getDueDate());
        assertEquals(Status.TODO, task.getStatus());
    }

    @Test
    public void shouldFindExistingId() throws DataAccessException {
        Task task = service.findById(1);
        assertNotNull(task);
        assertEquals(1, task.getId());
        assertEquals("2024-08-01", task.getCreatedOn());
        assertEquals("Bake Cake", task.getTitle());
        assertEquals("Bake a cake for Rover's birthday", task.getDescription());
        assertEquals("2024-08-22", task.getDueDate());
        assertEquals(Status.TODO, task.getStatus());
    }

    @Test
    public void shouldNotFindNonExistingId() throws DataAccessException {
        Task actual = service.findById(999);
        assertNull(actual);
    }
    //UPDATE
    @Test
    public void shouldUpdateExistingTask() throws DataAccessException {
        List<Task> all = service.findaAll();
        Task toUpdate = all.get(0);
        toUpdate.setDescription("This is an updated task description, testing testing testing");

        TaskResult actual = service.update(toUpdate);
        assertTrue(actual.isSuccess());
        assertEquals(0, actual.getMessages().size()); //no error messages
        assertEquals("This is an updated task description, testing testing testing", all.get(0).getDescription());
    }

    public void shouldNotUpdateNonExistingTask() throws DataAccessException {
        Task  task = new Task(0, "2024-08-01", "Fake", "this is a fake description with at least 20 chars", "2024-08-22", Status.TODO);
        TaskResult actual = service.update(task);

        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertTrue(actual.getMessages().get(0).contains("does not exist"));
    }

    @Test
    public void shouldNotUpdateNullTask() throws DataAccessException {
        TaskResult actual = service.update(null);
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertEquals("Task cannot be null", actual.getMessages().get(0));
    }

    //DELETE
    @Test
    public void shouldDeleteExistingTask() throws DataAccessException {
        TaskResult actual = service.deleteById(1);
        assertTrue(actual.isSuccess());
    }

    @Test
    public void shouldNotDeleteNonExistingTask() throws DataAccessException {
        TaskResult actual = service.deleteById(999);
        assertFalse(actual.isSuccess());
        assertEquals(1, actual.getMessages().size());
        assertTrue(actual.getMessages().get(0).contains("does not exist"));
    }
}