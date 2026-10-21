// Практическая работа 4, раздел 4.1. Задание 6 Сотрудник и менеджер.
package practice4.inheritance.employees;
public class Employer {
    protected final String firstName, lastName;
    protected final double income;
    public Employer(String firstName, String lastName, double income) {
        this.firstName = firstName; this.lastName = lastName;
        this.income = income;
    }
    public double getIncome() { return income * 12; }
    @Override public String toString() { return firstName + " " + lastName; }
}
