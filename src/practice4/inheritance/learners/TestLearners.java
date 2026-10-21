// Практическая работа 4, раздел 4.1. Задание 7 Учащиеся.
package practice4.inheritance.learners;
public class TestLearners {
    public static void main(String[] args) {
        Learner[] learners = {
            new Student("Алина", "ИТ-12"), new SchoolStudent("Павел", 10),
            new Student("Максим", "ИТ-11"), new SchoolStudent("Даша", 9)
        };
        System.out.println("Студенты:");
        for (Learner learner : learners) {
            if (learner instanceof Student) System.out.println(learner);
        }
        System.out.println("Школьники:");
        for (Learner learner : learners) {
            if (learner instanceof SchoolStudent) System.out.println(learner);
        }
    }
}
