package contact;

public class Contact { // create the public class contact
	
	// declare variables
	private final String contactId;  // private string variable for contact id
	private String firstName;  // private string variable for first name
	private String lastName;   // private string variable for last name
	private String phoneNum;   // private string variable for phone number
	private String address;    // private string variable for address

	// public constructor for Contact with parameters
	public Contact(String contactId, String firstName, String lastName, String phoneNum, String address) {
		
		
		this.contactId = validateId(contactId);   // validate contactID with validateId method and assign to objects contactId
		this.setFirstName(firstName);            //  assign objects firstName via setter method
		this.setLastName(lastName);             // assign objects last name via setter method
		this.setPhoneNum(phoneNum);            // assign objects phone number via setter method
		this.setAddress(address);             // assign objects address via setter method
	}


	/*
	 * Setters and getters with validation for the setters 
	 * 
	 */ 
	 
	/* 
	 * @return the contactId
	 */
	public String getContactId() {
		return contactId; }
	

	/* contact id validation method
	 * @param contactId 
	 * no setter because its immutable 
	 */
	private static String validateId(String contactId) {
        if (contactId == null || contactId.length() > 10) {            // if the contactId is null or greater than 10 characters
        	throw new IllegalArgumentException("Invalid Contact ID");  // throw an exception
        }
        return contactId;                                              // return contact id to be used in constructor
	}

	/*
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/*
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		if (firstName == null || firstName.length() > 10) {              // if the first name is null or longer than 10 chars
			throw new IllegalArgumentException("Invalid First Name");    // throw illegal exception argument
		}
		this.firstName = firstName;  // set the first name
	}

	/*
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/*
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		if (lastName == null || lastName.length() > 10) {                // if the last name is null or longer than 10 chars
			throw new IllegalArgumentException("Invalid Last Name");     // throw illegal exception argument
		}
		this.lastName = lastName;  // set the last name
	}  

	/*
	 * @return the phoneNum
	 */
	public String getPhoneNum() {
		return phoneNum;
	}

	/*
	 * @param phoneNum the phoneNum to set
	 */
	public void setPhoneNum(String phoneNum) {
		if (phoneNum == null || phoneNum.length() != 10) {               // if the phone number is null or not 10 digits
			throw new IllegalArgumentException("Invalid Phone Number");  // throw illegal exception argument
		}
		for (char ch : phoneNum.toCharArray()) {   // for each character in PhoneNum as a character array
			if (!Character.isDigit(ch)) {          // if the character from the array is not a digit
				throw new IllegalArgumentException("Phone number must be digits");  // if not throw an exception
			}
		}
		this.phoneNum = phoneNum; // set the phone number
	}

	/*
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/*
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		if (address == null || address.length() > 30) {                  // if the address is null or longer than 30 chars
			throw new IllegalArgumentException("Invalid Address");       // throw illegal exception argument
		}
		this.address = address;  // set the address
	}
}