
package task;

import java.util.List;
import java.util.ArrayList;
import java.util.UUID;


public class TaskService {
	
	// create an array list to store Task objects
	public final static List<Task> taskList = new ArrayList<Task>();  
	
		// private static method to generate Task Id
		private String genTaskId() {
			String id;                                                // declare variable id as string
			boolean exists;                                           // declare boolean variable exists 
	        do {                                                      // do while loop   
	            id = UUID.randomUUID().toString().substring(0, 10);   // generate a random UUID as var id set to string and only take first 10 characters
	            exists = false;                                       // initialize bool exists to false assuming that UUID is unique
	            for (Task t : taskList) {                             // loop through the task list for each task t
	                if (t.getTaskId().equals(id)) {                   // if any task returns the same taskId
	                    exists = true;                                // set exists to true for a collision
	                    break;                                        // break out of the loop comparing UUID's
	                }
	            }
	        } while (exists);                                        // do while loop until exists stays false
	        
	        return id;                                               // return id
		}
		
		// add a new task with auto generated uuid and name and description as parameters
		public Task addTask(String taskName, String taskDescription) {   // add a new task with paramaters for name and description
	        String id = genTaskId();									 // generate a task id with the genTaskid method and store as id
	        Task newTask = new Task(id, taskName, taskDescription);      // create a new task object with params id, taskname, and task description
	        taskList.add(newTask); 										 // add the new task to the task list
	
	        return newTask;												 // return the new task object
		}
		
		// add a new task with specific id, name and description as parameters
		// just used for testing as the generated UUIDs wont be known for the search method
				public Task addTaskById(String taskId, String taskName, String taskDescription) {   // add a new task with paramaters for id, name and description
			        
			        Task newTask = new Task(taskId, taskName, taskDescription);      // create a new task object with params taskId, taskName, and taskDescription
			        taskList.add(newTask); 										     // add the new task to the task list
			
			        return newTask;												     // return the new task object
				}
		
		/* method to search task list by taskId
		 * 
		 * @param taskId
		 *  also validates that the task exists or throws an exception
		 */
		public Task searchTaskById(String taskId) {
			if (taskId == null)                                                   // if the task id passed through is null
				throw new IllegalArgumentException("taskId can not be null");	  // throw an exception
			
	        for (Task t : taskList) {                                             // for each task object t in the task list
	            if (t.getTaskId().equals(taskId))                   		      // if the passed taskId is equal to the taskId of the task object
	            	
	            	return t;                                                     // return the task object t
	        
	        }
	        throw new IllegalArgumentException("Task " + taskId + " not found"); // throw an exception if the task is not found
	    }
		
		/* method to update task name
		 * 
		 *  @param taskId
		 *  validation for the new task name is in the setTaskName method
		 */
		public void updateTaskName(String taskId, String newTaskName) {
			searchTaskById(taskId).setTaskName(newTaskName);
			// calls the searchTaskById method for the taskId to access the object and uses the setTaskName method to set the new task name		
		}
		
		
		/* method to update task description
		 * 
		 *  @param taskId
		 *  validation for the new task description is in the setTaskName method
		 */
		public void updateTaskDescription(String taskId, String newTaskDescription) {
			searchTaskById(taskId).setTaskDescription(newTaskDescription);
			// calls the searchTaskById method for the taskId to access the object and uses the setTaskDescription method to set the new task description			 
		}
		
		/* method to delete a task
		*
		* @param taskId
		*/
		public void deleteTask(String taskId) {
			Task t = searchTaskById(taskId);            // calls the searchTaskById method for the taskId to access the object
			taskList.remove(t);                         // removes the task object t from the taskList 
			}
		
	    }
		
		
