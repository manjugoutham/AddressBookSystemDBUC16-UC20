package com.bridgelabz.addressbookjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {
	
	@Test
	public void retrieveAlltheEntriesInAddressBookTest()
	{
		List<AddressData> addresstest = AddressBookjdbc.retrieveAlltheEntriesInAddressBook();
		Assert.assertEquals(8, addresstest.size());
	}
	
	@Test 
	public void updateContactInformationTest() {
		int contact = AddressBookjdbc.updateContactInformation("Sales","Goutham","Y");
		Assert.assertEquals(1, contact);
	}
}
