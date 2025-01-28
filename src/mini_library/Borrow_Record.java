/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_library;

/**
 *
 * @author Asus
 */
class Borrow_Record {
    private int userID;
    private String name;
    private int bookID;
    private String title;
    private boolean status;
    private String borrowedDate;
    private double dailyCharge;
    private String dueDate;
    private double totalCharge;
    
    public Borrow_Record(int userID, String name, int bookID, String title, boolean status,  String borrowedDate, String dueDate, double dailyCharge, double totalCharge) {
        this.userID = userID;
        this.name = name;
        this.bookID = bookID;
        this.title = title;
        this.status = status;
        this.borrowedDate = borrowedDate;
        this.dailyCharge = dailyCharge;
        this.dueDate = dueDate;
        this.totalCharge = totalCharge;
    }

    public int getUserID() {
        return userID;
    }

    public int getBookID() {
        return bookID;
    }

    public boolean getStatus() {
        return status;
    }

    public String getName() {
        return name;
    }

    public String getTitle() {
        return title;
    }

    public String getBorrowedDate() {
        return borrowedDate;
    }

    public double getDailyCharge() {
        return dailyCharge;
    }

    public String getDueDate() {
        return dueDate;
    }

    public double getTotalCharge() {
        return totalCharge;
    }
    
}

