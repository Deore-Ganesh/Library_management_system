package com.library.ui;

import com.library.service.LibraryService;
import java.util.Scanner;

public class Menu {

    private final Scanner sc = new Scanner(System.in);
    private final LibraryService service = new LibraryService();

    public void start() {
        while (true) {
            System.out.println("\nChoose the service");
            System.out.println("1. Search book");
            System.out.println("2. Issue book");
            System.out.println("3. Return book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter book name: ");
                    String searchName = sc.nextLine();
                    service.searchBook(searchName);
                    break;

                case 2:
                    System.out.print("Enter book name: ");
                    String issueName = sc.nextLine();
                    service.issueBook(issueName);
                    break;

                case 3:
                    System.out.print("Enter book ID: ");
                    int bookId = sc.nextInt();
                    sc.nextLine();
                    service.returnBook(bookId);
                    break;

                case 4:
                    System.out.println("Exiting system. Goodbye.");
                    System.exit(0);

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
