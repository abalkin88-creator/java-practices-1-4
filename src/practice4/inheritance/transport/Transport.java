// Практическая работа 4, раздел 4.1. Задание 10 Транспортные средства.
package practice4.inheritance.transport;
public abstract class Transport {
    private final String name;
    private final double speed, passengerRate, cargoRate;
    public Transport(String name, double speed,
                     double passengerRate, double cargoRate) {
        this.name = name; this.speed = speed;
        this.passengerRate = passengerRate; this.cargoRate = cargoRate;
    }
    public double time(double distance) {
        if (distance < 0) throw new IllegalArgumentException("Расстояние >= 0");
        return distance / speed;
    }
    public double passengerCost(double distance, int passengers) {
        if (passengers < 0) throw new IllegalArgumentException("Пассажиры >= 0");
        time(distance);
        return distance * passengers * passengerRate;
    }
    public double cargoCost(double distance, double tons) {
        if (tons < 0) throw new IllegalArgumentException("Груз >= 0");
        time(distance);
        return distance * tons * cargoRate;
    }
    public abstract String getType();
    @Override public String toString() { return getType() + " " + name; }
}
