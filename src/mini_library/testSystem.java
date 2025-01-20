/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mini_library;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Asus
 */
public class testSystem {

    public static void main(String[] args) throws IOException {
        System.out.println(System.getProperty("java.version"));
        File file = new File("C:\\Users\\Asus\\Documents\\NetBeansProjects\\Mini_Library\\testSystemFile.txt");
        FileWriter fw = new FileWriter(file);
        PrintWriter writer = new PrintWriter(fw);

        FileReader fr = new FileReader(file);
        BufferedReader reader = new BufferedReader(fr);

        //write option to file
        writer.println(4);
        writer.close();

        Scanner scan = new Scanner(reader);
        while (true) {
            int choice = displayMenu(scan);
            System.out.println(choice);
            
            if (choice == 4) {
                System.out.println("Bye");
                System.exit(0);
            } else if (choice == 3) {

            } else if (choice == 2) {

            } else if (choice == 1) {

            } else {
                System.out.println("Enter a valid choice");
                return;
            }
        scan.close();
        }
    }
    public static void addBorrower() {
        System.out.println("--add borrower---");
        System.out.print("Enter book id: ");
        System.out.print("Enter name: ");
        System.out.print("Enter age: ");
        System.out.print("Choice: ");
    }
    
    public static void addBook () {
        System.out.println("--add book---");
        System.out.print("Enter book id: ");
        System.out.print("Enter title: ");
        System.out.print("Enter author: ");
        System.out.print("Choice: ");
    }

    public static int displayMenu(Scanner scan) {
        System.out.println("---Main Menu---");
        System.out.println("1. Add Book");
        System.out.println("2. Add Borrower");
        System.out.println("3. Return/ Borrow Book");
        System.out.println("4. Exit");
        System.out.print("Choice: ");
        return scan.nextInt();

    }
}
