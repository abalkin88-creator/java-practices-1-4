// Практическая работа 4, раздел 4.1. Задание 10 Транспортные средства.
package practice4.inheritance.transport;
public class Car extends Transport {
    public Car(String name) { super(name, 80, 3, 12); }
    @Override public String getType() { return "Автомобиль"; }
}
