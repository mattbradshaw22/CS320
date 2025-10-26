package appointmenttest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointment.Appointment;

class AppointmentTest {

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
	void tearDown() throws Exception {
	}

	@Test
	void testValidAppointment() {
		
		final Date testDate = new Date(126, 11, 12); // 
		Appointment assertDoesNotThrow = Assertions.assertDoesNotThrow(() -> // check that no exceptions are thrown for a valid task
		new Appointment("1", testDate, "this is a test appointment")
		);
	}
	
	@Test
	void testApptIdNull() {
		
		final Date testDate = new Date(126, 11, 12); // set a future date of dec 12 2026 for testing
		Assertions.assertThrows(IllegalArgumentException.class, () -> {  // check that an exception is thrown id the task id is null
			new Appointment(null, testDate , "Valid Description");
		} );
	}
	
	@Test
	void testApptIdLength() {
		final Date testDate = new Date(126, 11, 12); // set a future date of dec 12 2026 for testing
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("12345678910", testDate, "Valid Description");
		} );
	}
	
	@Test
	void testApptDateNotNull() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890", null, "Valid Description");
		} );
	}
	
	@Test
	void testApptDatePast() {
		final Date testDate = new Date(124, 11, 12); // set a past date of dec 12 2024 for testing
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890", testDate, "Valid Description");
		} );
	}
	
	@Test
	void testApptDescNull() {
		
		final Date testDate = new Date(126, 11, 12); // set a future date of dec 12 2026 for testing
		Assertions.assertThrows(IllegalArgumentException.class, () -> {  // check that an exception is thrown id the task id is null
			new Appointment("1234567890", testDate , null);
		} );
	}
	
	@Test
	void testApptDescLength() {
		final Date testDate = new Date(126, 11, 12); // set a future date of dec 12 2026 for testing
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Appointment("1234567890", testDate, "Not A Valid Description Because Way Tooooooooo Long");
		} );
	}

}
