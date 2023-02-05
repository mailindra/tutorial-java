package com.mailindra.tutorial.optional;

import java.util.Optional;

public class Book {
    private final String title;
    private final String author;
    private final int publishedYear;

    public Book(String title, String author, int publishedYear) {
        this.title = title;
        this.author = author;
        this.publishedYear = publishedYear;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getPublishedYear() {
        return publishedYear;
    }

    public static Book createNullBook(){
        return null;
    }

    public static Optional<Book> createEmptyOptionalBook(){
        return Optional.empty();
    }

    public static Optional<Book> createOptionalBook(){
        return Optional.of(new Book("The Bourne Ultimatum", "Robert Ludlum", 1990));
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", publishedYear=" + publishedYear +
                '}';
    }
}
