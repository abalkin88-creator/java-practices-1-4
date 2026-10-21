// Практическая работа 3. Задание 2 Интерфейс Movable и движущиеся фигуры.
package practice3.movable;
public class MovableCircle implements Movable {
    private final int radius;
    private final MovablePoint center;
    public MovableCircle(int x, int y, int xSpeed, int ySpeed, int radius) {
        if (radius <= 0) throw new IllegalArgumentException("Радиус > 0");
        this.radius = radius;
        center = new MovablePoint(x, y, xSpeed, ySpeed);
    }
    @Override public void moveUp() { center.moveUp(); }
    @Override public void moveDown() { center.moveDown(); }
    @Override public void moveLeft() { center.moveLeft(); }
    @Override public void moveRight() { center.moveRight(); }
    @Override
    public String toString() {
        return "Circle[center=" + center + ", radius=" + radius + "]";
    }
}
