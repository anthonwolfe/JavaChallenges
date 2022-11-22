package com.javamap;

import java.sql.*;
import java.util.HashMap;

public class DBtoMap {

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("URL", "user", "");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return connection;
    }


    public static void main(String[] args) {

        HashMap<Integer, Book> map = new HashMap<Integer, Book>();


        Statement statement = null;
        ResultSet resultSet = null;
        Connection connection = getConnection();
        Book book;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM books");
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");
                int pages = resultSet.getInt("pages");
                float price = resultSet.getFloat("price");
                book = new Book(id, title, author, pages, price);
                map.put(id, book);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }


        for (Integer i : map.keySet()) {
            Book books = map.get(i);
            System.out.printf("Key: " + i + "%n" +
                            "Value Set: %n " +
                            "id: %s %n %s by %s. " +
                            "%n Number of pages: %s " +
                            "%n Price: %.2f %n",
                    books.getId(), books.getTitle(), books.getAuthor(), books.getPages(), books.getPrice());
        }



    }
}