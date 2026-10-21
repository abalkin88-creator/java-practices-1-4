// Практическая работа 4, раздел 4.1. Задание 3 Человек.
package practice4.inheritance.person;
public class Person {
    private String fullName;
    private int age;
    public Person() { this("Неизвестный", 0); }
    public Person(String fullName, int age) {
        this.fullName = fullName; this.age = age;
    }
    public void move() { System.out.println(fullName + " идёт"); }
    public void talk() { System.out.println(fullName + " говорит"); }
    @Override public String toString() { return fullName + ", возраст " + age; }
    public static void main(String[] args) {
        Person first = new Person();
        Person second = new Person("Мария Смирнова", 19);
        for (Person person : new Person[]{first, second}) {
            System.out.println(person);
            person.move(); person.talk();
        }
    }
}
