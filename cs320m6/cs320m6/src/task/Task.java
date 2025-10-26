/**
 * 
 */
package task;


/**
 * 
 */
public class Task { // create the public class Task
	
	// declare variables
	private final String taskId;  // private string variable for task id
	private String taskName;  // private string variable for task name
	private String taskDescription; // private string variable for task description
	
		
	// public constructor for task with parameters
	public Task(String taskId, String taskName, String taskDescription) {
		
		this.taskId = validateTaskId(taskId);
		this.setTaskName(taskName);
		this.setTaskDescription(taskDescription);
		
	}
	
	// method to validate task id is not null and 10 or less chars
	 private static String validateTaskId(String taskId) {
	        
	        if (taskId == null || taskId.length() > 10) { // if taskid length is > 10 or taskid is null
	            throw new IllegalArgumentException("Invalid Task ID"); // throw illegal argument exception
	        }
	        return taskId;
	 }

	
	/*
	 * getters and setters
	 */
	/**
	 * @return the taskId
	 */
	public String getTaskId() {
		return taskId;
	}

	/**
	 * @return the taskName
	 */
	public String getTaskName() {
		return taskName;
	}

	/**
	 * @param taskName the taskName to set
	 * with validation of not null and less than 20 chars
	 */
	public void setTaskName(String taskName) {
		if (taskName == null || taskName.length() > 20) {
			throw new IllegalArgumentException("Invalid Task Name");
		}		
		this.taskName = taskName;
	}

	/**
	 * @return the taskDescription
	 */
	public String getTaskDescription() {
		return taskDescription;
	}

	/**
	 * @param taskDescription the taskDescription to set
	 * with validation of not null and less than 50 chars
	 */
	public void setTaskDescription(String taskDescription) {
		if (taskDescription == null || taskDescription.length() > 50) {
			throw new IllegalArgumentException("Invalid Task Description");
		}
		this.taskDescription = taskDescription;
	}
}
