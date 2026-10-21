// ФИНАЛ. Практическая работа 3: все задания в одном файле.
// Запустите Final и выберите номер задания из меню.
// Каждый блок Task содержит классы одного задания; их имена сохранены.
package practice3;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;

public class Final {
    public static void main(String[] args) throws IOException {
        String choice;
        String[] taskArgs;
        if (args.length == 0) {
            System.out.println("Практическая работа 3. Выберите задание:");
            System.out.println("1 — Задание 1 Абстрактный класс Shape");
            System.out.println("2 — Задание 2 Интерфейс Movable и движущиеся фигуры");
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
            case "1": Task1.TestShape.main(taskArgs); break;
            case "2": Task2.TestMovable.main(taskArgs); break;
            default: System.out.println("Такого задания нет. Выберите номер из меню.");
        }
    }

    // ================================================================
    // Задание 1 Абстрактный класс Shape
    // Реализовать UML-иерархию Shape, Circle, Rectangle и Square. Shape содержит protected-поля color и filled, конструкторы, геттеры и сеттеры, абстрактные getArea и getPerimeter. Переопределить методы в подклассах, написать тест и объяснить полиморфизм и ошибки из предложенного фрагмента.
    // ================================================================
    public static class Task1 {
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
    // Задание 2 Интерфейс Movable и движущиеся фигуры
    // Создать интерфейс Movable и реализующие его MovablePoint и MovableCircle. Дополнительно создать MovableRectangle, представленный двумя движущимися точками. Написать метод проверки равенства скоростей углов и тест.
    // ================================================================
    public static class Task2 {
        public interface Movable {
            void moveUp();
            void moveDown();
            void moveLeft();
            void moveRight();
        }

        public static class MovablePoint implements Movable {
            int x, y, xSpeed, ySpeed;
            public MovablePoint(int x, int y, int xSpeed, int ySpeed) {
                this.x = x; this.y = y;
                this.xSpeed = xSpeed; this.ySpeed = ySpeed;
            }
            @Override public void moveUp() { y -= ySpeed; }
            @Override public void moveDown() { y += ySpeed; }
            @Override public void moveLeft() { x -= xSpeed; }
            @Override public void moveRight() { x += xSpeed; }
            @Override
            public String toString() {
                return "(" + x + ", " + y + "), v=(" + xSpeed + ", " + ySpeed + ")";
            }
        }

        public static class MovableCircle implements Movable {
            private final int radius;
            private final MovablePoint center;
            public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
                if (radius <= 0) throw new IllegalArgumentException("Радиус > 0");
                this.radius = radius;
                center = new MovablePoint(x, y, xSpeed, ySpeed);
            }
            @Override public void moveUp() { center.moveUp(); }
            @Override public void moveDown() { center.moveDown(); }
            @Override public void moveLeft() { center.moveLeft(); }
            @Override public void moveRight() { center.moveRight(); }
            @Override
            public String toString() {
                return "Circle[center=" + center + ", radius=" + radius + "]";
            }
        }

        public static class MovableRectangle implements Movable {
            private final MovablePoint topLeft, bottomRight;
            public MovableRectangle(int x1, int y1, int x2, int y2,
                                    int xSpeed, int ySpeed) {
                this(x1, y1, x2, y2, xSpeed, ySpeed, xSpeed, ySpeed);
            }
            public MovableRectangle(int x1, int y1, int x2, int y2,
                                    int vx1, int vy1, int vx2, int vy2) {
                if (x1 >= x2 || y1 >= y2) {
                    throw new IllegalArgumentException("Некорректные углы");
                }
                topLeft = new MovablePoint(x1, y1, vx1, vy1);
                bottomRight = new MovablePoint(x2, y2, vx2, vy2);
                if (!hasSameSpeed()) {
                    throw new IllegalArgumentException("Скорости углов различаются");
                }
            }
            public boolean hasSameSpeed() {
                return topLeft.xSpeed == bottomRight.xSpeed
                        && topLeft.ySpeed == bottomRight.ySpeed;
            }
            @Override public void moveUp() {
                topLeft.moveUp(); bottomRight.moveUp();
            }
            @Override public void moveDown() {
                topLeft.moveDown(); bottomRight.moveDown();
            }
            @Override public void moveLeft() {
                topLeft.moveLeft(); bottomRight.moveLeft();
            }
            @Override public void moveRight() {
                topLeft.moveRight(); bottomRight.moveRight();
            }
            @Override
            public String toString() {
                return "Rectangle[topLeft=" + topLeft
                        + ", bottomRight=" + bottomRight + "]";
            }
        }

        public static class TestMovable {
            public static void main(String[] args) {
                Movable[] objects = {
                    new MovablePoint(2, 6, 1, 2),
                    new MovableCircle(4, 8, 2, 3, 5),
                    new MovableRectangle(0, 0, 6, 4, 1, 2)
                };
                for (Movable object : objects) {
                    System.out.println("До: " + object);
                    object.moveUp(); object.moveRight();
                    System.out.println("После: " + object);
                    object.moveLeft(); object.moveDown();
                    System.out.println("Возврат: " + object);
                }
                MovableRectangle r = (MovableRectangle) objects[2];
                System.out.println("Скорости совпадают: " + r.hasSameSpeed());
                try {
                    new MovableRectangle(0, 0, 6, 4, 1, 2, 3, 2);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
