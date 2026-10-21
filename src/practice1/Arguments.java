// Практическая работа 1. Задание 5 Аргументы командной строки.
package practice1;
public class Arguments {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Аргументы не переданы");
        }
        for (int i = 0; i < args.length; i++) {
            System.out.println(i + ": " + args[i]);
        }
    }
}
