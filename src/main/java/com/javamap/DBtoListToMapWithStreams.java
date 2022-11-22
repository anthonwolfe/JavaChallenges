package com.javamap;

import java.sql.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.stream.Collectors;

public class DBtoListToMapWithStreams {

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

        ArrayList<Book> list = new ArrayList<>();
        ArrayList<String> names;

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
                list.add(book);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        Map<Integer, String> bookMap = list.stream().collect(Collectors.toMap(Book::getId, Book::toString));
        System.out.println(bookMap);
    }
}