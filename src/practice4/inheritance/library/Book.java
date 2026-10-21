// Практическая работа 4, раздел 4.1. Задание 5 Читатели библиотеки.
package practice4.inheritance.library;
public class Book {
    private final String title, author;
    public Book(String title, String author) {
        this.title = title; this.author = author;
    }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    @Override public String toString() { return title + " (" + author + ")"; }
}
