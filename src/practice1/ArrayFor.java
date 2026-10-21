// Практическая работа 1. Задание 3 Сумма и среднее арифметическое.
package practice1;
import java.util.Arrays;
public class ArrayFor {
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
