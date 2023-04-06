package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class AddressBookMain {

    public static final int INSERT = 1;
    public static final int SELECT = 2;
    public static final int UPDATE = 3;
    private static final int COUNT = 4;
    private static final int EXIT = 5;

    public static void main(String[] args) {
        AddressBook addressBook = new AddressBook();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver found");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/addressbook", "root", "mokshit@2019");
            System.out.println("this is connected");
            Scanner input = new Scanner(System.in);
            int option = 0;
            while (option != 3) {
                System.out.println("Options are : ");
                System.out.print("1.Insert\t");
                System.out.print("2.Select\t");
                System.out.print("3.Update\t");
                System.out.print("4.Count\t");
                System.out.print("5.Exit");
                System.out.println("Enter an option from above :- ");
                option = input.nextInt();

                switch (option) {
                    case INSERT:
                        addressBook.insertRecord(connection);
                        break;
                    case SELECT:
                        addressBook.selectRecord(connection);
                        break;
                    case UPDATE:
                        addressBook.updateRecord(connection);
                        break;
                    case COUNT:
                        addressBook.countContact(connection);
                        break;
                    case EXIT:
                        break;
                }
            }

        } catch (ClassNotFoundException e) {
            System.out.println("class is not found please check");
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

}