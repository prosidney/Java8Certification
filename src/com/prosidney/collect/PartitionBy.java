package com.prosidney.collect;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Created by admin on 06/02/17.
 */
public class PartitionBy {
    static enum Genre  {DRAMA, THRILLER, HORROR, ACTION };

    public static void main(String[] args) {
        List<CollectWithMapping.Movie> movies = Arrays.asList(
                new CollectWithMapping.Movie("Titanic", CollectWithMapping.Genre.DRAMA, 'U'),
                new CollectWithMapping.Movie("Psycho", CollectWithMapping.Genre.THRILLER, 'U'),
                new CollectWithMapping.Movie("Oldboy", CollectWithMapping.Genre.THRILLER, 'R'),
                new CollectWithMapping.Movie("Shining", CollectWithMapping.Genre.HORROR, 'U')
        );


        movies.stream().collect(
                Collectors.partitioningBy(a -> a.getGenre().equals(CollectWithMapping.Genre.THRILLER),
                        Collectors.mapping(b -> b.getName(), Collectors.toList()))
        ).forEach((key, value) -> System.out.println(key + ""+ value));


    }

    public static class Movie{
        private CollectWithMapping.Genre genre;
        private String name;
        private char rating = 'R';

        Movie(String name, CollectWithMapping.Genre genre, char rating){
            this.name = name; this.genre = genre; this.rating = rating;
        }

        public CollectWithMapping.Genre getGenre() {
            return genre;
        }

        public void setGenre(CollectWithMapping.Genre genre) {
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
