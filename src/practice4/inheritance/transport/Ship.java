// Практическая работа 4, раздел 4.1. Задание 10 Транспортные средства.
package practice4.inheritance.transport;
public class Ship extends Transport {
    public Ship(String name) { super(name, 40, 1, 4); }
    @Override public String getType() { return "Корабль"; }
}
