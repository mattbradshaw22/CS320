package contacttest;


import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import contact.Contact;


public class ContactTest {

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
	void tearDown() throws Exception {
	}
	
	
	@Test
	void testValidContact() {
		Assertions.assertDoesNotThrow(() ->  // check that no exceptions are thrown
			new Contact("1", "matthias", "bradshaw", "1234567890", "123 main street") // when a new valid contact is created
		 );
	}
	
	
	@Test
	void testContactIdNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that an illegal argument exception is thrown
			new Contact(null, "matthias", "bradshaw", "1234567890", "123 main street"); // when the contactId is null
		} );
	}
	
	
	@Test
	void testContactIDTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that an illegal argument exception is thrown
			new Contact("12345678910", "matthias", "bradshaw", "1234567890", "123 main street"); // when contactId is too long
		} );
	}
	
	
	@Test
	void testFNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that an illegal argument exception is thrown
			new Contact("1", null, "bradshaw", "1234567890", "123 main street"); // when the first name is null
		} );
	}
	
	
	@Test
	void testFirstNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that an illegal argument exception is thrown
			new Contact("1", "matthiaslong", "bradshaw", "1234567890", "123 main street"); // when the first name is too long
		} );
	}
	
	
	@Test
	void testLNameNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that an illegal argument exception is thrown
			new Contact("1", "matthias", null, "1234567890", "123 main street"); // when the last name is null
		} );
	}
	
	
	@Test
	void testLastNameTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that an illegal argument exception is thrown
			new Contact("1", "matthias", "bradshawlong", "1234567890", "123 main street"); // when the last name is too long
		} );
	}
	
	
	@Test
	void testPhuneNumNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that an illegal argument exception is thrown
			new Contact("1", "matthias", "bradshaw", null, "123 main street"); // when the phone number is null
		} );
	}

	
	@Test
	void testPhoneTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that an illegal argument exception is thrown
			new Contact("1", "matthias", "bradshaw", "12345678910", "123 main street"); // when the phone number is too long
		} );
	}
	
	
	@Test
	void testPhoneTooShort() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that an illegal argument exception is thrown
			new Contact("1", "matthias", "bradshaw", "123456789", "123 main street"); // when the phone number is too short
		} );
	}
	
	
	@Test
	void testPhoneNumDigits() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that an illegal argument exception is thrown
			new Contact("1", "matthias", "bradshaw", "Q23456789", "123 main street"); // when the phone number isn't only digits
		} );
	}
	
	
	@Test
	void testAddressNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that an illegal argument exception is thrown
			new Contact("1", "matthias", "bradshaw", "1234567890", null); // when the address is null
		} );
	}
	
	
	@Test
	void testAddressTooLong() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> { // check that an illegal argument exception is thrown
			new Contact("1", "matthias", "bradshaw", "1234567890", "123 main street but much longer of an address"); // when the address is too long
		} );
	}
}
