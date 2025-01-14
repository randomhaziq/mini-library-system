/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_library;

import java.util.ArrayList;

/**
 *
 * @author Asus
 */
public class Borrower {
    private int borrowerID;
    private String name;
    private ArrayList<Book> borrowedBookList;

    public Borrower(int borrowerID, String name, ArrayList<Book> borrowedBookList) {
        this.borrowerID = borrowerID;
        this.name = name;
        this.borrowedBookList = borrowedBookList;
    }

    public ArrayList<Book> getBorrowedBookList() {
        return borrowedBookList;
    }

    public void setBorrowedBookList(ArrayList<Book> borrowedBookList) {
        this.borrowedBookList = borrowedBookList;
    }

    public int getBorrowerID() {
        return borrowerID;
    }

    public void setBorrowerID(int borrowerID) {
        this.borrowerID = borrowerID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
