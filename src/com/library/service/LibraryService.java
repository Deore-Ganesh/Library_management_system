package com.library.service;

import java.util.Scanner;

public class LibraryService {
    public void searchbook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the book title: ");
        String title = sc.nextLine();

    }
    public void issuebook(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the book title:");
//        String bookTitle = sc.nextLine();//              code for issuing the book
    }

    public void returnBook() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the book id: ");
    }
}

