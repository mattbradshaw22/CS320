package contacttest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contact.Contact;
import contact.ContactService;

class ContactServiceTest {
	

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
	void tearDown() {
		ContactService.contactList.clear();     // clear contact list
	    assertTrue(ContactService.contactList.isEmpty());
	}

	@Test
	void testAddContact() {
		ContactService service = new ContactService(); // create a new contact service object
		assertTrue(ContactService.contactList.isEmpty()); // check that the list is empty
		service.addContact("matthias", "bradshaw", "1234567890", "321 main street"); // create a new contact object
		Contact c0 = service.findById("0");  // first contact will be given id 0 so c0
		Assertions.assertNotNull(c0); // assert that c0 is not null
		Assertions.assertEquals("matthias", c0.getFirstName()); // assert that the getfirstName method outputs the same string as input
		Assertions.assertEquals("bradshaw", c0.getLastName()); // assert that the getLastName method outputs the same string as input
		Assertions.assertEquals("1234567890", c0.getPhoneNum()); // assert that the getPhoneNum method outputs the same string as input
		Assertions.assertEquals("321 main street", c0.getAddress()); // assert that the getAddress method outputs the same string as input
	}
	
	
	@Test
	void testUpdateFName() {
		ContactService service = new ContactService(); // create a new contact service object
		assertTrue(ContactService.contactList.isEmpty()); // check that the list is empty
		service.addContact("matthias", "bradshaw", "1234567890", "321 main street"); // create a new contact object
		service.updateFirstName("0", "matt");  // update the first name to matt
		Assertions.assertEquals("matt", service.findById("0").getFirstName()); //assert that c0 getfirstname method matches input for update first name method 
	}

	
	@Test
	void testUpdateLName() {
		ContactService service = new ContactService(); // create a new contact service object
		assertTrue(ContactService.contactList.isEmpty()); // check that the list is empty
		service.addContact("matthias", "bradshaw", "1234567890", "321 main street"); // create a new contact object
		service.updateLastName("0", "brads"); // update last name to brads
		Assertions.assertEquals("brads", service.findById("0").getLastName()); // assert last name has been updated by two values being equal
	}
	
	
	@Test
	void testUpdatePhoneNum() {
		ContactService service = new ContactService(); // create a new contact service object
		assertTrue(ContactService.contactList.isEmpty()); // check that the list is empty
		service.addContact("matthias", "bradshaw", "1234567890", "321 main street"); // create a new contact object
		service.updatePhoneNum("0", "1098765432");  // update phone number to 1098765432
		Assertions.assertEquals("1098765432", service.findById("0").getPhoneNum()); // assert that phone number has been updated by two values being equal		
	}
	
	
	@Test
	void testUpdateAddress() {
		ContactService service = new ContactService(); // create a new contact service object
		assertTrue(ContactService.contactList.isEmpty()); // check that the list is empty
		service.addContact("matthias", "bradshaw", "1234567890", "321 main street"); // create a new contact object
		service.updateAddress("0", "55 first ave"); // update address to 55 first ave
		Assertions.assertEquals("55 first ave", service.findById("0").getAddress()); // assert that address has been updated by the two values being equal
		
	}
	
	
	@Test
	void testDeleteContact() {
		ContactService service = new ContactService(); // create a new contact service object
		assertTrue(ContactService.contactList.isEmpty()); // check that the list is empty
		service.addContact("matthias", "bradshaw", "1234567890", "321 main street"); // create a new contact object
		service.deleteContact("0"); // call the delete method for contact 0, 0 is first id num
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.findById("0")); // assert that once deleted the illegal argument exception is thrown as the contact is not found
	}
	
}

