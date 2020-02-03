package com.example.service;

import java.util.List;

import com.example.model.Contact;

public interface ContactService {

	public Long getContactByName(String name);

	public List<Contact> featchAllContact();
}
