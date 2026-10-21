// Практическая работа 4, раздел 4.1. Задание 9 Магазин мебели.
package practice4.inheritance.furniture;
public abstract class Furniture {
    protected final String material;
    protected final int price;
    public Furniture(String material, int price) {
        this.material = material; this.price = price;
    }
    public int getPrice() { return price; }
    public abstract String getType();
    public abstract String getPurpose();
    @Override public String toString() {
        return getType() + ": " + material + ", " + price
                + " руб., " + getPurpose();
    }
}
