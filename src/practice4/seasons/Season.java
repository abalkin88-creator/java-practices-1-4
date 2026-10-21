// Практическая работа 4. Задание 1 Времена года.
package practice4.seasons;
public enum Season {
    WINTER("Зима", -8), SPRING("Весна", 7),
    SUMMER("Лето", 21) {
        @Override public String getDescription() {
            return "Теплое время года";
        }
    },
    AUTUMN("Осень", 6);
    private final String title;
    private final double temperature;
    Season(String title, double temperature) {
        this.title = title;
        this.temperature = temperature;
    }
    public double getTemperature() { return temperature; }
    public String getDescription() { return "Холодное время года"; }
    @Override public String toString() { return title; }
}
