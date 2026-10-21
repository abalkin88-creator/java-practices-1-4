// Практическая работа 4, раздел 4.1. Задание 1 Наследование геометрических фигур.
package practice4.inheritance.shapes;
public class Shape {
    public String getType() { return "Фигура"; }
    public double getArea() { return 0; }
    public double getPerimeter() { return 0; }
    @Override public String toString() { return getType(); }
}
