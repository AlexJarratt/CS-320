//Author: Alex Jarratt
//Date: 5/21/2022
//Class: SNHU CS-320

package main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

class ContactTest  {

	protected String contactID, first_NameT, last_NameT, phoneNumberT, fullAddressT;
	protected String longContactID, longFirst_Name, longLast_Name, longphoneNumber, longfullAddress, shortNumber;
	
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
	
	//test creation of a contact with no arguments
	@Test
	void contactConstructorTest() {
		Contact contact = new Contact();
		assertAll("No Arguments Contstructor",
			()-> assertNotNull(contact.getContactID()),
            ()-> assertNotNull(contact.getFirstName()),
            ()-> assertNotNull(contact.getLastName()),              
            ()-> assertNotNull(contact.getNumber()),
            ()-> assertNotNull(contact.getAddress()));   				
	}
	
	//test creation of a contact with contactID
	@Test
	void contactIDConstructorTest() {
		Contact contact = new Contact(contactID);
		assertAll("Contact ID Constructor Test",
				() -> assertEquals(contactID, contact.getContactID()),
				()-> assertNotNull(contact.getFirstName()),
	            ()-> assertNotNull(contact.getLastName()),              
	            ()-> assertNotNull(contact.getNumber()),
	            ()-> assertNotNull(contact.getAddress())); 
	}
	
	//test creation of a contact with contactID and firstName provided
	@Test 
	void firstNameConstructorTest() {
		Contact contact = new Contact(contactID, first_NameT);
		assertAll("firstNameConstructorTest",
				() -> assertEquals(contactID, contact.getContactID()),
				()-> assertEquals(first_NameT, contact.getFirstName()),
	            ()-> assertNotNull(contact.getLastName()),              
	            ()-> assertNotNull(contact.getNumber()),
	            ()-> assertNotNull(contact.getAddress())); 
	}
	
	//test creation of a contact with contactID firstName and lastName provided
	@Test
	void lastNameConstructorTest() {
		Contact contact = new Contact(contactID, first_NameT, last_NameT);
		assertAll("lastNameConstructorTest",
				() -> assertEquals(contactID, contact.getContactID()),
				()-> assertEquals(first_NameT, contact.getFirstName()),
	            ()-> assertEquals(last_NameT, contact.getLastName()),              
	            ()-> assertNotNull(contact.getNumber()),
	            ()-> assertNotNull(contact.getAddress())); 
	}
	
	//test creation of a contact with contactID, firstName, lastName, and number provided
	@Test
	void numberConstructorTest() {
		Contact contact = new Contact(contactID, first_NameT, last_NameT, phoneNumberT);
		assertAll("numberConstructorTest",
				() -> assertEquals(contactID, contact.getContactID()),
				()-> assertEquals(first_NameT, contact.getFirstName()),
	            ()-> assertEquals(last_NameT, contact.getLastName()),              
	            ()-> assertEquals(phoneNumberT, contact.getNumber()),
	            ()-> assertNotNull(contact.getAddress()));
	}
	
	//test creation of a contact with all fields provided
	@Test
	void addressConstructorTest() {
		Contact contact = new Contact(contactID,first_NameT, last_NameT, phoneNumberT, fullfullAddressT  );
		assertAll("addressConstructorTest", 
				() -> assertEquals(contactID, contact.getContactID()),
				()-> assertEquals(first_NameT, contact.getFirstName()),
	            ()-> assertEquals(last_NameT, contact.getLastName()),              
	            ()-> assertEquals(phoneNumberT, contact.getNumber()),
	            ()-> assertEquals(fullAddressT, contact.getAddress()));
	}
	
	//test first name parameters, cant be null or more than 10 characters
	@Test
	void setfirst_NameTest() {
		Contact contact = new Contact();
		contact.setFirstName(first_NameT);
		assertAll("first_NameTest",
			()-> assertEquals(first_NameT, contact.getFirstName()),
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setFirstName(null)),    
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setFirstName(longFirst_Name)));				
	}
	
	//test last name parameters, cant be null and cant be more than 10 characters
	@Test 
	void setlast_NameTest() {
		Contact contact = new Contact();
		contact.setLastName(first_NameT);
		assertAll("last_NameTest",
			()-> assertEquals(last_NameT, contact.getFirstName()),
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setLastName(null)),    
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setLastName(longLast_Name)));
	}
	
	//test number, cant be null, more than 10 digits, less than 10 digits, have any values other than integers
	@Test
	void setphoneNumberTest() {
		Contact contact = new Contact();
		contact.setNumber(phoneNumberT);
		assertAll("phoneNumberTest",
			()-> assertEquals(phoneNumberT, contact.getNumber()),
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setNumber("")),    
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setNumber(longphoneNumber)),
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setNumber(shortNumber)),
	        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setNumber(contactID)));
	}
	
	@Test
	void setfullAddressTest() {
		Contact contact = new Contact();
		contact.setAddress(fullAddressT);
		assertAll("fullAddressTest",
				()-> assertEquals(fullAddressT, contact.getAddress()),
		        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setAddress(null)),    
		        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setAddress(longfullAddress)));
	}
	
	@Test
	void setContactIDTest() {
		Contact contact = new Contact();
		contact.setContactID(contactID);
		assertAll("contactIDTest",
				()-> assertEquals(contactID, contact.getContactID()),
		        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setContactID(null)),    
		        ()-> assertThrows(IllegalArgumentException.class,() -> contact.setContactID(longContactID)));
	}
}
