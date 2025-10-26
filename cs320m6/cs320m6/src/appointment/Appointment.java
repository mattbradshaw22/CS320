/**
 * 
 */
package appointment;
import java.util.Date;

/**
 * 
 */
public class Appointment {

	// declare variables
	private final String apptId;
	private Date apptDate;
	private String apptDescrip;
	
	//appointment constructor
	public Appointment(String apptId, Date apptDate, String apptDescrip) {
		
		this.apptId = validateApptId(apptId);
		this.setApptDate(apptDate);
		this.setApptDescrip(apptDescrip);
	}
	
	// method to validate appt id is not null and 10 or less chars
		 private String validateApptId(String apptId) {
		        
		        if (apptId == null || apptId.length() > 10) { // if apptId length is > 10 or apptId is null
		            throw new IllegalArgumentException("Appointment ID must be 10 characters or less and not null"); 
		            // throw illegal argument exception
		        }
		        return apptId;
		 }
	
	// getters and setters
	
	/**
	 * @return the apptId
	 */
	public String getApptId() {
		return apptId;
	}
	/**
	 * @return the  a copy of apptDate
	 */
	public Date getApptDate() {
		return new Date (apptDate.getTime());
	}
	
	/**
	 * @param apptDate the apptDate to set
	 * with validation that the appt date is not null and is not before the current date
	 */
	public void setApptDate(Date apptDate) {
		if (apptDate == null || apptDate.before(new Date())) {
			throw new IllegalArgumentException("Appointment Date can not be null or in the past");
		}
		
		this.apptDate = new Date(apptDate.getTime());
	}
	
	/**
	 * @return the apptDescrip
	 */
	public String getApptDescrip() {
		return apptDescrip;
	}
	
	/**
	 * @param apptDescrip the apptDescrip to set
	 * wit validation for not null and 50 char max
	 */
	public void setApptDescrip(String apptDescrip) {
		if (apptDescrip == null || apptDescrip.length() > 50) {
			throw new IllegalArgumentException("Appointment Description must be 50 characters or less");
		}
		this.apptDescrip = apptDescrip;
	}
}
