package com.prosidney.collect;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sidney on 2017-02-07.
 */
public class ChangingInsideForeach {

    public static void main(String[] args) {
        List<Book> books = Arrays.asList(
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0),
                new Book("Midnight Cowboy", 15.0)
        );

        books.stream()
                .filter(b->b.getTitle().startsWith("F"))
                .peek(b->b = new Book("oi", 99999))
                    .forEach(b->{});

        books.stream()
                .forEach(b->System.out.println(b.getTitle()+":"+b.getPrice()));

    }

    public static class Book{
        private String title;
        private double price;

        public Book(String title, double price) {
            this.title = title;
            this.price = price;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
