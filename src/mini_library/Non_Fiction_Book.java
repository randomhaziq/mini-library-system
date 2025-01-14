/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_library;

/**
 *
 * @author Asus
 */
public class Non_Fiction_Book extends Book{
    private String subject;
    
    public Non_Fiction_Book(int bookID, String title, String author, boolean isAvailable, String subject) {
        super(bookID, title, author, isAvailable);
        this.subject = subject;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    
}
