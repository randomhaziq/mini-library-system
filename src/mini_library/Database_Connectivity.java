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
import java.util.function.Predicate;
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
    private static ArrayList<Book> bookList = new ArrayList<>();

    public static Connection databaseConnect() {
        Connection connect = null;
        try {
            connect = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Unable to connect to the database.");
        }
        return connect;
    }

    //METHODS FOR RETURN
    public static ArrayList<Return_Record> displayAllRecordReturn() throws SQLException {
        Connection connection = databaseConnect();
        String sql = "SELECT *  FROM return_record ";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();
        ArrayList<Return_Record> returnList = new ArrayList<>();

        // Iterate through the result set and create User objects
        while (resultSet.next()) {
            int userID = resultSet.getInt("userID");
            String name = resultSet.getString("name");
            int bookID = resultSet.getInt("bookID");
            String title = resultSet.getString("title");
            String borrowedDate = resultSet.getString("borrowedDate");
            String returnedDate = resultSet.getString("returnedDate");
            int daysBorrowed = resultSet.getInt("daysBorrowed");
            double borrowingCharge = resultSet.getDouble("borrowingCharge");
            double lateFee = resultSet.getDouble("lateFee");
            double totalCharge = resultSet.getDouble("totalCharge");

            returnList.add(new Return_Record(userID, name, bookID, title, borrowedDate, returnedDate, daysBorrowed, borrowingCharge, lateFee, totalCharge));
        }

        // Close resources
        resultSet.close();
        statement.close();
        connection.close();

        return returnList;
    }

    public static boolean isCurrentlyBorrowed(int userID, int bookID) throws SQLException {
        Connection connection = databaseConnect();
        String sql = "SELECT COUNT(*) FROM borrow_record WHERE userID = ? AND bookID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, userID);
        statement.setInt(2, bookID);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            int count = resultSet.getInt(1);
            return count > 0; // Return true if the user has borrowed the book
        }

        resultSet.close();
        statement.close();
        connection.close();
        
        return false; // Return false if no record is found
    }

    public static void insertReturnRecord(int userID, String name, int bookID, String title, String borrowDate, String returnDate, int daysBorrowed, double borrowingCharge, double lateFee, double totalCharge) throws SQLException {
        // Query to insert a new return record
        String sql = "INSERT INTO return_record (userID, name, bookID, title, borrowedDate, returnedDate, daysBorrowed, borrowingCharge, lateFee, totalCharge) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        Connection connection = databaseConnect();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, userID);
        statement.setString(2, name);
        statement.setInt(3, bookID);
        statement.setString(4, title);
        statement.setString(5, borrowDate);
        statement.setString(6, returnDate);
        statement.setInt(7, daysBorrowed);
        statement.setDouble(8, borrowingCharge);
        statement.setDouble(9, lateFee);
        statement.setDouble(10, totalCharge);
        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    //METHODS FOR BORROW
    public static boolean isEligibleToBorrow(int userID, int bookID) throws SQLException {
        // Check if the book is available
        Predicate<Book> checkBook = book -> book.getBookID() == bookID && book.isAvailable();
        ArrayList<Book> bookList = Database_Connectivity.searchBy(checkBook);

        if (bookList.isEmpty()) {
            JOptionPane.showMessageDialog(null, "The book is not available.");
            return false;
        }

        // Check if the user has exceeded the borrowing limit (e.g., 5 books)
        int borrowedCount = Database_Connectivity.getBorrowedCount(userID);
        if (borrowedCount >= 5) {
            JOptionPane.showMessageDialog(null, "You have exceeded the borrowing limit.");
            return false;
        }

        return true;
    }

    public static int getBorrowedCount(int userID) throws SQLException {
        // Query to get the number of books borrowed by the user
        Connection connection = databaseConnect();
        String sql = "SELECT borrowedCount FROM users WHERE userID = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, userID);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getInt("BorrowedCount");
        }

        resultSet.close();
        statement.close();
        connection.close();
        
        return 0;
    }

    public static ArrayList<Borrow_Record> displayAllRecordBorrow() throws SQLException {
        Connection connection = databaseConnect();
        String sql = "SELECT *  FROM Borrow_record ";
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();
        ArrayList<Borrow_Record> borrowList = new ArrayList<>();

        // Iterate through the result set and create User objects
        while (resultSet.next()) {
            int userID = resultSet.getInt("userID");
            String name = resultSet.getString("name");
            int bookID = resultSet.getInt("bookID");
            String title = resultSet.getString("title");
            boolean isAvailable = resultSet.getBoolean("isAvailable");
            String borrowedDate = resultSet.getString("borrowedDate");
            String dueDate = resultSet.getString("dueDate");
            double dailyCharge = resultSet.getDouble("dailyCharge");
            double totalCharge = resultSet.getDouble("totalCharge");

            borrowList.add(new Borrow_Record(userID, name, bookID, title, isAvailable, borrowedDate, dueDate, dailyCharge, totalCharge));
        }

        // Close resources
        resultSet.close();
        statement.close();
        connection.close();

        return borrowList;
    }

    public static void insertBorrowRecord(int userID, String name, int bookID, String title, boolean isAvailable, String borrowDate, String dueDate, double dailyCharge, double totalCharge) throws SQLException {
        // Query to insert a new borrowing record
        Connection connection = databaseConnect();
        String sql = "INSERT INTO borrow_record (userID, name, bookID, title, isAvailable, borrowedDate, dueDate, dailyCharge, totalCharge) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, userID);
        statement.setString(2, name);
        statement.setInt(3, bookID);
        statement.setString(4, title);
        statement.setBoolean(5, isAvailable);
        statement.setString(6, borrowDate);
        statement.setString(7, dueDate);
        statement.setDouble(8, dailyCharge);
        statement.setDouble(9, totalCharge);
        statement.executeUpdate();

        statement.close();
        connection.close();
    }

    public static void updateUserBorrowedCount(int borrowCount, int userID) throws SQLException {
        String sql = "Update users set borrowedCount = ? Where userID = ?";
        Connection connection = databaseConnect();

        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, borrowCount);
        statement.setInt(2, userID);

        statement.executeUpdate();

        connection.close();
        statement.close();
    }

    public static String getBorrowDate(int userID, int bookID) throws SQLException {
        Connection connection = databaseConnect();
        String sql = "SELECT borrowedDate FROM BORROW_RECORD WHERE userID = ? and bookID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, userID);
        statement.setInt(2, bookID);

        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return resultSet.getString("borrowedDate");
        }
        
        resultSet.close();
        statement.close();
        connection.close();
        
        return null;
    }

    public static void updateBookAvailability(int bookID, boolean isAvailable) throws SQLException {
        // Query to update the book's availability status
        Connection connection = databaseConnect();
        String sql = "UPDATE books SET isAvailable = ? WHERE bookID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setBoolean(1, isAvailable);
        statement.setInt(2, bookID);
        statement.executeUpdate();

    }

    //METHODS FOR USER RECORDS
    //addrecord inside database
    public static void addRecordUser(User user) throws SQLException {
        Connection connection = databaseConnect();

        String sql = "INSERT  INTO USERS(userID, name, gender, phoneNumber, email) "
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
                + "WHERE userID = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, user.getName());
        statement.setString(2, user.getGender());
        statement.setString(3, user.getPhoneNumber());
        statement.setString(4, user.getEmail());
        statement.setInt(5, user.getUserID());

        int row = statement.executeUpdate();

        System.out.println("Rows affected = " + row);

        statement.close();
        connection.close();
        return row;
    }

    public static ArrayList<User> searchRecordUser(String token) throws SQLException {
        Connection connection = databaseConnect();

        String sql = "SELECT * FROM USERS "
                + "WHERE userID = ? OR name = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, token);
        statement.setString(2, token);

        ResultSet resultSet = statement.executeQuery();
        ArrayList<User> searchResults = new ArrayList<>();

        while (resultSet.next()) {
            int userID = resultSet.getInt("userID");
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
            int userID = resultSet.getInt("userID");
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

    public static ArrayList<User> deleteRecordUser(int userID) throws SQLException {
        Connection connection = databaseConnect();
        String sql = "DELETE FROM USERS WHERE userID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, userID);

        int rowDeleted = statement.executeUpdate();
        if (rowDeleted > 0) {
            // Remove the user from the userList
            for (User user : userList) {
                if (user.getUserID() == userID) {
                    userList.remove(user);
                }
            }
        }

        statement.close();
        connection.close();
        return userList;
    }

    //METHODS FOR BOOK RECORDS
    public static void addRecordBook(Book book, String genre_subject) throws SQLException {
        Connection connection = databaseConnect();

        String sql = "INSERT INTO Books (BookID, Title, Author, Publisher, Category, Genre, Subject) VALUES (?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, book.getBookID());
        statement.setString(2, book.getTitle());
        statement.setString(3, book.getAuthor());
        statement.setString(4, book.getPublisher());
        statement.setString(5, book.getCategory());
        statement.setString(6, book.getCategory().equals("Fiction") ? genre_subject : "NotApplicable");
        statement.setString(7, book.getCategory().equals("Non-fiction") ? genre_subject : "NotApplicable");

        int count = statement.executeUpdate();
        System.out.println("The number of inserted book = " + count);
        statement.close();
        connection.close();
    }

    //edit database record
    public static int editRecordBook(Book book, String genre_subject) throws SQLException {
        Connection connection = databaseConnect();
        String sql = "UPDATE BOOKS "
                + "SET Title = ?, Author = ?, Publisher= ?, Category = ?, Genre= ?, Subject= ?, isAvailable = ? "
                + "WHERE BookID = ?";

        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setString(1, book.getTitle());
        statement.setString(2, book.getAuthor());
        statement.setString(3, book.getPublisher());
        statement.setString(4, book.getCategory());
        if (book.getCategory().equalsIgnoreCase("Fiction")) {
            statement.setString(5, genre_subject);
            statement.setString(6, "Not Applicable");

        } else {
            statement.setString(5, "Not Applicable");
            statement.setString(6, genre_subject);
        }
        statement.setBoolean(7, book.isAvailable());
        statement.setInt(8, book.getBookID());

        int row = statement.executeUpdate();

        System.out.println("Rows affected = " + row);

        statement.close();
        connection.close();
        return row;
    }

    public static ArrayList<Book> searchBy(Predicate<Book> searchToken) throws SQLException {
        Connection connection = databaseConnect();
        String sql = "SELECT * FROM BOOKS"; // Fetch all books from the database
        PreparedStatement statement = connection.prepareStatement(sql);

        ResultSet resultSet = statement.executeQuery();
        ArrayList<Book> searchResults = new ArrayList<>();

        while (resultSet.next()) {
            int bookID = resultSet.getInt("bookID");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String publisher = resultSet.getString("publisher");
            String category = resultSet.getString("category");
            String genre = resultSet.getString("genre");
            String subject = resultSet.getString("subject");
            boolean availability = resultSet.getBoolean("isAvailable");

            // Create a Book object based on the category
            Book book;
            if (category.equalsIgnoreCase("Fiction")) {
                book = new Fiction_Book(bookID, title, author, publisher, category, genre);
            } else {
                book = new Non_Fiction_Book(bookID, title, author, publisher, category, subject);
            }
            book.setAvailable(availability);

            // Apply the condition (lambda function) to filter books
            if (searchToken.test(book)) {
                searchResults.add(book);
            }
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
            int bookID = resultSet.getInt("bookID");
            String title = resultSet.getString("title");
            String author = resultSet.getString("author");
            String publisher = resultSet.getString("publisher");
            String category = resultSet.getString("category");
            String genre = resultSet.getString("genre");
            String subject = resultSet.getString("subject");
            boolean availability = resultSet.getBoolean("isAvailable");

            Book book;
            if (category.equalsIgnoreCase("Fiction")) {
                book = new Fiction_Book(bookID, title, author, publisher, category, genre);
            } else {
                book = new Non_Fiction_Book(bookID, title, author, publisher, category, subject);
            }
            bookList.add(book);
        }

        // Close resources
        resultSet.close();
        statement.close();
        connection.close();

        return bookList;
    }

    public static ArrayList<Book> deleteRecordBook(int bookID) throws SQLException {
        Connection connection = databaseConnect();
        String sql = "DELETE FROM BOOKS WHERE bookID = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        statement.setInt(1, bookID);

        int rowDeleted = statement.executeUpdate();
        if (rowDeleted > 0) {
            // Remove the user from the userList
            for (Book book : bookList) {
                if (book.getBookID() == bookID) {
                    bookList.remove(book);
                }
            }
        }

        statement.close();
        connection.close();
        return bookList;
    }
}
