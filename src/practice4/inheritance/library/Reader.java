// Практическая работа 4, раздел 4.1. Задание 5 Читатели библиотеки.
package practice4.inheritance.library;
public class Reader {
    private final String fullName, faculty, birthDate, phone;
    private final int cardNumber;
    public Reader(String fullName, int cardNumber, String faculty,
                  String birthDate, String phone) {
        this.fullName = fullName; this.cardNumber = cardNumber;
        this.faculty = faculty; this.birthDate = birthDate; this.phone = phone;
    }
    public void takeBook(int count) {
        System.out.println(fullName + " взял " + count + " книги");
    }
    public void returnBook(int count) {
        System.out.println(fullName + " вернул " + count + " книги");
    }
    public void takeBook(String... titles) {
        System.out.println(fullName + " взял книги: " + String.join(", ", titles));
    }
    public void returnBook(String... titles) {
        System.out.println(fullName + " вернул книги: " + String.join(", ", titles));
    }
    private String[] titles(Book[] books) {
        String[] result = new String[books.length];
        for (int i = 0; i < books.length; i++) result[i] = books[i].getTitle();
        return result;
    }
    public void takeBook(Book... books) { takeBook(titles(books)); }
    public void returnBook(Book... books) { returnBook(titles(books)); }
    @Override public String toString() {
        return fullName + "; билет " + cardNumber + "; " + faculty
                + "; " + birthDate + "; " + phone;
    }
    public static void main(String[] args) {
        Reader[] readers = {
            new Reader("Иванов И. И.", 101, "ИТ", "12.03.2006", "+70000000001"),
            new Reader("Соколова А. В.", 102, "Физика", "09.07.2005", "+70000000002")
        };
        for (Reader reader : readers) System.out.println(reader);
        Reader r = readers[0];
        r.takeBook(3); r.returnBook(3);
        r.takeBook("Рассказы", "Словарь", "Энциклопедия");
        r.returnBook("Рассказы", "Словарь", "Энциклопедия");
        Book[] books = {new Book("Капитанская дочка", "А. Пушкин"),
                        new Book("Муму", "И. Тургенев")};
        r.takeBook(books); r.returnBook(books);
    }
}
