// Практическая работа 4, раздел 4.1. Задание 7 Учащиеся.
package practice4.inheritance.learners;
public class Learner {
    protected final String name;
    public Learner(String name) { this.name = name; }
    @Override public String toString() { return name; }
}
