package com.library.model;

public class Book {
    private final int bookid;
    private final String bookname;
    private boolean available;

    Book(int bookid, String bookname, boolean available) {
        this.bookid = bookid;
        this.bookname = bookname;
        this.available = available;
    }

    public int getBookid() {
        if (bookid>0){
            return bookid;
        }
        else {
            System.out.println("Invalid com.library.model.Book ID");
        }

        return 0;
    }

    public String getBookname() {
        return bookname;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
