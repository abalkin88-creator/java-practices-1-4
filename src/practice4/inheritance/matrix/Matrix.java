// Практическая работа 4, раздел 4.1. Задание 4 Матрица.
package practice4.inheritance.matrix;
import java.util.Arrays;
public class Matrix {
    private final double[][] data;
    private final int rows, columns;
    public Matrix(double[][] source) {
        if (source.length == 0 || source[0].length == 0) {
            throw new IllegalArgumentException("Матрица пуста");
        }
        rows = source.length; columns = source[0].length;
        data = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            if (source[i].length != columns) {
                throw new IllegalArgumentException("Строки разной длины");
            }
            data[i] = source[i].clone();
        }
    }
    public Matrix add(Matrix other) {
        if (rows != other.rows || columns != other.columns) {
            throw new IllegalArgumentException("Размеры не совпадают");
        }
        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = data[i][j] + other.data[i][j];
            }
        }
        return new Matrix(result);
    }
    public Matrix multiply(double factor) {
        double[][] result = new double[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                result[i][j] = data[i][j] * factor;
            }
        }
        return new Matrix(result);
    }
    public Matrix multiply(Matrix other) {
        if (columns != other.rows) {
            throw new IllegalArgumentException("Несовместимые размеры");
        }
        double[][] result = new double[rows][other.columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < other.columns; j++) {
                for (int k = 0; k < columns; k++) {
                    result[i][j] += data[i][k] * other.data[k][j];
                }
            }
        }
        return new Matrix(result);
    }
    public void print() {
        for (double[] row : data) System.out.println(Arrays.toString(row));
    }
    public static void main(String[] args) {
        Matrix a = new Matrix(new double[][]{{1, 2, 3}, {4, 5, 6}});
        Matrix b = new Matrix(new double[][]{{6, 5, 4}, {3, 2, 1}});
        Matrix c = new Matrix(new double[][]{{1, 0}, {0, 1}, {1, 1}});
        System.out.println("A + B:"); a.add(b).print();
        System.out.println("A * 2:"); a.multiply(2).print();
        System.out.println("A * C:"); a.multiply(c).print();
        try {
            a.multiply(b);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
