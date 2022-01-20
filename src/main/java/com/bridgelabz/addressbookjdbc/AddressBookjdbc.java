package com.bridgelabz.addressbookjdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AddressBookjdbc {

	static List<AddressData> list = new ArrayList<>();
	static String URL = "jdbc:mysql://localhost:3306/address_book_database?characterEncoding=utf8";
	static String USERNAME = "root";
	static String PASSWORD = "Tham12@2";

	public static List<AddressData> retrieveAlltheEntriesInAddressBook() {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!...");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connection success \n");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from address_book");

			while (rs.next())

				// System.out.println(rs.getString("firstName") + " " + rs.getString("lastName")
				// + " " + rs.getString("address") + " " +rs.getString("Department_Type") + " "
				// +rs.getString("city") + " " +rs.getString("state") + " " +
				// rs.getString("email") + " " + rs.getInt("phoneNumber")+ " " +
				// rs.getInt("zip"));
				list.add(new AddressData(rs.getString("firstName"), rs.getString("lastName"), rs.getString("address"),
						rs.getString("Department_Type"), rs.getString("city"), rs.getString("state"),
						rs.getString("email"), rs.getInt("phoneNumber"), rs.getInt("zip")));
			for (int i = 0; i < list.size(); i++) {
				System.out.println(list.get(i));
			}
			System.out.println("\nThe total size is Address book : " + list.size());
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static int updateContactInformation(String Department_Type, String firstName, String lastName) {
		String query = String.format(
				"UPDATE address_book SET Department_Type='%s' WHERE firstName='%s' and lastName='%s';", Department_Type,
				firstName, lastName);
		try {

			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded!...");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connection success");
			Statement stmt = con.createStatement();
			int rs = stmt.executeUpdate(query);
			return rs;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		// listDrivers()
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static List<AddressData> retrieveContactFromDatabase(LocalDate start_date, LocalDate end_date) {

		String query = String.format("select * FROM address_book where start_date BETWEEN '%s' AND '%s';",
				Date.valueOf(start_date), Date.valueOf(end_date));
		List<AddressData> addressdata = new ArrayList<>();
		try {

			System.out.println("Driver loaded!...");
			Connection con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			System.out.println("connection success");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next())
				list.add(new AddressData(rs.getString("firstName"), rs.getString("lastName"), rs.getString("address"),
						rs.getString("Department_Type"), rs.getString("city"), rs.getString("state"),
						rs.getString("email"), rs.getInt("phoneNumber"), rs.getInt("zip")));
			System.out.println(list.size());
			addressdata.forEach(System.out::println);
			stmt.close();
			rs.close();
			con.close();

			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;

	}
}
