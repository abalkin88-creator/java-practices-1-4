// Практическая работа 4, раздел 4.1. Задание 10 Транспортные средства.
package practice4.inheritance.transport;
public class Train extends Transport {
    public Train(String name) { super(name, 100, 2, 6); }
    @Override public String getType() { return "Поезд"; }
}
