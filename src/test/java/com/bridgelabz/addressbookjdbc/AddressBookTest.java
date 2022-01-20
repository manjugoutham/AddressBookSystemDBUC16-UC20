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
}
