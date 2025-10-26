/**
 * 
 */
package appointment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * 
 */
public class AppointmentService {
	
	// create an array list to store Appointment objects
		public final List<Appointment> apptList = new ArrayList<Appointment>();  
		
			// private static method to generate appt Id
			private final String genApptId() {
				String id;                                                // declare variable id as string
				boolean exists;                                           // declare boolean variable exists 
		        do {                                                      // do while loop   
		            id = UUID.randomUUID().toString().substring(0, 10);   // generate a random UUID as var id set to string and only take first 10 characters
		            exists = false;                                       // initialize bool exists to false assuming that UUID is unique
		            for (Appointment a : apptList) {                             // loop through the appointment list for each appt a
		                if (a.getApptId().equals(id)) {                   // if any appointment returns the same apptId
		                    exists = true;                                // set exists to true for a collision
		                    break;                                        // break out of the loop comparing UUID's
		                }
		            }
		        } while (exists);                                        // do while loop until exists stays false
		        
		        return id;                                               // return id
			}

			
			// add a new appointment with auto generated uuid and date and description as parameters
			public Appointment addAppt(Date apptDate, String apptDescrip) {            // add a new appt with paramaters for Date and description
		        String id = genApptId();									           // generate an appt id with the genapptid method and store as id
		        Appointment newAppt = new Appointment(id, apptDate, apptDescrip);      // create a new appointment object with params id, Date, and appointment description
		        apptList.add(newAppt); 										           // add the new appointment to the appt list
		
		        return newAppt;												           // return the new appt object
			}
			
			/* method to search appt list by apptId
			 * 
			 * @param apptId
			 *  also validates that the appt exists or throws an exception
			 */
			public Appointment searchApptById(String apptId) {
				if (apptId == null)                                                   // if the Appointment id passed through is null
					throw new IllegalArgumentException("apptId can not be null");	  // throw an exception
				
		        for (Appointment a : apptList) {                                      // for each Appointment object a in the Appointment list
		            if (a.getApptId().equals(apptId))                   		      // if the passed apptId is equal to the apptId of the Appointment object
		            	
		            	return a;                                                     // return the Appointment object a
		        
		        }
		        throw new IllegalArgumentException("Appointment " + apptId + " not found"); // throw an exception if the Appointment is not found
		    }
			
			
			/* method to delete an Appt
			*
			* @param apptId
			*/
			public void deleteAppt(String apptId) {
				Appointment a = searchApptById(apptId);     // calls the searchApptById method for the apptId to access the object
				apptList.remove(a);                         // removes the appt object a from the apptList 
				}
			
		    }



