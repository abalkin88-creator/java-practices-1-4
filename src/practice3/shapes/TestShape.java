// Практическая работа 3. Задание 1 Абстрактный класс Shape.
package practice3.shapes;
import java.util.Locale;
public class TestShape {
    private static void print(Shape shape) {
        System.out.println(shape);
        System.out.printf(Locale.US, "S=%.4f; P=%.4f%n",
                shape.getArea(), shape.getPerimeter());
        System.out.println(shape.getColor() + "; " + shape.isFilled());
    }
    public static void main(String[] args) {
        Shape s1 = new Circle(5.5, "RED", false);
        print(s1);
        Circle c1 = (Circle) s1;
        System.out.println("Радиус: " + c1.getRadius());
        Shape s3 = new Rectangle(1, 2, "RED", false);
        print(s3);
        Rectangle r1 = (Rectangle) s3;
        System.out.println("Длина: " + r1.getLength());
        Shape s4 = new Square(6.6);
        print(s4);
        Rectangle r2 = (Rectangle) s4;
        System.out.println("Длина через Rectangle: " + r2.getLength());
        Square sq1 = (Square) r2;
        System.out.println("Сторона: " + sq1.getSide());
        sq1.setWidth(3);
        System.out.println("После setWidth: " + sq1.getWidth()
                + " x " + sq1.getLength());
        // new Shape();          // нельзя создать абстрактный класс
        // s1.getRadius();       // у Shape нет getRadius
        // s3.getLength();       // у Shape нет getLength
        // s4.getSide();         // у Shape нет getSide
        // r2.getSide();         // у Rectangle нет getSide
        Shape[] figures = {new Circle(), new Rectangle(), new Square()};
        for (Shape shape : figures) print(shape);
    }
}
