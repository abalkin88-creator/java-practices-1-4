// Практическая работа 4. Задание 2 Ателье.
package practice4.atelier;
public class Atelier {
    public void dressMan(Clothes[] clothes) {
        for (Clothes item : clothes) {
            if (item instanceof MenClothing) {
                ((MenClothing) item).dressMan();
            }
        }
    }
    public void dressWomen(Clothes[] clothes) {
        for (Clothes item : clothes) {
            if (item instanceof WomenClothing) {
                ((WomenClothing) item).dressWomen();
            }
        }
    }
    public static void main(String[] args) {
        Clothes[] clothes = {
            new TShirt(Size.XXS, 700, "белый"),
            new Pants(Size.M, 2400, "серый"),
            new Skirt(Size.S, 1800, "синий"),
            new Tie(Size.L, 900, "бордовый")
        };
        Atelier atelier = new Atelier();
        System.out.println("Женская одежда:");
        atelier.dressWomen(clothes);
        System.out.println("Мужская одежда:");
        atelier.dressMan(clothes);
        for (Size size : Size.values()) {
            System.out.println(size + " -> " + size.getEuroSize()
                    + ": " + size.getDescription());
        }
    }
}
