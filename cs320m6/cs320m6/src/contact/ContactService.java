package contact;

import java.util.List;
import java.util.ArrayList;

public class ContactService {

	int IdNum = 0; // declare and initialize int variable IdNum to assign contact id's
	
	public final static List<Contact> contactList = new ArrayList<Contact>();  // create an array list to store contact objects
	
	/*
	 * Add a contact method 
	 * uses assigned contact id
	 * @param firstName
	 * @param lastName
	 * @param phoneNum
	 * @param address
	 */
	public void addContact(String firstName, String lastName,
	String phoneNumber, String address) {     
		String stringId = Integer.toString(IdNum);  // takes the current IdNum variable changes it from an int to a String and sets it to the String stringId
		
		Contact newContact = new Contact(stringId, firstName, lastName, phoneNumber, address);  // create a new contact object with the stringId as the contactId and the remaining parameters
		contactList.add(newContact);  // adds the new contact object to the contactList List
		
		IdNum++;    // increment id number so next contact gets an id one higher
	}
	
	/* method to relate a contact object to is string contact id
	 * 
	 * this makes it easier to work with the contact object and use dot operator method calls
	 * this also validates that the contactId is not null and is in the contactList List
	 * 
	 * @param contactId
	 * @return
	 */
	public Contact findById(String contactId) {
		if (contactId == null)                                           // validate that the passed contactId is not null
			throw new IllegalArgumentException("Id can not be null");    // if it is throw an exception
		
		for (Contact c : contactList) {                                  // for each contact object c in the contact list
			if (contactId.equals(c.getContactId()))                      // if the passed contactId is equal to the contact Id of the contact object
				
				return c;                                                // return that contact object
		}
		throw new IllegalArgumentException("Id not in list");            // throw an exception if the contact id doesn't match a contact object
	}
	
	/* method to delete a contact
	*
	* @param contactId
	*/
	public void deleteContact(String contactId) {
		Contact c = findById(contactId);            // calls the findById method for the contactId to access the object
		contactList.remove(c);                      // removes the contact object c from the contactList 
		}
	
	/* method to update first name
	 * 
	 *  @param contactId
	 *  validation for the new first name is in the setFirstName method
	 */
	public void updateFirstName(String contactId, String newFirstName) {
		findById(contactId).setFirstName(newFirstName);
		// calls the findById method for the contactId to access the object and uses the setFirstName method to set the new first name		
		 
	}
	
	/* method to update last name
	 * 
	 *  @param contactId
	 *  validation for the new last name is in the setLastName method
	 */
	public void updateLastName (String contactId, String newLastName) {
		findById(contactId).setLastName(newLastName);
		// calls the findById method for the contactId to access the object and uses the setLastName method to set the new last name
		
	}
	
	/* method to update phone number
	 * 
	 *  @param contactId
	 *  validation for the new phone number is in the setPhoneNum method
	 */
	public void updatePhoneNum(String contactId, String newPhoneNum) {
		findById(contactId).setPhoneNum(newPhoneNum);
		// calls the findById method for the contactId to access the object and uses the setPhoneNum method to set the new phone number
		 
	}
	
	/* method to update address
	 * 
	 *  @param contactId
	 *  validation for the new address is in the setAddress method
	 */
	public void updateAddress(String contactId, String newAddress) {
		findById(contactId).setAddress(newAddress);
		// calls the findById method for the contactId to access the object and uses the setAddress method to set the new address
		 
	}
	
	}
