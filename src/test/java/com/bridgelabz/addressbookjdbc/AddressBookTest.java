package com.bridgelabz.addressbookjdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;

public class AddressBookTest {

	@Test
	public void retrieveAlltheEntriesInAddressBookTest() {
		List<AddressData> addresstest = AddressBookjdbc.retrieveAlltheEntriesInAddressBook();
		Assert.assertEquals(8, addresstest.size());
	}

	@Test
	public void updateContactInformationTest() {
		int contact = AddressBookjdbc.updateContactInformation("Sales", "Goutham", "Y");
		Assert.assertEquals(1, contact);
	}

	@Test
	public void retrieveContactFromDatabaseTest() {
		LocalDate start_date = LocalDate.of(2021, 10, 10);
		LocalDate end_date = LocalDate.of(2022, 01, 05);
		List<AddressData> dateresult = AddressBookjdbc.retrieveContactFromDatabase(start_date, end_date);
		Assert.assertEquals(3, dateresult.size());
	}

	@Test
	public void retrieveNumberOfContactsInDbByCityorStateTest() throws SQLException {
		List<AddressData> cityorstatetest = AddressBookjdbc.retrieveNumberOfContactsInDbByCityorState("kolar");
		Assert.assertEquals(1, cityorstatetest.size());
	}

}
