package com.prosidney.douts;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by admin on 25/01/17.
 */
public class PeekExample {
    static enum Genre  {DRAMA, THRILLER, HORROR, ACTION };

    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Titanic", Genre.DRAMA, 'U'),
                new Movie("Psycho", Genre.THRILLER, 'U'),
                new Movie("Oldboy", Genre.THRILLER, 'R'),
                new Movie("Shining", Genre.HORROR, 'U')
        );

        movies.stream()
                .filter(mov->mov.getRating()=='R')
                .peek(mov->System.out.println(mov.getName()))
                .map(mov->mov.getName())
                .collect(Collectors.toList());
    }

    public static class Movie{
        private Genre genre;
        private String name;
        private char rating = 'R';

        Movie(String name, Genre genre, char rating){
            this.name = name; this.genre = genre; this.rating = rating;
        }

        public Genre getGenre() {
            return genre;
        }

        public void setGenre(Genre genre) {
            this.genre = genre;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public char getRating() {
            return rating;
        }

        public void setRating(char rating) {
            this.rating = rating;
        }
    }
}
