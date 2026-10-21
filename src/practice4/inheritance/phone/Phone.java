// Практическая работа 4, раздел 4.1. Задание 2 Телефон.
package practice4.inheritance.phone;
public class Phone {
    private String number, model;
    private double weight;
    public Phone() { this("не задан", "не задан", 0); }
    public Phone(String number, String model) {
        this.number = number; this.model = model;
    }
    public Phone(String number, String model, double weight) {
        this(number, model);
        this.weight = weight;
    }
    public String getNumber() { return number; }
    public void receiveCall(String name) {
        System.out.println("Звонит " + name);
    }
    public void receiveCall(String name, String callerNumber) {
        System.out.println("Звонит " + name + ", " + callerNumber);
    }
    public void sendMessage(String... numbers) {
        for (String recipient : numbers) {
            System.out.println("Сообщение для " + recipient);
        }
    }
    @Override public String toString() {
        return number + "; " + model + "; " + weight + " г";
    }
    public static void main(String[] args) {
        Phone[] phones = {
            new Phone("+70000000001", "Model A", 170),
            new Phone("+70000000002", "Model B"), new Phone()
        };
        for (Phone phone : phones) {
            System.out.println(phone);
            phone.receiveCall("Елена");
            System.out.println("Номер: " + phone.getNumber());
        }
        phones[0].receiveCall("Олег", "+70000000003");
        phones[0].sendMessage("+70000000004", "+70000000005");
    }
}
