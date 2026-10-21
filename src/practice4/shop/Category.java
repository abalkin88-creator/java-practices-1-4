// Практическая работа 4. Задание 3 Интернет магазин.
package practice4.shop;
public enum Category {
    BOOKS("Книги"), TECH("Техника");
    private final String title;
    Category(String title) { this.title = title; }
    @Override public String toString() { return title; }
}
