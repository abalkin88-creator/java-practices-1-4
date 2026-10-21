// ФИНАЛ. Практическая работа 1: все задания в одном файле.
// Запустите Final и выберите номер задания из меню.
// Каждый блок Task содержит классы одного задания; их имена сохранены.
package practice1;

import java.io.IOException;
import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class Final {
    public static void main(String[] args) throws IOException {
        String choice;
        String[] taskArgs;
        if (args.length == 0) {
            System.out.println("Практическая работа 1. Выберите задание:");
            System.out.println("3 — Задание 3 Сумма и среднее арифметическое");
            System.out.println("4 — Задание 4 Ввод массива и циклы while и do while");
            System.out.println("5 — Задание 5 Аргументы командной строки");
            System.out.println("6 — Задание 6 Гармонический ряд");
            System.out.println("7 — Задание 7 Факториал");
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
            case "3": Task1.ArrayFor.main(taskArgs); break;
            case "4": Task2.ArrayInput.main(taskArgs); break;
            case "5": Task3.Arguments.main(taskArgs); break;
            case "6": Task4.Harmonic.main(taskArgs); break;
            case "7": Task5.Factorial.main(taskArgs); break;
            default: System.out.println("Такого задания нет. Выберите номер из меню.");
        }
    }

    // ================================================================
    // Задание 3 Сумма и среднее арифметическое
    // Создать целочисленный массив с помощью инициализации. В цикле for вычислить сумму его элементов и среднее арифметическое. Вывести результаты на экран.
    // ================================================================
    public static class Task1 {
        public static class ArrayFor {
            public static void main(String[] args) {
                int[] values = {8, -3, 15, 0, 10};
                long sum = 0;
                for (int i = 0; i < values.length; i++) {
                    sum += values[i];
                }
                double mean = (double) sum / values.length;
                System.out.println("Массив: " + Arrays.toString(values));
                System.out.println("Сумма: " + sum);
                System.out.println("Среднее: " + mean);
            }
        }
    }
    // ================================================================
    // Задание 4 Ввод массива и циклы while и do while
    // Ввести массив с клавиатуры. Найти сумму элементов циклами while и do-while, определить минимальный и максимальный элементы.
    // ================================================================
    public static class Task2 {
        public static class ArrayInput {
            public static void main(String[] args) {
                Scanner in = new Scanner(System.in);
                System.out.println("Введите размер массива и его элементы:");
                int n = in.nextInt();
                if (n <= 0) {
                    System.out.println("Размер должен быть положительным");
                    return;
                }
                int[] values = new int[n];
                int i = 0;
                while (i < n) {
                    values[i] = in.nextInt();
                    i++;
                }
                long sumWhile = 0;
                i = 0;
                while (i < n) {
                    sumWhile += values[i];
                    i++;
                }
                long sumDo = 0;
                int min = values[0], max = values[0];
                i = 0;
                do {
                    sumDo += values[i];
                    if (values[i] < min) min = values[i];
                    if (values[i] > max) max = values[i];
                    i++;
                } while (i < n);
                System.out.println("Сумма while: " + sumWhile);
                System.out.println("Сумма do-while: " + sumDo);
                System.out.println("Минимум: " + min);
                System.out.println("Максимум: " + max);
            }
        }
    }
    // ================================================================
    // Задание 5 Аргументы командной строки
    // Вывести аргументы командной строки в цикле for.
    // ================================================================
    public static class Task3 {
        public static class Arguments {
            public static void main(String[] args) {
                if (args.length == 0) {
                    System.out.println("Аргументы не переданы");
                }
                for (int i = 0; i < args.length; i++) {
                    System.out.println(i + ": " + args[i]);
                }
            }
        }
    }
    // ================================================================
    // Задание 6 Гармонический ряд
    // Вывести первые десять членов гармонического ряда 1, 1/2, 1/3, ... с форматированием результата.
    // ================================================================
    public static class Task4 {
        public static class Harmonic {
            public static void main(String[] args) {
                for (int i = 1; i <= 10; i++) {
                    System.out.printf(Locale.US, "1/%-2d = %.6f%n", i, 1.0 / i);
                }
            }
        }
    }
    // ================================================================
    // Задание 7 Факториал
    // Реализовать метод класса для вычисления факториала с помощью цикла. Проверить его работу.
    // ================================================================
    public static class Task5 {
        public static class Factorial {
            public static long factorial(int n) {
                if (n < 0 || n > 20) {
                    throw new IllegalArgumentException("Допустимо 0 <= n <= 20");
                }
                long value = 1;
                for (int i = 2; i <= n; i++) value *= i;
                return value;
            }
            public static void main(String[] args) {
                for (int n : new int[]{0, 1, 6, 20}) {
                    System.out.println(n + "! = " + factorial(n));
                }
                try {
                    factorial(-1);
                } catch (IllegalArgumentException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }
}
