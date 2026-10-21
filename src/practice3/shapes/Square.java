// Практическая работа 3. Задание 1 Абстрактный класс Shape.
package practice3.shapes;
public class Square extends Rectangle {
    public Square() { this(1); }
    public Square(double side) { this(side, "blue", false); }
    public Square(double side, String color, boolean filled) {
        super(side, side, color, filled);
    }
    public double getSide() { return width; }
    public void setSide(double side) {
        super.setWidth(side);
        super.setLength(side);
    }
    @Override
    public void setWidth(double side) { setSide(side); }
    @Override
    public void setLength(double side) { setSide(side); }
    @Override
    public String toString() {
        return "Square[side=" + getSide() + ", color=" + color
                + ", filled=" + filled + "]";
    }
}
