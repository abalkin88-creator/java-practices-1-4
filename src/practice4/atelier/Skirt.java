// Практическая работа 4. Задание 2 Ателье.
package practice4.atelier;
public class Skirt extends Clothes implements WomenClothing {
    public Skirt(Size size, int price, String color) {
        super(size, price, color);
    }
    @Override public void dressWomen() {
        System.out.println(this);
    }
}
