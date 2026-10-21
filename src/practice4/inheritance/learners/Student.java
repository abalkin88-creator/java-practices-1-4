// Практическая работа 4, раздел 4.1. Задание 7 Учащиеся.
package practice4.inheritance.learners;
public class Student extends Learner {
    private final String group;
    public Student(String name, String group) { super(name); this.group = group; }
    @Override public String toString() { return name + ", группа " + group; }
}
