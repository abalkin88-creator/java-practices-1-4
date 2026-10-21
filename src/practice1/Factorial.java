// Практическая работа 1. Задание 7 Факториал.
package practice1;
public class Factorial {
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
