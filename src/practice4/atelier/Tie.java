// Практическая работа 4. Задание 2 Ателье.
package practice4.atelier;
public class Tie extends Clothes implements MenClothing {
    public Tie(Size size, int price, String color) {
        super(size, price, color);
    }
    @Override public void dressMan() {
        System.out.println(this);
    }
}
