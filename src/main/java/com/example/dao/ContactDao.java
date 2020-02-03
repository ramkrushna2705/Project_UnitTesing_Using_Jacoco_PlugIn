package com.example.dao;

import java.util.List;

import com.example.model.Contact;

public interface ContactDao {

	public Long getContactByName(String name);

	public List<Contact> getAllContact();
}
