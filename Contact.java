//Author: Alex Jarratt
//Date: 5/21/2022
//Class: SNHU CS-320
//Purpose: Class to create contacts

package main;

class Contact {
	
	//create the variables used in the contact class
	//If the class members declared as private then it may only be accessed by the class that defines the member.
	//If the class members declared as protected then it can be accessed only within the class itself and by inheriting and parent classes.
	
	private String contactID; //contactID shall be unique, shall not be null, not updatable
	private String first_Name; //firstName cannot be longer than 10 characters, cant be null
	private String last_Name; //lastName cannot be longer than 10 characters, cant be null
	private String phoneNumber; //number must be exactly 10 digits, cant be null
	private String fullAddress; //address must be less than 30 characters, not null
	private static final String INIT_STRING = "INITIAL";
	private static final String INIT_INT = "0123456789";
	
	//constructor
	Contact(){
		this.contactID = INIT_INT;
		this.first_Name = INIT_STRING;
		this.last_Name = INIT_STRING;
		this.phoneNumber = INIT_INT;
		this.fullAddress = INIT_STRING;
	}
	
	//Overloaded constructors with arguments setting value for each field progressively until last constructor accepts all fields
	
	Contact(String contactID){
		setContactID(contactID);
		this.first_Name = INIT_STRING;
		this.last_Name = INIT_STRING;
		this.phoneNumber = INIT_INT;
		this.fullAddress = INIT_STRING;
	}
	
	Contact(String contactID, String firstName){
		setContactID(contactID);
		setFirst_Name(first_Name);
		this.last_Name = INIT_STRING;
		this.phoneNumber = INIT_INT;
		this.fullAddress = INIT_STRING;
	}
	
	Contact(String contactID, String first_Name, String last_Name){
		setContactID(contactID);
		setFirst_Name(first_Name);
		setLast_Name(last_Name);
		this.phoneNumber = INIT_INT;
		this.fullAddress = INIT_STRING;
	}
	
	Contact(String contactID, String first_Name, String last_Name, String phoneNumber){
		setContactID(contactID);
		setFirst_Name(first_Name);
		setLast_Name(last_Name);
		setNumber(phoneNumber);
		this.fullAddress = INIT_STRING;
	}
	
	Contact(String contactID,String first_Name,String last_Name, String phoneNumber, String fullAddress){
		setFirst_Name(first_Name);
		setLast_Name(last_Name);
		setNumber(phoneNumber);
		setAddress(fullAddress);
		setContactID(contactID);
	}
	
	//getters
	protected final String getContactID() {
		return contactID;
	}
	
	protected final String getFirstName() {
		return first_Name;
	}
	
	protected final String getLastName() {
		return last_Name;
	}
	
	protected final String getNumber() {
		return phoneNumber;
	}
	
	protected final String getAddress() {
		return fullAddress;
	}
	
	//Setters that throw Exceptions for each of the attributes if they are assigned improperly
	
	//Note: If the class members declared as protected then it can be accessed only within the class itself
	//      and by inheriting and parent classes.
	
	protected void setFirstName(String first_Name) {
		if(first_Name == null) {
			throw new IllegalArgumentException("Field cannot be empty.");
		}
		else if (first_Name.length()>10) {
			throw new IllegalArgumentException("Name must be less than 10 characters.");
		}
		else {
		this.first_Name = first_Name;
		}
	}
	
	protected void setLastName(String last_Name) {
		if(last_Name == null) {
			throw new IllegalArgumentException("Field cannot be empty.");
		}
		else if(last_Name.length()>10) {
			throw new IllegalArgumentException("Name must be less than 10 characters.");
		}
		else {
			this.last_Name = last_Name;
		}
		
		
	}
	protected void setNumber(String phoneNumber) {
		String regexTest = "[0-9]+"; //https://www.geeksforgeeks.org/how-to-check-if-string-contains-only-digits-in-java/
		if(phoneNumber == null){
			throw new IllegalArgumentException("Number cannot be null.");
		}
		else if(!(phoneNumber.length()==10)) {
			throw new IllegalArgumentException("Number must have a length of 10.");
		}
		else if(!(phoneNumber.matches(regexTest))) {
			throw new IllegalArgumentException("Only numbers are allowed for phone numbers.");
		}
		else{
			this.phoneNumber = Number;
		}
	}
	
	public void setAddress(String fullAddress) {
		if(fullAddress == null){
			throw new IllegalArgumentException("Address field may not be empty.");
		}
		else if(fullAddress.length()>30) {
			throw new IllegalArgumentException("Address max length is 30.");
		}
		else {
			this.fullAddress = fullAddress;
		}
	}
	public void setContactID(String contactID) {
		if(contactID == null) {
			throw new IllegalArgumentException("ContactID cannot be null.");
		}
		else if (contactID.length()>10) {
			throw new IllegalArgumentException("ContactID must be shorter than 10 digits.");
		}
		
		else{
			this.contactID = contactID;
		}
	}
	
	
	
}
