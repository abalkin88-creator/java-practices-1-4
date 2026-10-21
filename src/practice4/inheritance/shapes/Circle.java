// Практическая работа 4, раздел 4.1. Задание 1 Наследование геометрических фигур.
package practice4.inheritance.shapes;
public class Circle extends Shape {
    private final double radius;
    public Circle(double radius) { this.radius = radius; }
    @Override public String getType() { return "Круг"; }
    @Override public double getArea() { return Math.PI * radius * radius; }
    @Override public double getPerimeter() { return 2 * Math.PI * radius; }
    @Override public String toString() {
        return getType() + ": радиус " + radius;
    }
}
