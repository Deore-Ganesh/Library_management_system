package com.library.ui;

import com.library.service.LibraryService;

import java.util.Scanner;

public class Menu {
    Scanner sc =new Scanner(System.in);
    public void start() {
        while (true) {
            System.out.println("Choose the service");
            System.out.println("1. Search book");
            System.out.println("2. Issue book");
            System.out.println("3. Return book");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    LibraryService b = new LibraryService();
                    b.searchbook();
                    break;
                case 2:
                    LibraryService issue = new LibraryService();
                    issue.issuebook();
                    break;
                case 3:
                    LibraryService returnn =new LibraryService();
                    returnn.returnBook();
                    break;
                case 4:
                    System.exit(0);

        }

        }
}
}
