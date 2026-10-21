// Практическая работа 4, раздел 4.1. Задание 10 Транспортные средства.
package practice4.inheritance.transport;
import java.util.Locale;
public class TestTransport {
    public static void main(String[] args) {
        Transport[] vehicles = {new Car("A"), new Plane("B"),
                                new Train("C"), new Ship("D")};
        double distance = 280;
        for (Transport vehicle : vehicles) {
            System.out.println(vehicle);
            System.out.printf(Locale.US,
                    "Время %.2f ч; 2 пассажира %.2f руб.; груз 3 т %.2f руб.%n",
                    vehicle.time(distance), vehicle.passengerCost(distance, 2),
                    vehicle.cargoCost(distance, 3));
        }
    }
}
