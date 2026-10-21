// Практическая работа 4, раздел 4.1. Задание 7 Учащиеся.
package practice4.inheritance.learners;
public class SchoolStudent extends Learner {
    private final int schoolClass;
    public SchoolStudent(String name, int schoolClass) {
        super(name); this.schoolClass = schoolClass;
    }
    @Override public String toString() {
        return name + ", класс " + schoolClass;
    }
}
