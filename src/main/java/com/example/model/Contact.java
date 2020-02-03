package com.example.model;

public class Contact {

	private Integer contactId;
	private String contactName;
	private String contactAddress;

	public Contact() {
		System.out.println("Contact.Contact()");
	}

	public Contact(Integer contactId, String contactName, String contactAddress) {
		this.contactId = contactId;
		this.contactName = contactName;
		this.contactAddress = contactAddress;
	}

	public Integer getContactId() {
		return contactId;
	}

	public void setContactId(Integer contactId) {
		this.contactId = contactId;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	@Override
	public String toString() {
		return "Contact [contactId=" + contactId + ", contactName=" + contactName + ", contactAddress=" + contactAddress
				+ "]";
	}

	
}