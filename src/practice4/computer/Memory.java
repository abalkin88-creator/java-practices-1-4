// Практическая работа 4. Задание 4 Компьютер.
package practice4.computer;
public class Memory {
    private final int capacity;
    private final String type;
    public Memory(int capacity, String type) {
        this.capacity = capacity; this.type = type;
    }
    public int getCapacity() { return capacity; }
    public String getType() { return type; }
    @Override public String toString() { return capacity + " ГБ " + type; }
}
