/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_library;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Database_Connectivity {

    private static final String URL = "jdbc:mysql://localhost:3306/librarydb";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";
    private static ArrayList<User> userList = new ArrayList<>();

    public static Connection databaseConnect() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
            JOptionPane.showMessageDialog(null, "Loading...");

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable to connect to the database.");
        }
        return connect;
    }

    //METHODS FOR USER RECORDS
    //addrecord inside database
    public static void addRecordUser(User user) throws SQLException {
        Connection connection = databaseConnect();

        String sql = "INSERT  INTO USERS(borrowerID, name, gender, phoneNumber, email) "
                + "values (?,?,?,?,?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, user.getUserID());
        statement.setString(2, user.getName());
        statement.setString(3, user.getGender());
        statement.setString(4, user.getPhoneNumber());
        statement.setString(5, user.getEmail());

        int count = statement.executeUpdate();
        System.out.println("The number of inserted user = " + count);
        statement.close();
        connection.close();
    }

    //edit database record
    public static int editRecordUser(User user) throws SQLException {

        Connection connection = databaseConnect();
        String sql = "UPDATE USERS "
                + "SET name = ?, gender = ?, phoneNumber = ?, email = ?"
                + "WHERE borrowerID = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, user.getName());
        stmt.setString(2, user.getGender());
        stmt.setString(3, user.getPhoneNumber());
        stmt.setString(4, user.getEmail());
        stmt.setInt(5, user.getUserID());

        int row = stmt.executeUpdate();

        System.out.println("Rows affected = " + row);

        stmt.close();
        connection.close();
        return row;
    }

    public static ArrayList<User> searchRecordUser(String token) throws SQLException {
        Connection connection = databaseConnect();

        String sql = "SELECT * FROM USERS "
                + "WHERE borrowerID = ? OR name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, token);
        statement.setString(2, token);

        ResultSet resultSet = statement.executeQuery();
        ArrayList<User> searchResults = new ArrayList<>();

        while (resultSet.next()) {
            int userID = resultSet.getInt("borrowerID");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            String phoneNo = resultSet.getString("phoneNumber");
            String email = resultSet.getString("email");

            searchResults.add(new User(userID, name, gender, phoneNo, email));
        }

        resultSet.close();
        statement.close();
        connection.close();
        return searchResults;
    }

    //function button for display all information
    public static ArrayList<User> displayAllRecordUser() throws SQLException {
        Connection connection = databaseConnect();
        String sql = "SELECT * FROM USERS"; // Query to fetch all users
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();
        ArrayList<User> userList = new ArrayList<>();

        // Iterate through the result set and create User objects
        while (resultSet.next()) {
            int userID = resultSet.getInt("borrowerID");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            String phoneNo = resultSet.getString("phoneNumber");
            String email = resultSet.getString("email");

            userList.add(new User(userID, name, gender, phoneNo, email));
        }

        // Close resources
        resultSet.close();
        statement.close();
        connection.close();

        return userList;
    }

    public static ArrayList<User> deleteRecordUser(String token) throws SQLException {
        Connection connection = databaseConnect();
        String sql = "DELETE FROM USERS WHERE borrowerID = ? OR name = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, token);
        stmt.setString(2, token);

        int rowDeleted = stmt.executeUpdate();
        if (rowDeleted > 0) {
            // Remove the user from the userList
            userList.removeIf(user -> user.getUserID() == Integer.parseInt(token) || user.getName().equals(token));
        }

        stmt.close();
        connection.close();
        return userList;
    }

    //METHODS FOR BOOK RECORDS
    public static void addRecordBook(Book book) throws SQLException {
        Connection connection = databaseConnect();

        String sql = null;

        if (book.getCategory().equalsIgnoreCase("Fiction")) {
            sql = "INSERT INTO BOOKS(bookID, title, author, publisher, category, genre, subject, availability) "
                    + "values (?, ?, ?, ?, ?, ?, 'Not Applicable', ?)";

        } else {
            sql = "INSERT INTO BOOKS(bookID, title, author, publisher, category, genre, subject, availability) "
                    + "values (?, ?, ?, ?, ?, 'Not Applicable', ?, ?)";

        }

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, book.getBookID());
        statement.setString(2, book.getTitle());
        statement.setString(3, book.getAuthor());
        statement.setString(4, book.getPublisher());
        statement.setString(5, book.getCategory());

        if (book.getCategory().equalsIgnoreCase("Fiction")) {
            Fiction_Book fb = (Fiction_Book) book;
            statement.setString(6, fb.getGenre());

        } else {
            Non_Fiction_Book nfb = (Non_Fiction_Book) book;
            statement.setString(7, nfb.getSubject());

        }

        int count = statement.executeUpdate();
        System.out.println("The number of inserted user = " + count);
        statement.close();
        connection.close();
    }

    //edit database record
    public static int editRecordBook(Book book) throws SQLException {

        Connection connection = databaseConnect();
        String sql = "UPDATE BOOKS "
                + "SET title = ?, author = ?, publisher= ?, category = ?, genre= ?, subject= ?, availability= ?"
                + "WHERE bookID = ?";

        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, book.getTitle());
        stmt.setString(2, book.getAuthor());
        stmt.setString(3, book.getPublisher());
        stmt.setString(4, book.getCategory());
        stmt.setBoolean(7, book.isAvailable());
        stmt.setInt(8, book.getBookID());
        
        if (book.getCategory() != null) {
            if (book.getCategory().equalsIgnoreCase("Fiction")) {
                Fiction_Book fb = (Fiction_Book) book;
                stmt.setString(5, fb.getGenre());
                stmt.setString(6, "Not Applicable");

            } else {
                Non_Fiction_Book nfb = (Non_Fiction_Book) book;
                stmt.setString(5, "Not Applicable");
                stmt.setString(6, nfb.getSubject());

            }
        }
        int row = stmt.executeUpdate();

        System.out.println("Rows affected = " + row);

        stmt.close();
        connection.close();
        return row;
    }

    public static ArrayList<User> searchRecordBook(String token) throws SQLException {
        Connection connection = databaseConnect();

        String sql = "SELECT * FROM BOOKS "
                + "WHERE borrowerID = ? OR name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, token);
        statement.setString(2, token);

        ResultSet resultSet = statement.executeQuery();
        ArrayList<User> searchResults = new ArrayList<>();

        while (resultSet.next()) {
            int userID = resultSet.getInt("borrowerID");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            String phoneNo = resultSet.getString("phoneNumber");
            String email = resultSet.getString("email");

            searchResults.add(new User(userID, name, gender, phoneNo, email));
        }

        resultSet.close();
        statement.close();
        connection.close();
        return searchResults;
    }

    //function button for display all information
    public static ArrayList<Book> displayAllRecordBook() throws SQLException {
        Connection connection = databaseConnect();
        String sql = "SELECT * FROM BOOKS"; // Query to fetch all users
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();
        ArrayList<Book> bookList = new ArrayList<>();

        // Iterate through the result set and create User objects
        while (resultSet.next()) {
            int userID = resultSet.getInt("borrowerID");
            String name = resultSet.getString("name");
            String gender = resultSet.getString("gender");
            String phoneNo = resultSet.getString("phoneNumber");
            String email = resultSet.getString("email");

            userList.add(new User(userID, name, gender, phoneNo, email));
        }

        // Close resources
        resultSet.close();
        statement.close();
        connection.close();

        return bookList;
    }

    public static ArrayList<User> deleteRecordBook(String token) throws SQLException {
        Connection connection = databaseConnect();
        String sql = "DELETE FROM USERS WHERE borrowerID = ? OR name = ?";
        PreparedStatement stmt = connection.prepareStatement(sql);

        stmt.setString(1, token);
        stmt.setString(2, token);

        int rowDeleted = stmt.executeUpdate();
        if (rowDeleted > 0) {
            // Remove the user from the userList
            userList.removeIf(user -> user.getUserID() == Integer.parseInt(token) || user.getName().equals(token));
        }

        stmt.close();
        connection.close();
        return userList;
    }
}
