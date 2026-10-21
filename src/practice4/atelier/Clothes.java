// Практическая работа 4. Задание 2 Ателье.
package practice4.atelier;
public abstract class Clothes {
    protected final Size size;
    protected final int price;
    protected final String color;
    public Clothes(Size size, int price, String color) {
        this.size = size; this.price = price; this.color = color;
    }
    @Override public String toString() {
        return getClass().getSimpleName() + ": " + size
                + ", EU " + size.getEuroSize() + ", " + size.getDescription()
                + ", " + color + ", " + price + " руб.";
    }
}
