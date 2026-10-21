// Практическая работа 4. Задание 4 Компьютер.
package practice4.computer;
public class Monitor {
    private final double diagonal;
    private final String resolution;
    public Monitor(double diagonal, String resolution) {
        this.diagonal = diagonal; this.resolution = resolution;
    }
    public double getDiagonal() { return diagonal; }
    public String getResolution() { return resolution; }
    @Override public String toString() {
        return diagonal + " дюйма, " + resolution;
    }
}
