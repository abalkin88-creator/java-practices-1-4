// Практическая работа 4, раздел 4.1. Задание 9 Магазин мебели.
package practice4.inheritance.furniture;
public class Chair extends Furniture {
    public Chair(String material, int price) { super(material, price); }
    @Override public String getType() { return "Стул"; }
    @Override public String getPurpose() { return "для сидения"; }
}
