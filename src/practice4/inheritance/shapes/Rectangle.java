// Практическая работа 4, раздел 4.1. Задание 1 Наследование геометрических фигур.
package practice4.inheritance.shapes;
public class Rectangle extends Shape {
    protected final double width, length;
    public Rectangle(double width, double length) {
        this.width = width; this.length = length;
    }
    @Override public String getType() { return "Прямоугольник"; }
    @Override public double getArea() { return width * length; }
    @Override public double getPerimeter() { return 2 * (width + length); }
    @Override public String toString() {
        return getType() + ": " + width + " x " + length;
    }
}
