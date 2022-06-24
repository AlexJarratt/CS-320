//Author: Alex Jarratt
//Date: 5/21/2022
//Class: SNHU CS-320

package main;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ContactService {
	
	
	private String uniqueContactID;
	
	private String newUniqueContactID() {
		 uniqueContactID = UUID.randomUUID().toString().substring(0, Math.min(toString().length(), 10));
		 return uniqueContactID;			 
	}
	private List<Contact> contactList = new ArrayList<>();
	
	public void newContact() {
		Contact contact = new Contact(newUniqueContactID());
		contactList.add(contact);
	}
	
	public void newContact(String first_Name) {
		Contact contact = new Contact(newUniqueContactID(), first_Name);
		contactList.add(contact);
	}
	
	public void newContact(String first_Name, String last_Name) {
		Contact contact = new Contact (newUniqueContactID(), first_Name, last_Name);
		contactList.add(contact);
	}
	
	public void newContact(String first_Name, String last_Name, String phoneNumber) {
		Contact contact = new Contact(newUniqueContactID(), first_Name, last_Name, phoneNumber);
		contactList.add(contact);
	}
	
	public void newContact(String first_Name, String last_Name, String phoneNumber, String fullAddress) {
		Contact contact = new Contact(newUniqueContactID(), first_Name, last_Name, phoneNumber, fullAddress);
		contactList.add(contact);
	}
	
	public void deleteContact(String ID) throws Exception{
		contactList.remove(searchContacts(ID));
	}
	
	public void setFirstName(String ID, String first_Name) throws Exception{
		searchContacts(ID).setFirstName(first_Name);
	}
	
	public void setLastName(String ID, String last_Name) throws Exception{
		searchContacts(ID).setLastName(last_Name);
	}
	
	public void setAddress(String ID, String fullAddress) throws Exception{
		searchContacts(ID).setAddress(fullAddress);
	}
	
	public void setNumber(String ID, String phoneNumber) throws Exception{
		searchContacts(ID).setNumber(phoneNumber);
	}
	
	protected List<Contact> getContactList(){
		return contactList;
	}
	
	private Contact searchContacts(String ID) throws Exception{
		int i = 0;
		while(i< contactList.size()) {
			if(ID.equals(contactList.get(i).getContactID())) {
				return contactList.get(i);
			}
			i++;
		}
		throw new Exception("Not found.");
	}
}
