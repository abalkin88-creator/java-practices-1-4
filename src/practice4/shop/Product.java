// Практическая работа 4. Задание 3 Интернет магазин.
package practice4.shop;
public enum Product {
    JAVA_BOOK("Учебник Java", 1600, Category.BOOKS),
    DICTIONARY("Словарь", 800, Category.BOOKS),
    MOUSE("Мышь", 1200, Category.TECH),
    KEYBOARD("Клавиатура", 2500, Category.TECH);
    private final String title;
    private final int price;
    private final Category category;
    Product(String title, int price, Category category) {
        this.title = title; this.price = price; this.category = category;
    }
    public int getPrice() { return price; }
    public Category getCategory() { return category; }
    @Override public String toString() { return title + " - " + price + " руб."; }
}
