package com.prosidney.douts;

import java.util.*;
import java.util.Optional;

/**
 * Created by admin on 26/01/17.
 */
public class AverageQuestion {
    public static void main(String[] args){

        List<Book> books = Arrays.asList(new Book("Thinking in Java", 30.0),
                new Book("Java in 24 hrs", 20.0),
                new Book("Java Recipies", 10.0));


        final Book book = books.stream().min(Comparator.comparing(Book::getPrice)).get();
        System.out.println("max title = " + book.getTitle());

        System.out.println("======max=======");
        final OptionalDouble max = books.stream()
                .mapToDouble(Book::getPrice)
                .max();
        System.out.println(max.getAsDouble());

        System.out.println("======min=======");
        final OptionalInt minInt = books.stream()
                .mapToInt(b -> (int) book.getPrice())
                .min();
        System.out.println(minInt.getAsInt());


        System.out.println("======Statistics=======");
        final LongSummaryStatistics longSummaryStatistics =
                books.stream()
                        .filter(v -> v.getTitle().isEmpty())
                        .mapToLong(b -> (long) book.getPrice())
                        .summaryStatistics();
        System.out.println(longSummaryStatistics.getAverage());
        System.out.println(longSummaryStatistics.getCount());

        System.out.println("======max=======");
        final Optional max1 = books.stream()
                .filter(v -> v.getTitle().isEmpty())
                .max(Comparator.comparing(Book::getPrice));
        System.out.println(max1.orElseGet(()->"é Nulo"));


        System.out.println("======max(old comparator)=======");
        Comparator<Book> oldWayComparator = new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return new Double(o1.getPrice()).compareTo(o2.getPrice());
            }
        };
        books.stream()
                .max(oldWayComparator)
                .ifPresent(System.out::print);
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

        @Override
        public String toString() {
            return title;
        }
    }
}
