// ФИНАЛ. Практическая работа 4: все задания в одном файле.
// Запустите Final и выберите номер задания из меню.
// Каждый блок Task содержит классы одного задания; их имена сохранены.
package practice4;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Final {
    public static void main(String[] args) throws IOException {
        String choice;
        String[] taskArgs;
        if (args.length == 0) {
            System.out.println("Практическая работа 4. Выберите задание:");
            System.out.println("1 — Задание 1 Времена года");
            System.out.println("2 — Задание 2 Ателье");
            System.out.println("3 — Задание 3 Интернет магазин");
            System.out.println("4 — Задание 4 Компьютер");
            System.out.println("4.1.1 — Раздел 4.1. Задание 1 Наследование геометрических фигур");
            System.out.println("4.1.2 — Раздел 4.1. Задание 2 Телефон");
            System.out.println("4.1.3 — Раздел 4.1. Задание 3 Человек");
            System.out.println("4.1.4 — Раздел 4.1. Задание 4 Матрица");
            System.out.println("4.1.5 — Раздел 4.1. Задание 5 Читатели библиотеки");
            System.out.println("4.1.6 — Раздел 4.1. Задание 6 Сотрудник и менеджер");
            System.out.println("4.1.7 — Раздел 4.1. Задание 7 Учащиеся");
            System.out.println("4.1.8 — Раздел 4.1. Задание 8 Абстрактная иерархия фигур");
            System.out.println("4.1.9 — Раздел 4.1. Задание 9 Магазин мебели");
            System.out.println("4.1.10 — Раздел 4.1. Задание 10 Транспортные средства");
            System.out.println("4.1.11 — Раздел 4.1. Упражнение 1 Исправление ошибок и полиморфизм");
            System.out.println("0 — Выход");
            // Читаем только строку выбора, чтобы Scanner самого задания
            // получил весь последующий ввод (массив, логин, пароль и т. д.).
            StringBuilder line = new StringBuilder();
            int symbol;
            while ((symbol = System.in.read()) != -1 && symbol != '\n') {
                if (symbol != '\r') line.append((char) symbol);
            }
            choice = line.toString().trim();
            taskArgs = new String[0];
        } else {
            choice = args[0];
            taskArgs = Arrays.copyOfRange(args, 1, args.length);
        }
        switch (choice) {
            case "":
            case "0": return;
            case "1": Task1.TestSeason.main(taskArgs); break;
            case "2": Task2.Atelier.main(taskArgs); break;
            case "3": Task3.Shop.main(taskArgs); break;
            case "4": Task4.Computer.main(taskArgs); break;
            case "4.1.1": Task5.TestFigures.main(taskArgs); break;
            case "4.1.2": Task6.Phone.main(taskArgs); break;
            case "4.1.3": Task7.Person.main(taskArgs); break;
            case "4.1.4": Task8.Matrix.main(taskArgs); break;
            case "4.1.5": Task9.Reader.main(taskArgs); break;
            case "4.1.6": Task10.Manager.main(taskArgs); break;
            case "4.1.7": Task11.TestLearners.main(taskArgs); break;
            case "4.1.8": Task12.TestShape.main(taskArgs); break;
            case "4.1.9": Task13.FurnitureShop.main(taskArgs); break;
            case "4.1.10": Task14.TestTransport.main(taskArgs); break;
            case "4.1.11": Task15.PolymorphismExercise.main(taskArgs); break;
            default: System.out.println("Такого задания нет. Выберите номер из меню.");
        }
    }

    // ================================================================
    // Задание 1 Времена года
    // Создать enum времён года со средней температурой и конструктором. Вывести любимое время года, реализовать метод со switch. getDescription возвращает «Холодное время года», а для лета переопределяется и возвращает «Теплое время года». Вывести все константы, температуры и описания.
    // ================================================================
    public static class Task1 {
        public enum Season {
            WINTER("Зима", -8), SPRING("Весна", 7),
            SUMMER("Лето", 21) {
                @Override public String getDescription() {
                    return "Теплое время года";
                }
            },
            AUTUMN("Осень", 6);
            private final String title;
            private final double temperature;
            Season(String title, double temperature) {
                this.title = title;
                this.temperature = temperature;
            }
            public double getTemperature() { return temperature; }
            public String getDescription() { return "Холодное время года"; }
            @Override public String toString() { return title; }
        }

        public static class TestSeason {
            public static void love(Season season) {
                switch (season) {
                    case WINTER: System.out.println("Я люблю зиму"); break;
                    case SPRING: System.out.println("Я люблю весну"); break;
                    case SUMMER: System.out.println("Я люблю лето"); break;
                    case AUTUMN: System.out.println("Я люблю осень"); break;
                }
            }
            public static void main(String[] args) {
                Season favorite = Season.SUMMER;
                System.out.println("Любимое: " + favorite + ", "
                        + favorite.getTemperature() + ", " + favorite.getDescription());
                love(favorite);
                for (Season season : Season.values()) {
                    System.out.println(season + ": " + season.getTemperature()
                            + " C, " + season.getDescription());
                }
            }
        }
    }
    // ================================================================
    // Задание 2 Ателье
    // Создать размеры XXS, XS, S, M, L с euroSize 32, 34, 36, 38, 40 и описанием размера; для XXS переопределить описание. Реализовать MenClothing, WomenClothing, абстрактный Clothes и подклассы TShirt, Pants, Skirt, Tie. Класс Atelier должен принимать Clothes[] и выводить всю информацию отдельно о мужской и женской одежде.
    // ================================================================
    public static class Task2 {
        public enum Size {
            XXS(32) {
                @Override public String getDescription() { return "Детский размер"; }
            },
            XS(34), S(36), M(38), L(40);
            private final int euroSize;
            Size(int euroSize) { this.euroSize = euroSize; }
            public int getEuroSize() { return euroSize; }
            public String getDescription() { return "Взрослый размер"; }
        }

        public interface MenClothing { void dressMan(); }

        public interface WomenClothing { void dressWomen(); }

        public static abstract class Clothes {
            protected final Size size;
            protected final int price;
            protected final String color;
            public Clothes(Size size, int price, String color) {
                this.size = size; this.price = price; this.color = color;
            }
            @Override public String toString() {
                return getClass().getSimpleName() + ": " + size
                        + ", EU " + size.getEuroSize() + ", " + size.getDescription()
                        + ", " + color + ", " + price + " руб.";
            }
        }

        public static class TShirt extends Clothes implements MenClothing, WomenClothing {
            public TShirt(Size size, int price, String color) {
                super(size, price, color);
            }
            @Override public void dressMan() {
                System.out.println(this);
            }
            @Override public void dressWomen() {
                System.out.println(this);
            }
        }

        public static class Pants extends Clothes implements MenClothing, WomenClothing {
            public Pants(Size size, int price, String color) {
                super(size, price, color);
            }
            @Override public void dressMan() {
                System.out.println(this);
            }
            @Override public void dressWomen() {
                System.out.println(this);
            }
        }

        public static class Skirt extends Clothes implements WomenClothing {
            public Skirt(Size size, int price, String color) {
                super(size, price, color);
            }
            @Override public void dressWomen() {
                System.out.println(this);
            }
        }

        public static class Tie extends Clothes implements MenClothing {
            public Tie(Size size, int price, String color) {
                super(size, price, color);
            }
            @Override public void dressMan() {
                System.out.println(this);
            }
        }

        public static class Atelier {
            public void dressMan(Clothes[] clothes) {
                for (Clothes item : clothes) {
                    if (item instanceof MenClothing) {
                        ((MenClothing) item).dressMan();
                    }
                }
            }
            public void dressWomen(Clothes[] clothes) {
                for (Clothes item : clothes) {
                    if (item instanceof WomenClothing) {
                        ((WomenClothing) item).dressWomen();
                    }
                }
            }
            public static void main(String[] args) {
                Clothes[] clothes = {
                    new TShirt(Size.XXS, 700, "белый"),
                    new Pants(Size.M, 2400, "серый"),
                    new Skirt(Size.S, 1800, "синий"),
                    new Tie(Size.L, 900, "бордовый")
                };
                Atelier atelier = new Atelier();
                System.out.println("Женская одежда:");
                atelier.dressWomen(clothes);
                System.out.println("Мужская одежда:");
                atelier.dressMan(clothes);
                for (Size size : Size.values()) {
                    System.out.println(size + " -> " + size.getEuroSize()
                            + ": " + size.getDescription());
                }
            }
        }
    }
    // ================================================================
    // Задание 3 Интернет магазин
    // Создать мини-приложение: ввод логина и пароля с клавиатуры, просмотр каталогов и товаров выбранного каталога, добавление товара в корзину и покупка содержимого корзины. Использовать перечисления.
    // ================================================================
    public static class Task3 {
        public enum Category {
            BOOKS("Книги"), TECH("Техника");
            private final String title;
            Category(String title) { this.title = title; }
            @Override public String toString() { return title; }
        }

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

        public static class Shop {
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
    }
    // ================================================================
    // Задание 4 Компьютер
    // Описать Computer и его составные части отдельными классами Processor, Memory, Monitor. Предусмотреть свойства и методы каждого класса. Марки компьютеров представить перечислением.
    // ================================================================
    public static class Task4 {
        public enum Brand { ASUS, LENOVO, DELL, HP }

        public static class Processor {
            private final String model;
            private final int cores;
            private final double frequency;
            public Processor(String model, int cores, double frequency) {
                this.model = model; this.cores = cores; this.frequency = frequency;
            }
            public String getModel() { return model; }
            public int getCores() { return cores; }
            public double getFrequency() { return frequency; }
            @Override public String toString() {
                return model + ", " + cores + " ядер, " + frequency + " ГГц";
            }
        }

        public static class Memory {
            private final int capacity;
            private final String type;
            public Memory(int capacity, String type) {
                this.capacity = capacity; this.type = type;
            }
            public int getCapacity() { return capacity; }
            public String getType() { return type; }
            @Override public String toString() { return capacity + " ГБ " + type; }
        }

        public static class Monitor {
            private final double diagonal;
            private final String resolution;
            public Monitor(double diagonal, String resolution) {
                this.diagonal = diagonal; this.resolution = resolution;
            }
            public double getDiagonal() { return diagonal; }
            public String getResolution() { return resolution; }
            @Override public String toString() {
                return diagonal + " дюйма, " + resolution;
            }
        }

        public static class Computer {
            private final Brand brand;
            private final Processor processor;
            private final Memory memory;
            private final Monitor monitor;
            public Computer(Brand brand, Processor processor,
                            Memory memory, Monitor monitor) {
                this.brand = brand; this.processor = processor;
                this.memory = memory; this.monitor = monitor;
            }
            public Brand getBrand() { return brand; }
            public Processor getProcessor() { return processor; }
            public Memory getMemory() { return memory; }
            public Monitor getMonitor() { return monitor; }
            @Override public String toString() {
                return brand + "; CPU: " + processor + "; RAM: " + memory
                        + "; экран: " + monitor;
            }
            public static void main(String[] args) {
                Computer pc = new Computer(Brand.LENOVO,
                        new Processor("Ryzen 5 5600", 6, 3.5),
                        new Memory(16, "DDR4"), new Monitor(23.8, "1920x1080"));
                System.out.println(pc.getBrand());
                System.out.println(pc.getProcessor());
                System.out.println(pc.getMemory());
                System.out.println(pc.getMonitor());
                System.out.println("Ядер: " + pc.getProcessor().getCores());
            }
        }
    }
    // ================================================================
    // Раздел 4.1. Задание 1 Наследование геометрических фигур
    // Создать простой класс Shape с getType, getArea, getPerimeter и toString. Создать Circle, Rectangle и Square, переопределить методы, продемонстрировать их вызов через родительскую ссылку и объяснить результат.
    // ================================================================
    public static class Task5 {
        public static class Shape {
            public String getType() { return "Фигура"; }
            public double getArea() { return 0; }
            public double getPerimeter() { return 0; }
            @Override public String toString() { return getType(); }
        }

        public static class Circle extends Shape {
            private final double radius;
            public Circle(double radius) { this.radius = radius; }
            @Override public String getType() { return "Круг"; }
            @Override public double getArea() { return Math.PI * radius * radius; }
            @Override public double getPerimeter() { return 2 * Math.PI * radius; }
            @Override public String toString() {
                return getType() + ": радиус " + radius;
            }
        }

        public static class Rectangle extends Shape {
            protected final double width, length;
            public Rectangle(double width, double length) {
                this.width = width; this.length = length;
            }
            @Override public String getType() { return "Прямоугольник"; }
            @Override public double getArea() { return width * length; }
            @Override public double getPerimeter() { return 2 * (width + length); }
            @Override public String toString() {
                return getType() + ": " + width + " x " + length;
            }
        }

        public static class Square extends Rectangle {
            public Square(double side) { super(side, side); }
            @Override public String getType() { return "Квадрат"; }
            @Override public double getArea() { return width * width; }
            @Override public double getPerimeter() { return 4 * width; }
            @Override public String toString() { return getType() + ": сторона " + width; }
        }

        public static class TestFigures {
            public static void main(String[] args) {
                Shape[] shapes = {new Circle(3), new Rectangle(4, 5), new Square(4)};
                for (Shape shape : shapes) {
                    System.out.println(shape);
                    System.out.printf(Locale.US, "%s: S=%.3f; P=%.3f%n",
                            shape.getType(), shape.getArea(), shape.getPerimeter());
                }
            }
        }
    }
    // ================================================================
    // Раздел 4.1. Задание 2 Телефон
    // Создать Phone с number, model, weight. Реализовать три конструктора, вызов двухпараметрического конструктора из трёхпараметрического, getNumber, две перегрузки receiveCall и sendMessage с переменным числом номеров. Создать три объекта и вызвать методы.
    // ================================================================
    public static class Task6 {
        public static class Phone {
            private String number, model;
            private double weight;
            public Phone() { this("не задан", "не задан", 0); }
            public Phone(String number, String model) {
                this.number = number; this.model = model;
            }
            public Phone(String number, String model, double weight) {
                this(number, model);
                this.weight = weight;
            }
            public String getNumber() { return number; }
            public void receiveCall(String name) {
                System.out.println("Звонит " + name);
            }
            public void receiveCall(String name, String callerNumber) {
                System.out.println("Звонит " + name + ", " + callerNumber);
            }
            public void sendMessage(String... numbers) {
                for (String recipient : numbers) {
                    System.out.println("Сообщение для " + recipient);
                }
            }
            @Override public String toString() {
                return number + "; " + model + "; " + weight + " г";
            }
            public static void main(String[] args) {
                Phone[] phones = {
                    new Phone("+70000000001", "Model A", 170),
                    new Phone("+70000000002", "Model B"), new Phone()
                };
                for (Phone phone : phones) {
                    System.out.println(phone);
                    phone.receiveCall("Елена");
                    System.out.println("Номер: " + phone.getNumber());
                }
                phones[0].receiveCall("Олег", "+70000000003");
                phones[0].sendMessage("+70000000004", "+70000000005");
            }
        }
    }
    // ================================================================
    // Раздел 4.1. Задание 3 Человек
    // Создать Person с полями fullName и age, методами move и talk, конструкторами Person() и Person(fullName, age). Создать по объекту каждым конструктором и вызвать методы.
    // ================================================================
    public static class Task7 {
        public static class Person {
            private String fullName;
            private int age;
            public Person() { this("Неизвестный", 0); }
            public Person(String fullName, int age) {
                this.fullName = fullName; this.age = age;
            }
            public void move() { System.out.println(fullName + " идёт"); }
            public void talk() { System.out.println(fullName + " говорит"); }
            @Override public String toString() { return fullName + ", возраст " + age; }
            public static void main(String[] args) {
                Person first = new Person();
                Person second = new Person("Мария Смирнова", 19);
                for (Person person : new Person[]{first, second}) {
                    System.out.println(person);
                    person.move(); person.talk();
                }
            }
        }
    }
    // ================================================================
    // Раздел 4.1. Задание 4 Матрица
    // Создать Matrix с двумерным массивом вещественных чисел, количеством строк и столбцов. Реализовать сложение, умножение на число, печать и дополнительное умножение матриц.
    // ================================================================
    public static class Task8 {
        public static class Matrix {
            private final double[][] data;
            private final int rows, columns;
            public Matrix(double[][] source) {
                if (source.length == 0 || source[0].length == 0) {
                    throw new IllegalArgumentException("Матрица пуста");
                }
                rows = source.length; columns = source[0].length;
                data = new double[rows][columns];
                for (int i = 0; i < rows; i++) {
                    if (source[i].length != columns) {
                        throw new IllegalArgumentException("Строки разной длины");
                    }
                    data[i] = source[i].clone();
                }
            }
            public Matrix add(Matrix other) {
                if (rows != other.rows || columns != other.columns) {
                    throw new IllegalArgumentException("Размеры не совпадают");
                }
                double[][] result = new double[rows][columns];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        result[i][j] = data[i][j] + other.data[i][j];
                    }
                }
                return new Matrix(result);
            }
            public Matrix multiply(double factor) {
                double[][] result = new double[rows][columns];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < columns; j++) {
                        result[i][j] = data[i][j] * factor;
                    }
                }
                return new Matrix(result);
            }
            public Matrix multiply(Matrix other) {
                if (columns != other.rows) {
                    throw new IllegalArgumentException("Несовместимые размеры");
                }
                double[][] result = new double[rows][other.columns];
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < other.columns; j++) {
                        for (int k = 0; k < columns; k++) {
                            result[i][j] += data[i][k] * other.data[k][j];
                        }
                    }
                }
                return new Matrix(result);
            }
            public void print() {
                for (double[] row : data) System.out.println(Arrays.toString(row));
            }
            public static void main(String[] args) {
                Matrix a = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
                Matrix b = new Matrix(new double[][]{{6, 5, 4}, {3, 2, 1}});
                Matrix c = new Matrix(new double[][]{{1, 0}, {0, 1}, {1, 1}});
                System.out.println("A + B:"); a.add(b).print();
                System.out.println("A * 2:"); a.multiply(2).print();
                System.out.println("A * C:"); a.multiply(c).print();
                try {
                    a.multiply(b);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
    // ================================================================
    // Раздел 4.1. Задание 5 Читатели библиотеки
    // Создать Reader с ФИО, номером билета, факультетом, датой рождения и телефоном. Создать массив читателей. Перегрузить takeBook и returnBook для количества книг, переменного числа названий и объектов Book, содержащих название и автора.
    // ================================================================
    public static class Task9 {
        public static class Book {
            private final String title, author;
            public Book(String title, String author) {
                this.title = title; this.author = author;
            }
            public String getTitle() { return title; }
            public String getAuthor() { return author; }
            @Override public String toString() { return title + " (" + author + ")"; }
        }

        public static class Reader {
            private final String fullName, faculty, birthDate, phone;
            private final int cardNumber;
            public Reader(String fullName, int cardNumber, String faculty,
                          String birthDate, String phone) {
                this.fullName = fullName; this.cardNumber = cardNumber;
                this.faculty = faculty; this.birthDate = birthDate; this.phone = phone;
            }
            public void takeBook(int count) {
                System.out.println(fullName + " взял " + count + " книги");
            }
            public void returnBook(int count) {
                System.out.println(fullName + " вернул " + count + " книги");
            }
            public void takeBook(String... titles) {
                System.out.println(fullName + " взял книги: " + String.join(", ", titles));
            }
            public void returnBook(String... titles) {
                System.out.println(fullName + " вернул книги: " + String.join(", ", titles));
            }
            private String[] titles(Book[] books) {
                String[] result = new String[books.length];
                for (int i = 0; i < books.length; i++) result[i] = books[i].getTitle();
                return result;
            }
            public void takeBook(Book... books) { takeBook(titles(books)); }
            public void returnBook(Book... books) { returnBook(titles(books)); }
            @Override public String toString() {
                return fullName + "; билет " + cardNumber + "; " + faculty
                        + "; " + birthDate + "; " + phone;
            }
            public static void main(String[] args) {
                Reader[] readers = {
                    new Reader("Иванов И. И.", 101, "ИТ", "12.03.2006", "+70000000001"),
                    new Reader("Соколова А. В.", 102, "Физика", "09.07.2005", "+70000000002")
                };
                for (Reader reader : readers) System.out.println(reader);
                Reader r = readers[0];
                r.takeBook(3); r.returnBook(3);
                r.takeBook("Рассказы", "Словарь", "Энциклопедия");
                r.returnBook("Рассказы", "Словарь", "Энциклопедия");
                Book[] books = {new Book("Капитанская дочка", "А. Пушкин"),
                                new Book("Муму", "И. Тургенев")};
                r.takeBook(books); r.returnBook(books);
            }
        }
    }
    // ================================================================
    // Раздел 4.1. Задание 6 Сотрудник и менеджер
    // Создать Employer с firstName, lastName, income и методом getIncome. Создать Manager с дополнительным averageSum и переопределить getIncome с учётом выплаты от продаж. Присвоить Manager ссылке Employer, создать смешанный массив и вызвать getIncome для каждого элемента.
    // ================================================================
    public static class Task10 {
        public static class Employer {
            protected final String firstName, lastName;
            protected final double income;
            public Employer(String firstName, String lastName, double income) {
                this.firstName = firstName; this.lastName = lastName;
                this.income = income;
            }
            public double getIncome() { return income * 12; }
            @Override public String toString() { return firstName + " " + lastName; }
        }

        public static class Manager extends Employer {
            private final double averageSum;
            public Manager(String firstName, String lastName,
                           double income, double averageSum) {
                super(firstName, lastName, income);
                this.averageSum = averageSum;
            }
            @Override public double getIncome() {
                return super.getIncome() + averageSum;
            }
            public static void main(String[] args) {
                Employer reference = new Manager("Антон", "Белов", 60000, 90000);
                System.out.println(reference + ": " + reference.getIncome());
                Employer[] workers = {
                    new Employer("Ольга", "Семенова", 50000), reference,
                    new Manager("Ирина", "Котова", 70000, 120000)
                };
                for (Employer worker : workers) {
                    System.out.println(worker + ": годовой доход " + worker.getIncome());
                }
            }
        }
    }
    // ================================================================
    // Раздел 4.1. Задание 7 Учащиеся
    // Создать суперкласс «Учащийся» и подклассы «Школьник» и «Студент». Заполнить массив суперкласса объектами обоих видов, вывести студентов и школьников отдельно.
    // ================================================================
    public static class Task11 {
        public static class Learner {
            protected final String name;
            public Learner(String name) { this.name = name; }
            @Override public String toString() { return name; }
        }

        public static class SchoolStudent extends Learner {
            private final int schoolClass;
            public SchoolStudent(String name, int schoolClass) {
                super(name); this.schoolClass = schoolClass;
            }
            @Override public String toString() {
                return name + ", класс " + schoolClass;
            }
        }

        public static class Student extends Learner {
            private final String group;
            public Student(String name, String group) { super(name); this.group = group; }
            @Override public String toString() { return name + ", группа " + group; }
        }

        public static class TestLearners {
            public static void main(String[] args) {
                Learner[] learners = {
                    new Student("Алина", "ИТ-12"), new SchoolStudent("Павел", 10),
                    new Student("Максим", "ИТ-11"), new SchoolStudent("Даша", 9)
                };
                System.out.println("Студенты:");
                for (Learner learner : learners) {
                    if (learner instanceof Student) System.out.println(learner);
                }
                System.out.println("Школьники:");
                for (Learner learner : learners) {
                    if (learner instanceof SchoolStudent) System.out.println(learner);
                }
            }
        }
    }
    // ================================================================
    // Раздел 4.1. Задание 8 Абстрактная иерархия фигур
    // Переписать Shape как абстрактный класс с protected-полями color и filled, геттерами и сеттерами, абстрактными getArea и getPerimeter. Реализовать Circle, Rectangle и Square по UML.
    // ================================================================
    public static class Task12 {
        public static abstract class Shape {
            protected String color;
            protected boolean filled;
            public Shape() { this("blue", false); }
            public Shape(String color, boolean filled) {
                this.color = color;
                this.filled = filled;
            }
            public String getColor() { return color; }
            public void setColor(String color) { this.color = color; }
            public boolean isFilled() { return filled; }
            public void setFilled(boolean filled) { this.filled = filled; }
            public abstract double getArea();
            public abstract double getPerimeter();
            @Override
            public String toString() {
                return "Shape[color=" + color + ", filled=" + filled + "]";
            }
        }

        public static class Circle extends Shape {
            protected double radius;
            public Circle() { this(1); }
            public Circle(double radius) { this(radius, "blue", false); }
            public Circle(double radius, String color, boolean filled) {
                super(color, filled);
                setRadius(radius);
            }
            public double getRadius() { return radius; }
            public void setRadius(double radius) {
                if (radius <= 0) throw new IllegalArgumentException("Радиус > 0");
                this.radius = radius;
            }
            @Override
            public double getArea() { return Math.PI * radius * radius; }
            @Override
            public double getPerimeter() { return 2 * Math.PI * radius; }
            @Override
            public String toString() {
                return "Circle[radius=" + radius + ", " + super.toString() + "]";
            }
        }

        public static class Rectangle extends Shape {
            protected double width, length;
            public Rectangle() { this(1, 1); }
            public Rectangle(double width, double length) {
                this(width, length, "blue", false);
            }
            public Rectangle(double width, double length,
                             String color, boolean filled) {
                super(color, filled);
                if (width <= 0 || length <= 0) {
                    throw new IllegalArgumentException("Стороны > 0");
                }
                this.width = width;
                this.length = length;
            }
            public double getWidth() { return width; }
            public double getLength() { return length; }
            public void setWidth(double width) {
                if (width <= 0) throw new IllegalArgumentException("Ширина > 0");
                this.width = width;
            }
            public void setLength(double length) {
                if (length <= 0) throw new IllegalArgumentException("Длина > 0");
                this.length = length;
            }
            @Override
            public double getArea() { return width * length; }
            @Override
            public double getPerimeter() { return 2 * (width + length); }
            @Override
            public String toString() {
                return "Rectangle[width=" + width + ", length=" + length
                        + ", " + super.toString() + "]";
            }
        }

        public static class Square extends Rectangle {
            public Square() { this(1); }
            public Square(double side) { this(side, "blue", false); }
            public Square(double side, String color, boolean filled) {
                super(side, side, color, filled);
            }
            public double getSide() { return width; }
            public void setSide(double side) {
                super.setWidth(side);
                super.setLength(side);
            }
            @Override
            public void setWidth(double side) { setSide(side); }
            @Override
            public void setLength(double side) { setSide(side); }
            @Override
            public String toString() {
                return "Square[side=" + getSide() + ", color=" + color
                        + ", filled=" + filled + "]";
            }
        }

        public static class TestShape {
            private static void print(Shape shape) {
                System.out.println(shape);
                System.out.printf(Locale.US, "S=%.4f; P=%.4f%n",
                        shape.getArea(), shape.getPerimeter());
                System.out.println(shape.getColor() + "; " + shape.isFilled());
            }
            public static void main(String[] args) {
                Shape s1 = new Circle(5.5, "RED", false);
                print(s1);
                Circle c1 = (Circle) s1;
                System.out.println("Радиус: " + c1.getRadius());
                Shape s3 = new Rectangle(1, 2, "RED", false);
                print(s3);
                Rectangle r1 = (Rectangle) s3;
                System.out.println("Длина: " + r1.getLength());
                Shape s4 = new Square(6.6);
                print(s4);
                Rectangle r2 = (Rectangle) s4;
                System.out.println("Длина через Rectangle: " + r2.getLength());
                Square sq1 = (Square) r2;
                System.out.println("Сторона: " + sq1.getSide());
                sq1.setWidth(3);
                System.out.println("После setWidth: " + sq1.getWidth()
                        + " x " + sq1.getLength());
                // new Shape();          // нельзя создать абстрактный класс
                // s1.getRadius();       // у Shape нет getRadius
                // s3.getLength();       // у Shape нет getLength
                // s4.getSide();         // у Shape нет getSide
                // r2.getSide();         // у Rectangle нет getSide
                Shape[] figures = {new Circle(), new Rectangle(), new Square()};
                for (Shape shape : figures) print(shape);
            }
        }
    }
    // ================================================================
    // Раздел 4.1. Задание 9 Магазин мебели
    // Создать абстрактный класс «Мебель», реализовать различные виды мебели с помощью наследования. Создать FurnitureShop, моделирующий магазин, и протестировать классы.
    // ================================================================
    public static class Task13 {
        public static abstract class Furniture {
            protected final String material;
            protected final int price;
            public Furniture(String material, int price) {
                this.material = material; this.price = price;
            }
            public int getPrice() { return price; }
            public abstract String getType();
            public abstract String getPurpose();
            @Override public String toString() {
                return getType() + ": " + material + ", " + price
                        + " руб., " + getPurpose();
            }
        }

        public static class Chair extends Furniture {
            public Chair(String material, int price) { super(material, price); }
            @Override public String getType() { return "Стул"; }
            @Override public String getPurpose() { return "для сидения"; }
        }

        public static class Table extends Furniture {
            public Table(String material, int price) { super(material, price); }
            @Override public String getType() { return "Стол"; }
            @Override public String getPurpose() { return "для работы"; }
        }

        public static class FurnitureShop {
            private final Furniture[] catalog;
            public FurnitureShop(Furniture[] catalog) { this.catalog = catalog.clone(); }
            public void showCatalog() {
                for (int i = 0; i < catalog.length; i++) {
                    System.out.println((i + 1) + ". " + catalog[i]);
                }
            }
            public int buy(int index) {
                if (index < 0 || index >= catalog.length) {
                    throw new IllegalArgumentException("Товар не найден");
                }
                System.out.println("Куплен товар: " + catalog[index].getType());
                return catalog[index].getPrice();
            }
            public static void main(String[] args) {
                FurnitureShop shop = new FurnitureShop(new Furniture[]{
                    new Chair("берёза", 3200), new Table("сосна", 7800)
                });
                shop.showCatalog();
                System.out.println("К оплате: " + shop.buy(1) + " руб.");
            }
        }
    }
    // ================================================================
    // Раздел 4.1. Задание 10 Транспортные средства
    // Создать абстрактный класс транспортного средства и подклассы «Автомобиль», «Самолёт», «Поезд», «Корабль». Рассчитать время и стоимость перевозки пассажиров и грузов каждым видом транспорта.
    // ================================================================
    public static class Task14 {
        public static abstract class Transport {
            private final String name;
            private final double speed, passengerRate, cargoRate;
            public Transport(String name, double speed,
                             double passengerRate, double cargoRate) {
                this.name = name; this.speed = speed;
                this.passengerRate = passengerRate; this.cargoRate = cargoRate;
            }
            public double time(double distance) {
                if (distance < 0) throw new IllegalArgumentException("Расстояние >= 0");
                return distance / speed;
            }
            public double passengerCost(double distance, int passengers) {
                if (passengers < 0) throw new IllegalArgumentException("Пассажиры >= 0");
                time(distance);
                return distance * passengers * passengerRate;
            }
            public double cargoCost(double distance, double tons) {
                if (tons < 0) throw new IllegalArgumentException("Груз >= 0");
                time(distance);
                return distance * tons * cargoRate;
            }
            public abstract String getType();
            @Override public String toString() { return getType() + " " + name; }
        }

        public static class Car extends Transport {
            public Car(String name) { super(name, 80, 3, 12); }
            @Override public String getType() { return "Автомобиль"; }
        }

        public static class Plane extends Transport {
            public Plane(String name) { super(name, 700, 8, 30); }
            @Override public String getType() { return "Самолёт"; }
        }

        public static class Train extends Transport {
            public Train(String name) { super(name, 100, 2, 6); }
            @Override public String getType() { return "Поезд"; }
        }

        public static class Ship extends Transport {
            public Ship(String name) { super(name, 40, 1, 4); }
            @Override public String getType() { return "Корабль"; }
        }

        public static class TestTransport {
            public static void main(String[] args) {
                Transport[] vehicles = {new Car("A"), new Plane("B"),
                                        new Train("C"), new Ship("D")};
                double distance = 280;
                for (Transport vehicle : vehicles) {
                    System.out.println(vehicle);
                    System.out.printf(Locale.US,
                            "Время %.2f ч; 2 пассажира %.2f руб.; груз 3 т %.2f руб.%n",
                            vehicle.time(distance), vehicle.passengerCost(distance, 2),
                            vehicle.cargoCost(distance, 3));
                }
            }
        }
    }
    // ================================================================
    // Раздел 4.1. Упражнение 1 Исправление ошибок и полиморфизм
    // Проверить предложенные в листинге 4.1.3 объявления и вызовы, объяснить ошибки, представить рабочую версию и связать результат с полиморфизмом.
    // ================================================================
    public static class Task15 {
        public static abstract class Shape {
            protected String color;
            protected boolean filled;
            public Shape() { this("blue", false); }
            public Shape(String color, boolean filled) {
                this.color = color;
                this.filled = filled;
            }
            public String getColor() { return color; }
            public void setColor(String color) { this.color = color; }
            public boolean isFilled() { return filled; }
            public void setFilled(boolean filled) { this.filled = filled; }
            public abstract double getArea();
            public abstract double getPerimeter();
            @Override
            public String toString() {
                return "Shape[color=" + color + ", filled=" + filled + "]";
            }
        }

        public static class Circle extends Shape {
            protected double radius;
            public Circle() { this(1); }
            public Circle(double radius) { this(radius, "blue", false); }
            public Circle(double radius, String color, boolean filled) {
                super(color, filled);
                setRadius(radius);
            }
            public double getRadius() { return radius; }
            public void setRadius(double radius) {
                if (radius <= 0) throw new IllegalArgumentException("Радиус > 0");
                this.radius = radius;
            }
            @Override
            public double getArea() { return Math.PI * radius * radius; }
            @Override
            public double getPerimeter() { return 2 * Math.PI * radius; }
            @Override
            public String toString() {
                return "Circle[radius=" + radius + ", " + super.toString() + "]";
            }
        }

        public static class Rectangle extends Shape {
            protected double width, length;
            public Rectangle() { this(1, 1); }
            public Rectangle(double width, double length) {
                this(width, length, "blue", false);
            }
            public Rectangle(double width, double length,
                             String color, boolean filled) {
                super(color, filled);
                if (width <= 0 || length <= 0) {
                    throw new IllegalArgumentException("Стороны > 0");
                }
                this.width = width;
                this.length = length;
            }
            public double getWidth() { return width; }
            public double getLength() { return length; }
            public void setWidth(double width) {
                if (width <= 0) throw new IllegalArgumentException("Ширина > 0");
                this.width = width;
            }
            public void setLength(double length) {
                if (length <= 0) throw new IllegalArgumentException("Длина > 0");
                this.length = length;
            }
            @Override
            public double getArea() { return width * length; }
            @Override
            public double getPerimeter() { return 2 * (width + length); }
            @Override
            public String toString() {
                return "Rectangle[width=" + width + ", length=" + length
                        + ", " + super.toString() + "]";
            }
        }

        public static class Square extends Rectangle {
            public Square() { this(1); }
            public Square(double side) { this(side, "blue", false); }
            public Square(double side, String color, boolean filled) {
                super(side, side, color, filled);
            }
            public double getSide() { return width; }
            public void setSide(double side) {
                super.setWidth(side);
                super.setLength(side);
            }
            @Override
            public void setWidth(double side) { setSide(side); }
            @Override
            public void setLength(double side) { setSide(side); }
            @Override
            public String toString() {
                return "Square[side=" + getSide() + ", color=" + color
                        + ", filled=" + filled + "]";
            }
        }

        public static class PolymorphismExercise {
            public static void main(String[] args) {
                Shape s1 = new Circle(5.5, "RED", false);
                System.out.println(s1);
                System.out.println(s1.getArea());
                System.out.println(s1.getPerimeter());
                System.out.println(s1.getColor());
                System.out.println(s1.isFilled());
                System.out.println(((Circle) s1).getRadius());
                Circle c1 = (Circle) s1;
                System.out.println(c1);
                System.out.println(c1.getArea());
                System.out.println(c1.getPerimeter());
                System.out.println(c1.getColor());
                System.out.println(c1.isFilled());
                System.out.println(c1.getRadius());
                // Shape s2 = new Shape(); // удалено: Shape абстрактный
                Shape s3 = new Rectangle(1.0, 2.0, "RED", false);
                System.out.println(s3);
                System.out.println(s3.getArea());
                System.out.println(s3.getPerimeter());
                System.out.println(s3.getColor());
                System.out.println(((Rectangle) s3).getLength());
                Rectangle r1 = (Rectangle) s3;
                System.out.println(r1);
                System.out.println(r1.getArea());
                System.out.println(r1.getColor());
                System.out.println(r1.getLength());
                Shape s4 = new Square(6.6);
                System.out.println(s4);
                System.out.println(s4.getArea());
                System.out.println(s4.getColor());
                System.out.println(((Square) s4).getSide());
                Rectangle r2 = (Rectangle) s4;
                System.out.println(r2);
                System.out.println(r2.getArea());
                System.out.println(r2.getColor());
                System.out.println(((Square) r2).getSide());
                System.out.println(r2.getLength());
                Square sq1 = (Square) r2;
                System.out.println(sq1);
                System.out.println(sq1.getArea());
                System.out.println(sq1.getColor());
                System.out.println(sq1.getSide());
                System.out.println(sq1.getLength());
            }
        }
    }
}
