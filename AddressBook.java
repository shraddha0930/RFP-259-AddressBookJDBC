package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
    List<Contact> addressBookList = new ArrayList<>();

    public void insertRecord(Connection connection) throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Contact to be saved: ");
        int noOfContacts = input.nextInt();
        for (int j = 0; j < noOfContacts; j++) {
            String sql = "insert into address_book(addressbook_id, addressbook_name, firstName, lastName, address, city, state, zipcode, phonenumber, emailId) values (?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            System.out.print("Enter AddressBook Id : ");
            preparedStatement.setInt(1, input.nextInt());
            System.out.print("Enter AddressBook Name : ");
            preparedStatement.setString(2, input.next());
            System.out.print("Enter First Name : ");
            preparedStatement.setString(3, input.next());
            System.out.print("Enter Last Name : ");
            preparedStatement.setString(4, input.next());
            System.out.print("Enter Address : ");
            preparedStatement.setString(5, input.next());
            System.out.print("Enter City : ");
            preparedStatement.setString(6, input.next());
            System.out.print("Enter State : ");
            preparedStatement.setString(7, input.next());
            System.out.print("Enter Zipcode : ");
            preparedStatement.setInt(8, input.nextInt());
            System.out.print("Enter Phone number : ");
            preparedStatement.setLong(9, input.nextLong());
            System.out.print("Enter Email ID : ");
            preparedStatement.setString(10, input.next());
            preparedStatement.executeUpdate();
        }
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
                addressBookList.add(new Contact(addressbook_id, addressbook_name, firstName, lastName, address, city, state, zipcode, phonenumber, emailId));
            }
            System.out.println(addressBookList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateRecord(Connection connection) throws SQLException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter addressbook id to update record");
        int addressbook_id = Integer.parseInt(sc.nextLine());
        String sql = "select * from address_book where addressbook_id = " +addressbook_id;
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(sql);
        if (resultSet.next()) {
            System.out.println("What do you want to update?");
            System.out.println("1.firstName");
            System.out.println("2.lastName");
            System.out.println("3.address");
            System.out.println("4.city");
            System.out.println("5.state");
            System.out.println("6.zipcode");
            System.out.println("7.phonenumber");
            System.out.println("8.emailId");
            int choice = Integer.parseInt(sc.nextLine());
            String sqlQuery = "update address_book set ";

            switch (choice) {
                case 1:
                    System.out.println("Enter new FirstName ");
                    String newFirstname = sc.next();
                    sqlQuery = sqlQuery + "firstname = ? where addressbook_id = " + addressbook_id;
                    PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
                    preparedStatement.setString(1, String.valueOf(newFirstname));
                    preparedStatement.executeUpdate();
                    break;
                case 2:
                    System.out.println("Enter new LastName ");
                    String newLastname = sc.next();
                    sqlQuery = sqlQuery + "lastname = ? where addressbook_id = " + addressbook_id;
                    PreparedStatement preparedStatement1 = connection.prepareStatement(sqlQuery);
                    preparedStatement1.setString(1, String.valueOf(newLastname));
                    preparedStatement1.executeUpdate();
                    break;
                case 3:
                    System.out.println("Enter new Address ");
                    String newAddress = sc.next();
                    sqlQuery = sqlQuery + "address = ? where addressbook_id = " + addressbook_id;
                    PreparedStatement preparedStatement2 = connection.prepareStatement(sqlQuery);
                    preparedStatement2.setString(1, String.valueOf(newAddress));
                    preparedStatement2.executeUpdate();
                    break;
                case 4:
                    System.out.println("Enter new City ");
                    String newCity = sc.next();
                    sqlQuery = sqlQuery + "city = ? where addressbook_id = " + addressbook_id;
                    PreparedStatement preparedStatement3 = connection.prepareStatement(sqlQuery);
                    preparedStatement3.setString(1, String.valueOf(newCity));
                    preparedStatement3.executeUpdate();
                    break;
                case 5:
                    System.out.println("Enter new State ");
                    String newState = sc.next();
                    sqlQuery = sqlQuery + "state = ? where addressbook_id = " + addressbook_id;
                    PreparedStatement preparedStatement4 = connection.prepareStatement(sqlQuery);
                    preparedStatement4.setString(1, String.valueOf(newState));
                    preparedStatement4.executeUpdate();
                    break;
                case 6:
                    System.out.println("Enter new Zipcode ");
                    int newZipcode = sc.nextInt();
                    sqlQuery = sqlQuery + "zipcode = ? where addressbook_id = " + addressbook_id;
                    PreparedStatement preparedStatement5 = connection.prepareStatement(sqlQuery);
                    preparedStatement5.setString(1, String.valueOf(newZipcode));
                    preparedStatement5.executeUpdate();
                    break;
                case 7:
                    System.out.println("Enter new Phonenumber ");
                    long newnumber = sc.nextLong();
                    sqlQuery = sqlQuery + "phonenumber = ? where addressbook_id = " + addressbook_id;
                    PreparedStatement preparedStatement6 = connection.prepareStatement(sqlQuery);
                    preparedStatement6.setString(1, String.valueOf(newnumber));
                    preparedStatement6.executeUpdate();
                    break;
                case 8:
                    System.out.println("Enter new Email ");
                    String newEmail = sc.next();
                    sqlQuery = sqlQuery + "emailID = ? where addressbook_id = " + addressbook_id;
                    PreparedStatement preparedStatement7 = connection.prepareStatement(sqlQuery);
                    preparedStatement7.setString(1, String.valueOf(newEmail));
                    preparedStatement7.executeUpdate();
                    break;
            }

        }
    }
}