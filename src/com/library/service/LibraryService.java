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

        String sql =
                "UPDATE book SET available = 0 WHERE book_name = ? AND available = 1";

        try (Connection con = DBConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, bookName);
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Book issued successfully.");
            } else {
                System.out.println("Book not available or not found.");
            }

        } catch (SQLException e) {
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
