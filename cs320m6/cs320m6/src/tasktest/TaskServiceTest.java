/**
 * 
 */
package tasktest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import task.Task;
import task.TaskService;

/**
 * 
 */
class TaskServiceTest {

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeEach
	void setUp() throws Exception {
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterEach
	void tearDown() {
		TaskService.taskList.clear(); // clear task list
		assertTrue(TaskService.taskList.isEmpty());
	}

	@Test
	void testAddTask() {
		TaskService service = new TaskService(); // create a new task service object
		assertTrue(TaskService.taskList.isEmpty()); // check that the task list is empty
		service.addTaskById("task1", "groceries", "go and get groceries"); // create a new contact object
		Task t = service.searchTaskById("task1"); // search for the newly made task by id and store it as object t
		Assertions.assertEquals("groceries", t.getTaskName()); // assert that the task name is the same as the newly instanced objects name
		Assertions.assertEquals("go and get groceries", t.getTaskDescription()); // assert that the task description matched the newly instanced objects description
	}
	
	@Test
	void testUpdateTaskName() {
		TaskService service = new TaskService(); // create a new task service object
		assertTrue(TaskService.taskList.isEmpty()); // check that the list is empty
		service.addTaskById("1", "name", "description"); // create a new task object 
		service.updateTaskName("1", "new name"); // update the task object with id 1's name to new name
		Assertions.assertEquals("new name", service.searchTaskById("1").getTaskName()); // assert that the updated name entered is what is returned as the name of the object
	}
	
	@Test
	void testUpdateDescription() {
		TaskService service = new TaskService(); // create a new task service object
		assertTrue(TaskService.taskList.isEmpty()); // check that the list is empty
		service.addTaskById("1", "name", "description"); // create a new task object 
		service.updateTaskDescription("1", "new description"); // update the task object with id 1's description to new description
		Assertions.assertEquals("new description", service.searchTaskById("1").getTaskDescription()); 
		// assert that the updated description entered is what is returned as the description of the object
	}
	
	@Test
	void testDeleteTask() {
		TaskService service = new TaskService(); // create a new task service object
		assertTrue(TaskService.taskList.isEmpty()); // check that the task list is empty
		service.addTaskById("1", "task1", "task 1 description"); // add a new task object
		service.deleteTask("1"); // call the delete method for the task object with the just made id
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.searchTaskById("1")); 
		// assert that the exception is thrown when trying to search for the object after it is deleted
		
	}
	
	@Test
	void addTaskUsingGeneratedUUID() {
		TaskService service = new TaskService(); // create a new task service object
		assertTrue(TaskService.taskList.isEmpty()); // check that the task list is empty
		Task t = service.addTask("task1", "description1"); // create a new task t by adding a task with name and description and a generated uuid
		assertTrue(TaskService.taskList.contains(t)); // check that task t exists in the list
	}
	
	
	
	

	}


