//Author: Alex Jarratt
//Date: 5/21/2022
//Class: SNHU CS-320

package main;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;



class ContactServiceTest {
	protected String contactID, first_NameT, last_NameT, phoneNumberT, fullAddressT, longContactID, 
					 longFirst_Name, longLast_Name, longphoneNumber, longfullAddress, shortNumber;
	
	@BeforeEach
	void setUp() {
		contactID = "0123456789";
		first_NameT = "INITIAL";
		last_NameT = "INITIAL";
		phoneNumberT = "0123456789";
		fullAddressT = "INITIAL";
		longContactID = "012345678901";
		longFirst_Name = "Supercalifragilistic";
		longLast_Name = "Expialidocious";
		longphoneNumber = "5551111212333";
		longfullAddress = "1600 Pennsylvania Avenue Washington DC A Really Long Address";
		shortNumber = "5";		
	}
	
	@Test
	void newContactTest() {
		ContactService service = new ContactService();
		
		service.newContact();
		assertAll("service", 
				()-> assertNotNull(service.getContactList().get(0).getContactID()),	            
		        () -> assertEquals("INITIAL", service.getContactList().get(0).getFirst_Name()),
		        ()-> assertEquals("INITIAL", service.getContactList().get(0).getLast_Name()), 
		        ()-> assertEquals("0123456789",service.getContactList().get(0).getphoneNumber()),                   
		        ()-> assertEquals("INITIAL", service.getContactList().get(0).getfullAddress()));
		
		service.newContact(first_NameT);
		assertAll("service", 
				()-> assertNotNull(service.getContactList().get(1).getContactID()),	            
		        () -> assertEquals(firstNameT, service.getContactList().get(1).getFirst_Name()),
		        ()-> assertEquals("INITIAL", service.getContactList().get(1).getLast_Name()), 
		        ()-> assertEquals("0123456789",service.getContactList().get(1).getphoneNumber()),                   
		        ()-> assertEquals("INITIAL", service.getContactList().get(1).getfullAddress()));
		
		service.newContact(first_NameT, last_NameT);
		assertAll("service", 
				()-> assertNotNull(service.getContactList().get(2).getContactID()),	            
		        () -> assertEquals(first_NameT, service.getContactList().get(2).getFirst_Name()),
		        ()-> assertEquals(last_NameT, service.getContactList().get(2).getLast_Name()), 
		        ()-> assertEquals("0123456789",service.getContactList().get(2).getphoneNumber()),                   
		        ()-> assertEquals("INITIAL", service.getContactList().get(2).getfullAddress()));
		
		service.newContact(first_NameT, last_NameT, phoneNumberT);
		assertAll("service", 
				()-> assertNotNull(service.getContactList().get(3).getContactID()),	            
		        () -> assertEquals(first_NameT, service.getContactList().get(3).getFirst_Name()),
		        ()-> assertEquals(last_NameT, service.getContactList().get(3).getLast_Name()), 
		        ()-> assertEquals(phoneNumberT,service.getContactList().get(3).getphoneNumber()),                   
		        ()-> assertEquals("INITIAL", service.getContactList().get(3).getfullAddress()));
		
		service.newContact(first_NameT, last_NameT, phoneNumberT, fullAddressT);
		assertAll("service", 
				()-> assertNotNull(service.getContactList().get(4).getContactID()),	            
		        () -> assertEquals(first_NameT, service.getContactList().get(4).getFirst_Name()),
		        ()-> assertEquals(last_NameT, service.getContactList().get(4).getLast_Name()), 
		        ()-> assertEquals(phoneNumberT,service.getContactList().get(4).getphoneNumber()),                   
		        ()-> assertEquals(fullAddressT, service.getContactList().get(4).getfullAddress()));
		
	}
	
	@Test
	void deleteContactTest() {
		ContactService service = new ContactService();
		service.newContact();
		assertThrows(Exception.class, ()->service.deleteContact(contactID));
		assertAll(()->service.deleteContact(service.getContactList().get(0).getContactID()));
	}
	
	 @Test
	  void updateFirstNameTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.setFirstName(service.getContactList().get(0).getContactID(),
	                            first_NameT);
	    assertEquals(first_NameT, service.getContactList().get(0).getFirst_Name());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setFirst_Name(
	                         service.getContactList().get(0).getContactID(),
	                         longFirst_Name));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setFirst_Name(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.setFirst_Name(contactID, first_NameT));
	  }
	
	 @Test
	  void updateLastNameTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.setLast_Name(service.getContactList().get(0).getContactID(),
	                           last_NameT);
	    assertEquals(last_NameT, service.getContactList().get(0).getLast_Name());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setLast_Name(
	                         service.getContactList().get(0).getContactID(),
	                         longLast_Name));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setLast_Name(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.setLast_Name(contactID, last_NameT));
	  }

	  @Test
	  void updatePhoneNumberTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.setphoneNumber(service.getContactList().get(0).getContactID(), phoneNumberT);
	                              
	    assertEquals(phoneNumberT,
	                 service.getContactList().get(0).getphoneNumber());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setphoneNumber(
	                         service.getContactList().get(0).getContactID(),
	                         longphoneNumber));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setphoneNumber(
	                         service.getContactList().get(0).getContactID(),
	                         shortphoneNumber));
	    assertThrows(
	        IllegalArgumentException.class,
	        ()
	            -> service.setphoneNumber(
	                service.getContactList().get(0).getContactID(), "5551212"));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setphoneNumber(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.setphoneNumber(contactID, last_NameT));
	  }

	  @Test
	  void updateAddressTest() throws Exception {
	    ContactService service = new ContactService();
	    service.newContact();
	    service.setfullAddress(service.getContactList().get(0).getContactID(),
	                          fullAddressT);
	    assertEquals(fullAddressT, service.getContactList().get(0).getfullAddress());
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setfullAddress(
	                         service.getContactList().get(0).getContactID(),
	                         longfullAddress));
	    assertThrows(IllegalArgumentException.class,
	                 ()
	                     -> service.setfullAddress(
	                         service.getContactList().get(0).getContactID(), null));
	    assertThrows(Exception.class,
	                 () -> service.setfullAddress(contactID, fullAddressT));
	  }

}
