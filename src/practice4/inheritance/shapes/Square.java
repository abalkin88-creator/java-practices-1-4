// Практическая работа 4, раздел 4.1. Задание 1 Наследование геометрических фигур.
package practice4.inheritance.shapes;
public class Square extends Rectangle {
    public Square(double side) { super(side, side); }
    @Override public String getType() { return "Квадрат"; }
    @Override public double getArea() { return width * width; }
    @Override public double getPerimeter() { return 4 * width; }
    @Override public String toString() { return getType() + ": сторона " + width; }
}
