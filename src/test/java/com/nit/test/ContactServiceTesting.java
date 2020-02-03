package com.nit.test;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import org.easymock.EasyMock;
import org.junit.Ignore;
import org.junit.Test;

import com.example.dao.ContactDao;
import com.example.exception.NoDataFoundException;
import com.example.model.Contact;
import com.example.service.ContactServiceImpl;

public class ContactServiceTesting {

	@Test
	public void getContactNumberByNamePositive1() {
		// creating target class object
		ContactServiceImpl service = new ContactServiceImpl();
		// createing mock object
		ContactDao daoMock = EasyMock.createMock(ContactDao.class);
		// injecting proxy dao object in target
		service.setDao(daoMock);
		// set attribute in daoMock object
		EasyMock.expect(daoMock.getContactByName("Jhon")).andReturn(9938866352l);
		// save in attribute of dao class object
		EasyMock.replay(daoMock);
		Long contactNumber = service.getContactByName("Jhon");
		assertNotNull(contactNumber);
		System.out.println(contactNumber);
	}

	@Test(expected = NoDataFoundException.class)
	public void getContactNumberByNameNagetive2() {
		// creating target class object
		ContactServiceImpl service = new ContactServiceImpl();
		// createing mock object
		ContactDao daoMock = EasyMock.createMock(ContactDao.class);
		// injecting proxy dao object in target
		service.setDao(daoMock);
		//set attribute to daoMock object
		EasyMock.expect(daoMock.getContactByName("Hari")).andReturn(null);
		// calling target calss method
		Long contactNumber = service.getContactByName("Ram");
		assertNotNull(contactNumber);
	}

	@Test
	public void findAllPasitive1() {
		ContactServiceImpl service = new ContactServiceImpl();
		ContactDao daoMock = EasyMock.createMock(ContactDao.class);
		List<Contact> contactList = new ArrayList();
		contactList.add(new Contact(101, "Ram", "Bam"));
		contactList.add(new Contact(102, "Hari", "Bbsr"));
		contactList.add(new Contact(103, "Vicky", "Bha"));
		// injecting proxy dao oobject in target
		service.setDao(daoMock);
		// set attribute to mock object
		EasyMock.expect(daoMock.getAllContact()).andReturn(contactList);
		EasyMock.replay(daoMock);
		// calling target class method
		List<Contact> allContact = service.featchAllContact();
		assertNotNull(allContact);
	}
	@Test(expected = NoDataFoundException.class)
	public void findAllNegative2() {
		ContactServiceImpl service=new ContactServiceImpl();
		ContactDao mock = EasyMock.createMock(ContactDao.class);
		List<Contact> contactList = new ArrayList<Contact>();
		contactList.add(new Contact(101, "Ram", "Bam"));
		contactList.add(new Contact(102, "Hari", "Bbsr"));
		service.setDao(mock);
		EasyMock.expect(mock.getAllContact()).andReturn(null);
		EasyMock.replay(mock);
		List<Contact> featchAllContact = service.featchAllContact();
		assertNotNull(featchAllContact);
	}
}
