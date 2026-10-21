// Практическая работа 3. Задание 2 Интерфейс Movable и движущиеся фигуры.
package practice3.movable;
public class MovableRectangle implements Movable {
    private final MovablePoint topLeft, bottomRight;
    public MovableRectangle(int x1, int y1, int x2, int y2,
                            int xSpeed, int ySpeed) {
        this(x1, y1, x2, y2, xSpeed, ySpeed, xSpeed, ySpeed);
    }
    public MovableRectangle(int x1, int y1, int x2, int y2,
                            int vx1, int vy1, int vx2, int vy2) {
        if (x1 >= x2 || y1 >= y2) {
            throw new IllegalArgumentException("Некорректные углы");
        }
        topLeft = new MovablePoint(x1, y1, vx1, vy1);
        bottomRight = new MovablePoint(x2, y2, vx2, vy2);
        if (!hasSameSpeed()) {
            throw new IllegalArgumentException("Скорости углов различаются");
        }
    }
    public boolean hasSameSpeed() {
        return topLeft.xSpeed == bottomRight.xSpeed
                && topLeft.ySpeed == bottomRight.ySpeed;
    }
    @Override public void moveUp() {
        topLeft.moveUp(); bottomRight.moveUp();
    }
    @Override public void moveDown() {
        topLeft.moveDown(); bottomRight.moveDown();
    }
    @Override public void moveLeft() {
        topLeft.moveLeft(); bottomRight.moveLeft();
    }
    @Override public void moveRight() {
        topLeft.moveRight(); bottomRight.moveRight();
    }
    @Override
    public String toString() {
        return "Rectangle[topLeft=" + topLeft
                + ", bottomRight=" + bottomRight + "]";
    }
}
