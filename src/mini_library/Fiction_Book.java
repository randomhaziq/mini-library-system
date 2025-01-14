/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_library;

/**
 *
 * @author Asus
 */
public class Fiction_Book extends Book{
    private String genre;
    
    public Fiction_Book(int bookID, String title, String author, boolean isAvailable, String genre) {
        super(bookID, title, author, isAvailable);
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
    
}
