package com.javamap;

class Book {
    private int id;
    private String title;
    private String author;
    private int pages;
    private float price;

    public Book() {
    }

    public Book(int id, String title, String author, int pages, float price) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.pages = pages;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPages() {
        return pages;
    }

    public float getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return String.format("Id: %s " +
                "%n Book: %s by %s " +
                "%n Pages: %s " +
                "%n Price: %s", this.id, this.title, this.author, this.pages, this.price);
    }
}
