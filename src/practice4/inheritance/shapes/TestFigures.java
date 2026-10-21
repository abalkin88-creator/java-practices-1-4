// Практическая работа 4, раздел 4.1. Задание 1 Наследование геометрических фигур.
package practice4.inheritance.shapes;
import java.util.Locale;
public class TestFigures {
    public static void main(String[] args) {
        Shape[] shapes = {new Circle(3), new Rectangle(4, 5), new Square(4)};
        for (Shape shape : shapes) {
            System.out.println(shape);
            System.out.printf(Locale.US, "%s: S=%.3f; P=%.3f%n",
                    shape.getType(), shape.getArea(), shape.getPerimeter());
        }
    }
}
