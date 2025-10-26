package tasktest;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import task.Task;



class TaskTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown()  {
		
	}

	@Test
	void testValidTask() {
		Assertions.assertDoesNotThrow(() -> // check no exceptions are thrown for a valid task
			new Task("123456789", "grocery shopping", "go to the store and get some groceries")
			);
	}
	
	@Test
	void testTaskIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {  // check that an exception is thrown id the task id is null
			new Task(null, "grooceries", "go get some groceries");
		} );
	}
	
	@Test
	void testTaskIdLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check the length of task id can be > 10
			new Task("12345678910", "groceries", "go get some groceries");
		} );
	}

	
	@Test
	void testTaskNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that task name cant be null
			new Task("1234567890", null, "task name is null");
		} );
	}
	
	@Test
	void testTaskNameLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that task name cant be > 20 chars
			new Task("1234567890", "this task name is longer than it needs to be", "and its description is fine");
		} );
	}
	
	@Test
	void testTaskDescNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that an exception is thrown when the description is null
			new Task("1234", "groceries", null);
		} );
	}
	
	@Test
	void testTaskDescLength() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that an exception is thrown when the description is too long
			new Task("1234", "groceries", "this description is way longer than it needs to be. ");
		} ); 
	}
}
