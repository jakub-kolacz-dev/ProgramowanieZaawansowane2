package com.example.programowaniezaawansowane.zadanie1;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Task1 {

    public static void main(String[] args) {
        List<Double>  numbers = new ArrayList<>(10);
        fillList(numbers);
        sortList(numbers);
        numbers.forEach(System.out::println);

        List<Book> books = new ArrayList<>();
        books.add(new Book("The Great Gatsby"));
        books.add(new Book("To Kill a Mockingbird"));
        books.add(new Book("1984"));
        books.add(new Book("Animal Farm"));

        sortBooks(books);

        //2
        List<Book> books2 = new ArrayList<>();
        books2.add(new Book("The Great Gatsby", new Author("F. Scott", "Fitzgerald")));
        books2.add(new Book("To Kill a Mockingbird", new Author("Harper", "Lee")));
        books2.add(new Book("The Catcher in the Rye", new Author("J.D.", "Salinger")));
        books2.add(new Book("Nine Stories", new Author("J.D.", "Salinger")));


        Comparator<Book> bookComparator = Comparator.comparing((Book book) -> book.getAuthor().getLastName())
                .thenComparing(book -> book.getAuthor().getFirstName())
                .thenComparing(Book::getTitle);

        books2.stream().sorted(bookComparator).forEach(System.out::println);

        books2.stream()
                .filter(book -> book.getAuthor().getLastName().startsWith("M"))
                .forEach(System.out::println);

        books2.stream()
                .sorted(bookComparator)
                .peek(System.out::println)
                .filter(book -> book.getAuthor().getLastName().startsWith("M"))
                .forEach(System.out::println);

        books2.stream()
                .map(Book::getAuthor)
                .distinct()
                .forEach(System.out::println);

    }

    public static List<Double> fillList(List<Double> list){
        return list.stream().map(i -> {
            i = Math.random();
            return i;
        }).collect(Collectors.toList());
    }

    public static void sortList(List<Double> list){
        list.sort(Comparator.naturalOrder());
    }

    public static void sortBooks(List<Book> list){
        list.stream().sorted(bookComparator).forEach(System.out::println);
    }

    static Comparator<Book> bookComparator = Comparator.comparing(Book::getTitle);


    @AllArgsConstructor
    @NoArgsConstructor
    static class Book {
        private String title;
        private Author author;

        public Book(String title) {
            this.title = title;
        }

        public String getTitle() {
            return title;
        }

        public Author getAuthor() {
            return author;
        }
    }

    @AllArgsConstructor
    @NoArgsConstructor
    static class Author {
        private String firstName;
        private String lastName;

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }
    }

}

