package com.prosidney.douts;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 26/01/17.
 */
public class AverageQuestion {
    public static void main(String[] args){

        List<Book> books = Arrays.asList(new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipies", 10.0));
        double averagePrice = books.stream().filter(b->b.getPrice()>10)
                .mapToDouble(b->b.getPrice())
                .average().getAsDouble();

        System.out.println(averagePrice);
    }

    static class Book{
        private String title;
        private double price;
        public Book(String title, double price){
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
