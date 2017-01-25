package com.prosidney.douts;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 25/01/17.
 */
public class StreamRemovalUpdate {
    public static void main(String args[]){
        List<Book> books = Arrays.asList(
                new Book("Freedom at Midnight", 5.0),
                new Book("Gone with the wind", 5.0),
                new Book("Midnight Cowboy", 15.0)
        );

        books.stream()
                .filter(b->b.getName().startsWith("F"))
                .forEach(b->b.setPrice(10.0));
        books.stream()
                .forEach(b->System.out.println(b.getName()+":"+b.getPrice()));
    }




    public static class Book {
        private String name;
        private double price;

        public Book(String name, double price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }
    }
}
