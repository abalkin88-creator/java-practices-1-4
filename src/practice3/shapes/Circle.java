// Практическая работа 3. Задание 1 Абстрактный класс Shape.
package practice3.shapes;
public class Circle extends Shape {
    protected double radius;
    public Circle() { this(1); }
    public Circle(double radius) { this(radius, "blue", false); }
    public Circle(double radius, String color, boolean filled) {
        super(color, filled);
        setRadius(radius);
    }
    public double getRadius() { return radius; }
    public void setRadius(double radius) {
        if (radius <= 0) throw new IllegalArgumentException("Радиус > 0");
        this.radius = radius;
    }
    @Override
    public double getArea() { return Math.PI * radius * radius; }
    @Override
    public double getPerimeter() { return 2 * Math.PI * radius; }
    @Override
    public String toString() {
        return "Circle[radius=" + radius + ", " + super.toString() + "]";
    }
}
