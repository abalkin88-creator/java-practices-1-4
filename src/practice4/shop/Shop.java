// Практическая работа 4. Задание 3 Интернет магазин.
package practice4.shop;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Shop {
    private static int readInt(Scanner in) {
        while (true) {
            try {
                return Integer.parseInt(in.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Введите целое число:");
            }
        }
    }
    private static void showProducts(Category category) {
        Product[] products = Product.values();
        for (int i = 0; i < products.length; i++) {
            if (products[i].getCategory() == category) {
                System.out.println((i + 1) + ". " + products[i]);
            }
        }
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Логин:");
        String login = in.nextLine();
        System.out.println("Пароль:");
        String password = in.nextLine();
        if (!login.equals("student") || !password.equals("java17")) {
            System.out.println("Неверный логин или пароль");
            return;
        }
        System.out.println("Вход выполнен");
        List<Product> basket = new ArrayList<>();
        Category selected = null;
        while (true) {
            System.out.println("1 Каталоги; 2 Товары; 3 Добавить;");
            System.out.println("4 Корзина; 5 Купить; 0 Выход");
            int command = readInt(in);
            if (command == 0) break;
            switch (command) {
                case 1:
                    Category[] categories = Category.values();
                    for (int i = 0; i < categories.length; i++) {
                        System.out.println((i + 1) + ". " + categories[i]);
                    }
                    break;
                case 2:
                    System.out.println("Номер каталога:");
                    int index = readInt(in) - 1;
                    if (index < 0 || index >= Category.values().length) {
                        System.out.println("Каталог не найден");
                        break;
                    }
                    selected = Category.values()[index];
                    showProducts(selected);
                    break;
                case 3:
                    if (selected == null) {
                        System.out.println("Сначала выберите каталог");
                        break;
                    }
                    System.out.println("Номер товара:");
                    int id = readInt(in) - 1;
                    Product[] products = Product.values();
                    if (id < 0 || id >= products.length
                            || products[id].getCategory() != selected) {
                        System.out.println("Товар не найден в каталоге");
                        break;
                    }
                    basket.add(products[id]);
                    System.out.println("Добавлен: " + products[id]);
                    break;
                case 4:
                    if (basket.isEmpty()) System.out.println("Корзина пуста");
                    for (Product product : basket) System.out.println(product);
                    break;
                case 5:
                    if (basket.isEmpty()) {
                        System.out.println("Корзина пуста");
                        break;
                    }
                    long total = 0;
                    for (Product product : basket) total += product.getPrice();
                    System.out.println("Покупка оформлена: " + total + " руб.");
                    basket.clear();
                    break;
                default: System.out.println("Неизвестная команда");
            }
        }
    }
}
