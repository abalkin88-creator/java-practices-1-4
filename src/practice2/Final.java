// ФИНАЛ. Практическая работа 2: все задания в одном файле.
// Запустите Final и выберите номер задания из меню.
// Каждый блок Task содержит классы одного задания; их имена сохранены.
package practice2;

import java.io.IOException;
import java.util.Arrays;

public class Final {
    public static void main(String[] args) throws IOException {
        String choice;
        String[] taskArgs;
        if (args.length == 0) {
            System.out.println("Практическая работа 2. Выберите задание:");
            System.out.println("1 — Задание Классы Author и TestAuthor");
            System.out.println("2 — Дополнительный пример Классы Ball и TestBall");
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
            case "1": Task1.TestAuthor.main(taskArgs); break;
            case "2": Task2.TestBall.main(taskArgs); break;
            default: System.out.println("Такого задания нет. Выберите номер из меню.");
        }
    }

    // ================================================================
    // Задание Классы Author и TestAuthor
    // По UML-диаграмме создать класс Author с private-полями name, email и gender, конструктором с тремя параметрами, геттерами, setEmail и toString. Имя и пол после создания объекта не изменяются. Формат строки: имя (пол) at email. Написать TestAuthor.
    // ================================================================
    public static class Task1 {
        public static class Author {
            private final String name;
            private String email;
            private final char gender;
            public Author(String name, String email, char gender) {
                if (gender != 'M' && gender != 'F' && gender != 'U') {
                    throw new IllegalArgumentException("Пол: M, F или U");
                }
                this.name = name;
                this.email = email;
                this.gender = gender;
            }
            public String getName() { return name; }
            public String getEmail() { return email; }
            public char getGender() { return gender; }
            public void setEmail(String email) { this.email = email; }
            @Override
            public String toString() {
                return name + " (" + gender + ") at " + email;
            }
        }

        public static class TestAuthor {
            public static void main(String[] args) {
                Author author = new Author("Анна Орлова", "anna@example.com", 'F');
                System.out.println(author);
                System.out.println("Имя: " + author.getName());
                System.out.println("Пол: " + author.getGender());
                author.setEmail("orlova@example.com");
                System.out.println("Новая почта: " + author.getEmail());
                System.out.println(author);
            }
        }
    }
    // ================================================================
    // Дополнительный пример Классы Ball и TestBall
    // Закрепить работу с классом Ball: координаты, конструкторы, геттеры и сеттеры, setXY, setXYSpeed, перемещение и строковое представление.
    // ================================================================
    public static class Task2 {
        public static class Ball {
            private double x, y;
            private double xSpeed, ySpeed;
            public Ball() { this(0, 0); }
            public Ball(double x, double y) { setXY(x, y); }
            public double getX() { return x; }
            public double getY() { return y; }
            public void setX(double x) { this.x = x; }
            public void setY(double y) { this.y = y; }
            public void setXY(double x, double y) {
                this.x = x;
                this.y = y;
            }
            public void setXYSpeed(double xSpeed, double ySpeed) {
                this.xSpeed = xSpeed;
                this.ySpeed = ySpeed;
            }
            public void move(double xDisp, double yDisp) {
                x += xDisp;
                y += yDisp;
            }
            public void move() { move(xSpeed, ySpeed); }
            @Override
            public String toString() { return "Ball @ (" + x + ", " + y + ")"; }
        }

        public static class TestBall {
            public static void main(String[] args) {
                Ball ball = new Ball();
                System.out.println(ball);
                ball.setXY(4, 9);
                ball.move(3, -2);
                System.out.println(ball);
                ball.setXYSpeed(-1, 2);
                ball.move();
                ball.setX(ball.getX() + 1);
                ball.setY(ball.getY() - 1);
                System.out.println(ball);
            }
        }
    }
}
