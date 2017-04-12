package com.prosidney.java8.collect;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by admin on 25/01/17.
 */
public class CollectWithMapping {
    static enum Genre  {DRAMA, THRILLER, HORROR, ACTION };

    public static void main(String[] args) {
        List<Movie> movies = Arrays.asList(
                new Movie("Titanic", Genre.DRAMA, 'U'),
                new Movie("Psycho", Genre.THRILLER, 'U'),
                new Movie("Oldboy", Genre.THRILLER, 'R'),
                new Movie("Shining", Genre.HORROR, 'U')
        );

        final Map<Character, Set<String>> collect =
                movies.stream().collect(
                        Collectors.groupingBy(Movie::getRating,
                                Collectors.mapping(Movie::getName, Collectors.toSet())
                                ));
        System.out.println(collect);


        final Map<Character, Map<Genre, String>> collect3 =
                movies.stream().collect(
                    Collectors.groupingBy(Movie::getRating,
                            Collectors.toMap(Movie::getGenre, Movie::getName)));
        System.out.println(collect3);


        final Set<String> collect1 =
                movies.stream().collect(Collectors.mapping(Movie::getName, Collectors.toSet()));
        System.out.println(collect1);


        final List<String> collect2 = movies.stream().map(Movie::getName).collect(Collectors.toList());
        System.out.println(collect2);


        final Map<Character, Set<String>> collectMaster =
                movies.stream().collect(
                        Collectors.groupingBy(Movie::getRating,
                                HashMap::new,
                                Collectors.mapping(Movie::getName, Collectors.toSet())
                        ));
        System.out.println(collectMaster);
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
