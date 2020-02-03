package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.ContactDao;
import com.example.exception.NoDataFoundException;
import com.example.model.Contact;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactDao dao;

	public void setDao(ContactDao dao) {
		this.dao = dao;
	}

	public Long getContactByName(String name) {
		Long contactNo = dao.getContactByName(name);
		if (contactNo == null) {
			throw new NoDataFoundException("Invalid name");
		}
		return contactNo;
	}

	public List<Contact> featchAllContact() {
		List<Contact> allContact = dao.getAllContact();
		if (allContact==null || allContact.isEmpty()) {
			throw new NoDataFoundException("No Record Found");
		}
		return allContact;
	}

}
