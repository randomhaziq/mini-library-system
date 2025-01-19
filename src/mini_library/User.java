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
public class User {
    private int userID;
    private String name;
    private String gender;
    private String phoneNumber;
    private String email;
    private ArrayList<Book> borrowedBookList;

    public User (int userID, String name, String gender, String phoneNumber, String email) {
        this.userID = userID;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void borrowBook(Book newBook) {
        borrowedBookList.add(newBook);
        newBook.setAvailable(false);
    }
    
}
