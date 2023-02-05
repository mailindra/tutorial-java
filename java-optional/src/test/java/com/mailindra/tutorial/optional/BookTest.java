package com.mailindra.tutorial.optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    @Test
    void givenBook_checkConditionNullBook_success(){
        Book book = Book.createNullBook();
        if(book != null){
            System.out.println(book);
        }else{
            System.out.println("Book is null");
        }

    }

    @Test
    void givenOptional_checkConditionNullBook_success(){
        Optional<Book> bookOptional = Optional.empty();
        bookOptional.ifPresentOrElse(
                System.out::println,
                () -> System.out.println("Book is not exit"));

        }


    @Test
    void givenBook_checkAuthorNullBook_throwException(){
        Book book = new Book("Unknown Story", null, 2078);
        NullPointerException npe = Assertions.assertThrows(NullPointerException.class,
                () -> System.out.println(book.getAuthor().toUpperCase()),
                "NullPointerException is expected");

        assertEquals("Cannot invoke \"String.toUpperCase()\" because the return value of \"com.mailindra.tutorial.optional.Book.getAuthor()\" is null",
                npe.getLocalizedMessage());


    }


    @Test
    void givenBook_convertAuthor_success(){
        Book book = new Book("Spammer", "Ronny Mailindra", 2016);
        String authorUpperCase;
        if(book != null ){
            if(book.getAuthor() != null) {
                authorUpperCase = book.getAuthor().toUpperCase();
            }else{
                authorUpperCase ="Author is null";
            }
        }else{
            authorUpperCase = "Book is null";
        }

        assertEquals("RONNY MAILINDRA",authorUpperCase);

    }

    @Test
    void givenOptional_emptyAuthor_success(){
        Book book = new Book("Spammer", null, 2016);
        Optional<Book> bookOptional = Optional.ofNullable(book);
        String authorUpperCase = bookOptional
                .map(aBook -> Optional.ofNullable(aBook.getAuthor()))
                .flatMap(author -> author.or(()-> Optional.of("Author is empty")))
                .map(String::toUpperCase)
                .orElse("Book is empty");

        assertEquals("AUTHOR IS EMPTY", authorUpperCase);

    }

    @Test
    void givenOptional_ConvetAuthor_success(){
        Book book = new Book("Spammer", "Ronny Mailindra", 2016);
        Optional<Book> bookOptional = Optional.ofNullable(book);
        String authorUpperCase = bookOptional
                .map(aBook -> Optional.ofNullable(aBook.getAuthor()))
                .flatMap(author -> author.or(()-> Optional.of("Author is empty")))
                .map(String::toUpperCase)
                .orElse("Book is empty");

        assertEquals("RONNY MAILINDRA", authorUpperCase);

    }


}