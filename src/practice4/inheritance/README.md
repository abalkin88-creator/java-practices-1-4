# Практическая работа 4 — раздел 4.1

## Наследование и абстрактные классы

### Задание 1 Наследование геометрических фигур

Создать простой класс Shape с getType, getArea, getPerimeter и toString. Создать Circle, Rectangle и Square, переопределить методы, продемонстрировать их вызов через родительскую ссылку и объяснить результат.

- [Shape.java](shapes/Shape.java)
- [Circle.java](shapes/Circle.java)
- [Rectangle.java](shapes/Rectangle.java)
- [Square.java](shapes/Square.java)
- [TestFigures.java](shapes/TestFigures.java)

Класс для запуска: `practice4.inheritance.shapes.TestFigures`.

### Задание 2 Телефон

Создать Phone с number, model, weight. Реализовать три конструктора, вызов двухпараметрического конструктора из трёхпараметрического, getNumber, две перегрузки receiveCall и sendMessage с переменным числом номеров. Создать три объекта и вызвать методы.

- [Phone.java](phone/Phone.java)

Класс для запуска: `practice4.inheritance.phone.Phone`.

### Задание 3 Человек

Создать Person с полями fullName и age, методами move и talk, конструкторами Person() и Person(fullName, age). Создать по объекту каждым конструктором и вызвать методы.

- [Person.java](person/Person.java)

Класс для запуска: `practice4.inheritance.person.Person`.

### Задание 4 Матрица

Создать Matrix с двумерным массивом вещественных чисел, количеством строк и столбцов. Реализовать сложение, умножение на число, печать и дополнительное умножение матриц.

- [Matrix.java](matrix/Matrix.java)

Класс для запуска: `practice4.inheritance.matrix.Matrix`.

### Задание 5 Читатели библиотеки

Создать Reader с ФИО, номером билета, факультетом, датой рождения и телефоном. Создать массив читателей. Перегрузить takeBook и returnBook для количества книг, переменного числа названий и объектов Book, содержащих название и автора.

- [Book.java](library/Book.java)
- [Reader.java](library/Reader.java)

Класс для запуска: `practice4.inheritance.library.Reader`.

### Задание 6 Сотрудник и менеджер

Создать Employer с firstName, lastName, income и методом getIncome. Создать Manager с дополнительным averageSum и переопределить getIncome с учётом выплаты от продаж. Присвоить Manager ссылке Employer, создать смешанный массив и вызвать getIncome для каждого элемента.

- [Employer.java](employees/Employer.java)
- [Manager.java](employees/Manager.java)

Класс для запуска: `practice4.inheritance.employees.Manager`.

В расчёте `income` — месячная зарплата; `getIncome()` возвращает годовой доход. В `Manager` к нему добавляется выплата от продаж `averageSum`.

### Задание 7 Учащиеся

Создать суперкласс «Учащийся» и подклассы «Школьник» и «Студент». Заполнить массив суперкласса объектами обоих видов, вывести студентов и школьников отдельно.

- [Learner.java](learners/Learner.java)
- [SchoolStudent.java](learners/SchoolStudent.java)
- [Student.java](learners/Student.java)
- [TestLearners.java](learners/TestLearners.java)

Класс для запуска: `practice4.inheritance.learners.TestLearners`.

### Задание 8 Абстрактная иерархия фигур

Переписать Shape как абстрактный класс с protected-полями color и filled, геттерами и сеттерами, абстрактными getArea и getPerimeter. Реализовать Circle, Rectangle и Square по UML.

Реализация: [Shape, Circle, Rectangle, Square и TestShape из практической работы 3](../../practice3/README.md).

### Задание 9 Магазин мебели

Создать абстрактный класс «Мебель», реализовать различные виды мебели с помощью наследования. Создать FurnitureShop, моделирующий магазин, и протестировать классы.

- [Furniture.java](furniture/Furniture.java)
- [Chair.java](furniture/Chair.java)
- [Table.java](furniture/Table.java)
- [FurnitureShop.java](furniture/FurnitureShop.java)

Класс для запуска: `practice4.inheritance.furniture.FurnitureShop`.

### Задание 10 Транспортные средства

Создать абстрактный класс транспортного средства и подклассы «Автомобиль», «Самолёт», «Поезд», «Корабль». Рассчитать время и стоимость перевозки пассажиров и грузов каждым видом транспорта.

- [Transport.java](transport/Transport.java)
- [Car.java](transport/Car.java)
- [Plane.java](transport/Plane.java)
- [Train.java](transport/Train.java)
- [Ship.java](transport/Ship.java)
- [TestTransport.java](transport/TestTransport.java)

Класс для запуска: `practice4.inheritance.transport.TestTransport`.

### Упражнение 1 Исправление ошибок и полиморфизм

Проверить предложенные в листинге 4.1.3 объявления и вызовы, объяснить ошибки, представить рабочую версию и связать результат с полиморфизмом.

- [PolymorphismExercise.java](PolymorphismExercise.java)

Класс для запуска: `practice4.inheritance.PolymorphismExercise`.

Используется иерархия `practice3.shapes`. Ошибочные вызовы исправлены приведением типа ссылки; создание экземпляра абстрактного `Shape` исключено.

