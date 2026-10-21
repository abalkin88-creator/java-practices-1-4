// Практическая работа 3. Задание 2 Интерфейс Movable и движущиеся фигуры.
package practice3.movable;
public class TestMovable {
    public static void main(String[] args) {
        Movable[] objects = {
            new MovablePoint(2, 6, 1, 2),
            new MovableCircle(4, 8, 2, 3, 5),
            new MovableRectangle(0, 0, 6, 4, 1, 2)
        };
        for (Movable object : objects) {
            System.out.println("До: " + object);
            object.moveUp(); object.moveRight();
            System.out.println("После: " + object);
            object.moveLeft(); object.moveDown();
            System.out.println("Возврат: " + object);
        }
        MovableRectangle r = (MovableRectangle) objects[2];
        System.out.println("Скорости совпадают: " + r.hasSameSpeed());
        try {
            new MovableRectangle(0, 0, 6, 4, 1, 2, 3, 2);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
