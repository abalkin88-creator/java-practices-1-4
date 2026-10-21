// Практическая работа 4, раздел 4.1. Задание 9 Магазин мебели.
package practice4.inheritance.furniture;
public class FurnitureShop {
    private final Furniture[] catalog;
    public FurnitureShop(Furniture[] catalog) { this.catalog = catalog.clone(); }
    public void showCatalog() {
        for (int i = 0; i < catalog.length; i++) {
            System.out.println((i + 1) + ". " + catalog[i]);
        }
    }
    public int buy(int index) {
        if (index < 0 || index >= catalog.length) {
            throw new IllegalArgumentException("Товар не найден");
        }
        System.out.println("Куплен товар: " + catalog[index].getType());
        return catalog[index].getPrice();
    }
    public static void main(String[] args) {
        FurnitureShop shop = new FurnitureShop(new Furniture[]{
            new Chair("берёза", 3200), new Table("сосна", 7800)
        });
        shop.showCatalog();
        System.out.println("К оплате: " + shop.buy(1) + " руб.");
    }
}
