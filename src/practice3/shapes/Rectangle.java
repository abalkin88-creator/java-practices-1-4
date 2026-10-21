// Практическая работа 3. Задание 1 Абстрактный класс Shape.
package practice3.shapes;
public class Rectangle extends Shape {
    protected double width, length;
    public Rectangle() { this(1, 1); }
    public Rectangle(double width, double length) {
        this(width, length, "blue", false);
    }
    public Rectangle(double width, double length,
                     String color, boolean filled) {
        super(color, filled);
        if (width <= 0 || length <= 0) {
            throw new IllegalArgumentException("Стороны > 0");
        }
        this.width = width;
        this.length = length;
    }
    public double getWidth() { return width; }
    public double getLength() { return length; }
    public void setWidth(double width) {
        if (width <= 0) throw new IllegalArgumentException("Ширина > 0");
        this.width = width;
    }
    public void setLength(double length) {
        if (length <= 0) throw new IllegalArgumentException("Длина > 0");
        this.length = length;
    }
    @Override
    public double getArea() { return width * length; }
    @Override
    public double getPerimeter() { return 2 * (width + length); }
    @Override
    public String toString() {
        return "Rectangle[width=" + width + ", length=" + length
                + ", " + super.toString() + "]";
    }
}
