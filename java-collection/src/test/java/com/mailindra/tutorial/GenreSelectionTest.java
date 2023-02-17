package com.mailindra.tutorial;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class GenreSelectionTest {

    @Test
    void testGenreSelectionForLoop(){
        List<String> genres = List.of("Detective", "Who dunnit", "Domestic Noir", "Action", "Adventure", "Romance", "Fantasy");

        List<String> result = new ArrayList<>();
        for(String genre : genres){
            if(genre.startsWith("D"))
                result.add(genre);
        }


        System.out.println(result);
        List<String> expected = List.of("Detective", "Domestic Noir");
        Assertions.assertLinesMatch(expected,result);
    }

    @Test
    void testGenreSelectionStream(){
        List<String> genres = List.of("Detective", "Who dunnit", "Domestic Noir", "Action", "Adventure", "Romance", "Fantasy");

        List<String> result = genres.stream()
                .filter(genre -> genre.startsWith("D"))
                .toList();

        System.out.println(result);
        List<String> expected = List.of("Detective", "Domestic Noir");
        Assertions.assertLinesMatch(expected,result);
    }

    @Test
    void testGenreThrillerSelectionForLoop(){
        List<String> genres = List.of("Thriller-Detective", "Thriller-Who dunnit", "Thriller-Domestic Noir", "Thriller-Action", "Thriller-Adventure", "Romance", "Fantasy");

        List<String> result = new ArrayList<>();
        for(String genre : genres){
            if(genre.startsWith("Thriller")){
                String[] splitedString = genre.split("-");
                result.add(splitedString[1]);
            }
        }
        System.out.println(result);
        List<String> expected = List.of("Detective", "Who dunnit","Domestic Noir","Action","Adventure");
        Assertions.assertLinesMatch(expected,result);
    }

    @Test
    void testGenreThrillerSelectionStream(){
        List<String> genres = List.of("Thriller-Detective", "Thriller-Who dunnit", "Thriller-Domestic Noir", "Thriller-Action", "Thriller-Adventure", "Romance", "Fantasy");

        List<String> result = genres.stream()
                .filter(genre -> genre.startsWith("Thriller"))
                .map(genre->genre.split("-"))
                .map(s->s[1])
                .toList();

        System.out.println(result);
        List<String> expected = List.of("Detective", "Who dunnit","Domestic Noir","Action","Adventure");
        Assertions.assertLinesMatch(expected,result);
    }

}