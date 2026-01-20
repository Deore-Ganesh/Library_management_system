package com.library.service;

import java.sql.*;

public class LibraryService {

    // SEARCH / CHECK BOOK
    public void searchBook(String bookName) {

        String sql =
                "SELECT book_id, available FROM book WHERE book_name = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, bookName);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int id = rs.getInt("book_id");
                boolean available = rs.getInt("available") == 1;

                System.out.println(
                        "Book ID: " + id +
                                " | Available: " + (available ? "YES" : "NO")
                );
            } else {
                System.out.println("Book not found in library.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // ISSUE BOOK
    public void issueBook(String bookName) {

        String findBook =
                "SELECT book_id FROM book WHERE book_name = ? AND available = 1";
        String insertIssue =
                "INSERT INTO issued_books (book_id) VALUES (?)";
        String updateBook =
                "UPDATE book SET available = 0 WHERE book_id = ?";

        try (Connection con = DBConnection.getConnection()) {

            con.setAutoCommit(false); // start transaction

            PreparedStatement ps1 = con.prepareStatement(findBook);
            ps1.setString(1, bookName);
            ResultSet rs = ps1.executeQuery();

            if (!rs.next()) {
                System.out.println("Book not available or already issued.");
                return;
            }

            int bookId = rs.getInt("book_id");

            PreparedStatement ps2 = con.prepareStatement(insertIssue);
            ps2.setInt(1, bookId);
            ps2.executeUpdate();

            PreparedStatement ps3 = con.prepareStatement(updateBook);
            ps3.setInt(1, bookId);
            ps3.executeUpdate();

            con.commit();
            System.out.println("Book issued successfully. Book ID: " + bookId);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // RETURN BOOK
    public void returnBook(int bookId) {

        String sql =
                "UPDATE book SET available = 1 WHERE book_id = ?";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bookId);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book returned successfully.");
            } else {
                System.out.println("Invalid book ID.");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
