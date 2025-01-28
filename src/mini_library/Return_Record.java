/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_library;

/**
 *
 * @author Asus
 */
public class Return_Record {
    private int userID;
    private String name;
    private int bookID;
    private String title;
    private String borrowDate;
    private String returnDate;
    private int daysBorrowed;
    private double borrowingCharge;
    private double lateFee;
    private double totalCharge;

    // Constructor
    public Return_Record(int userID, String name, int bookID, String title, String borrowDate, String returnDate, int daysBorrowed, double borrowingCharge, double lateFee, double totalCharge) {
        this.userID = userID;
        this.name = name;
        this.bookID = bookID;
        this.title = title;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.daysBorrowed = daysBorrowed;
        this.borrowingCharge = borrowingCharge;
        this.lateFee = lateFee;
        this.totalCharge = totalCharge;
    }

    public int getUserID() {
        return userID;
    }

    public int getBookID() {
        return bookID;
    }

    public String getBorrowDate() {
        return borrowDate;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public int getDaysBorrowed() {
        return daysBorrowed;
    }

    public double getBorrowingCharge() {
        return borrowingCharge;
    }

    public double getLateFee() {
        return lateFee;
    }

    public double getTotalCharge() {
        return totalCharge;
    }
    
}
