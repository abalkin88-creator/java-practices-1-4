// Практическая работа 1. Задание 6 Гармонический ряд.
package practice1;
import java.util.Locale;
public class Harmonic {
    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.printf(Locale.US, "1/%-2d = %.6f%n", i, 1.0 / i);
        }
    }
}
