// Практическая работа 2. Задание Классы Author и TestAuthor.
package practice2;
public class TestAuthor {
    public static void main(String[] args) {
        Author author = new Author("Анна Орлова", "anna@example.com", 'F');
        System.out.println(author);
        System.out.println("Имя: " + author.getName());
        System.out.println("Пол: " + author.getGender());
        author.setEmail("orlova@example.com");
        System.out.println("Новая почта: " + author.getEmail());
        System.out.println(author);
    }
}
