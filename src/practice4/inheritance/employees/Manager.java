// Практическая работа 4, раздел 4.1. Задание 6 Сотрудник и менеджер.
package practice4.inheritance.employees;
public class Manager extends Employer {
    private final double averageSum;
    public Manager(String firstName, String lastName,
                   double income, double averageSum) {
        super(firstName, lastName, income);
        this.averageSum = averageSum;
    }
    @Override public double getIncome() {
        return super.getIncome() + averageSum;
    }
    public static void main(String[] args) {
        Employer reference = new Manager("Антон", "Белов", 60000, 90000);
        System.out.println(reference + ": " + reference.getIncome());
        Employer[] workers = {
            new Employer("Ольга", "Семенова", 50000), reference,
            new Manager("Ирина", "Котова", 70000, 120000)
        };
        for (Employer worker : workers) {
            System.out.println(worker + ": годовой доход " + worker.getIncome());
        }
    }
}
