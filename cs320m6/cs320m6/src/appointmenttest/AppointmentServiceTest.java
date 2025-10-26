package appointmenttest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import java.time.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointment.Appointment;
import appointment.AppointmentService;

class AppointmentServiceTest {
	
	private Date validDate;
    private Date invalidDate;
    private AppointmentService service;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	// before each test create a valid date that can be used as a parameter in the appointment object
	void setUp() {
		validDate = new Date(126, 11, 12);
		// create a new instance of appointment service as service
		service = new AppointmentService();
        // clear the appointment list
        service.apptList.clear();
        // certify that the appt list is empty
        assertTrue(service.apptList.isEmpty());		
	}

	@AfterEach
	void tearDown() {
	}
	

	@Test
	void testAddAppointment() {
		
		Appointment a = service.addAppt(validDate, "appt description"); // create a new appt object
		assertNotNull(a);                                              // verify the appt object a is not null and was created
		assertNotNull(a.getApptId()); 								   // verify the id is not null
		assertEquals(validDate, a.getApptDate());                      //  verify the valid date passed through matched the date of the object
		assertEquals("appt description", a.getApptDescrip());         // verify the passed through description matches the description of the object
	}
	
	@Test
	void testDeleteAppt() {
		// add a new appt object as a
		Appointment a = service.addAppt(validDate, "appt description");
		
		// store the id of object a as id
	    String id = a.getApptId();

	    assertTrue(service.apptList.contains(a)); // assert that the object is in the list
	    int beforeSize = service.apptList.size(); // get the size of the list before deleting

	    // delete the appt object by the stored id
	    service.deleteAppt(id);

	    // assert that the size of the list is one smaller after deleting
	    assertEquals(beforeSize - 1, service.apptList.size());

	    // assert that the object a is no longer in the list
	    assertFalse(service.apptList.contains(a));
	}
	
	@Test
	void testSearchNullId() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.searchApptById(null)); // assert that searching for a null appt id throws an exception
	}

	@Test
	void testSearchIdNotFound() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> service.searchApptById("1")); // assert that searching for a appt id that doesnt exist throws an exception
	}

}
