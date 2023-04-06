package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    List<Contact> addressBookList = new ArrayList<>();

    public void insertRecord(Connection connection) throws SQLException {
        Scanner input = new Scanner(System.in);
        String sql = "inser into address_book(addressbook_id, addressbook_name, firstName, lastName, address, city, state, zipcode, phoneNumber, email) values (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sql);
        System.out.print("Enter AddressBook Id : ");
        preparedStatement.setInt(1, input.nextInt());
        System.out.print("Enter AddressBook Name : ");
        preparedStatement.setString(2, input.nextLine());
        System.out.print("Enter First Name : ");
        preparedStatement.setString(3, input.nextLine());
        System.out.print("Enter Last Name : ");
        preparedStatement.setString(4, input.nextLine());
        System.out.print("Enter Address : ");
        preparedStatement.setString(5, input.nextLine());
        System.out.print("Enter City : ");
        preparedStatement.setString(6, input.nextLine());
        System.out.print("Enter State : ");
        preparedStatement.setString(7, input.nextLine());
        System.out.print("Enter Zipcode : ");
        preparedStatement.setInt(8, input.nextInt());
        System.out.print("Enter Phone number : ");
        preparedStatement.setLong(9, input.nextLong());
        System.out.print("Enter Email ID : ");
        preparedStatement.setString(10, input.nextLine());
        preparedStatement.executeUpdate();
    }


    public void selectRecord(Connection connection) {
        System.out.println("select method is called");
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from address_book");
            while (resultSet.next()) {
                int addressbook_id = resultSet.getInt("addressbook_id");
                String addressbook_name = resultSet.getString("addressbook_name");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zipcode = resultSet.getInt("zipcode");
                long phonenumber = resultSet.getLong("phonenumber");
                String emailId = resultSet.getString("emailId");
                addressBookList.add(new Contact(addressbook_id, addressbook_name, firstName, lastName,address , city, state, zipcode, phonenumber,emailId ));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}