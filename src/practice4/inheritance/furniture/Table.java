// Практическая работа 4, раздел 4.1. Задание 9 Магазин мебели.
package practice4.inheritance.furniture;
public class Table extends Furniture {
    public Table(String material, int price) { super(material, price); }
    @Override public String getType() { return "Стол"; }
    @Override public String getPurpose() { return "для работы"; }
}
