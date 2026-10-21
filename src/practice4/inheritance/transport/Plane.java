// Практическая работа 4, раздел 4.1. Задание 10 Транспортные средства.
package practice4.inheritance.transport;
public class Plane extends Transport {
    public Plane(String name) { super(name, 700, 8, 30); }
    @Override public String getType() { return "Самолёт"; }
}
