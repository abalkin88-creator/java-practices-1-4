// Практическая работа 4. Задание 4 Компьютер.
package practice4.computer;
public class Computer {
    private final Brand brand;
    private final Processor processor;
    private final Memory memory;
    private final Monitor monitor;
    public Computer(Brand brand, Processor processor,
                    Memory memory, Monitor monitor) {
        this.brand = brand; this.processor = processor;
        this.memory = memory; this.monitor = monitor;
    }
    public Brand getBrand() { return brand; }
    public Processor getProcessor() { return processor; }
    public Memory getMemory() { return memory; }
    public Monitor getMonitor() { return monitor; }
    @Override public String toString() {
        return brand + "; CPU: " + processor + "; RAM: " + memory
                + "; экран: " + monitor;
    }
    public static void main(String[] args) {
        Computer pc = new Computer(Brand.LENOVO,
                new Processor("Ryzen 5 5600", 6, 3.5),
                new Memory(16, "DDR4"), new Monitor(23.8, "1920x1080"));
        System.out.println(pc.getBrand());
        System.out.println(pc.getProcessor());
        System.out.println(pc.getMemory());
        System.out.println(pc.getMonitor());
        System.out.println("Ядер: " + pc.getProcessor().getCores());
    }
}
