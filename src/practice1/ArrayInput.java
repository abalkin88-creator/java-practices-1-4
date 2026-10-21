// Практическая работа 1. Задание 4 Ввод массива и циклы while и do while.
package practice1;
import java.util.Scanner;
public class ArrayInput {
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
