// Практическая работа 2. Дополнительный пример Классы Ball и TestBall.
package practice2;
public class Ball {
    private double x, y;
    private double xSpeed, ySpeed;
    public Ball() { this(0, 0); }
    public Ball(double x, double y) { setXY(x, y); }
    public double getX() { return x; }
    public double getY() { return y; }
    public void setX(double x) { this.x = x; }
    public void setY(double y) { this.y = y; }
    public void setXY(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public void setXYSpeed(double xSpeed, double ySpeed) {
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }
    public void move(double xDisp, double yDisp) {
        x += xDisp;
        y += yDisp;
    }
    public void move() { move(xSpeed, ySpeed); }
    @Override
    public String toString() { return "Ball @ (" + x + ", " + y + ")"; }
}
