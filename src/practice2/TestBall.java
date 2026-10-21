// Практическая работа 2. Дополнительный пример Классы Ball и TestBall.
package practice2;
public class TestBall {
    public static void main(String[] args) {
        Ball ball = new Ball();
        System.out.println(ball);
        ball.setXY(4, 9);
        ball.move(3, -2);
        System.out.println(ball);
        ball.setXYSpeed(-1, 2);
        ball.move();
        ball.setX(ball.getX() + 1);
        ball.setY(ball.getY() - 1);
        System.out.println(ball);
    }
}
