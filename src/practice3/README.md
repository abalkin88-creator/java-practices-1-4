# Практическая работа 3

## Финал — все задания в одном файле

**Для показа и запуска откройте [Final.java](Final.java).** В нём собраны все задания практики с подписями.

В IntelliJ IDEA запустите `Final.main()`, введите номер нужного задания из меню и затем данные, которые оно запросит. После завершения задания запустите файл снова, чтобы выбрать другое.

Файл можно компилировать отдельно от остальных исходников. Из корня репозитория:

```text
javac -encoding UTF-8 -d out src/practice3/Final.java
java -cp out practice3.Final
```

| Номер в меню | Задание |
|---|---|
| `1` | Задание 1 Абстрактный класс Shape |
| `2` | Задание 2 Интерфейс Movable и движущиеся фигуры |

Изначальные отдельные файлы сохранены и перечислены ниже.

## Исходные файлы по заданиям
## Абстрактные классы и интерфейсы

### Задание 1 Абстрактный класс Shape

Реализовать UML-иерархию Shape, Circle, Rectangle и Square. Shape содержит protected-поля color и filled, конструкторы, геттеры и сеттеры, абстрактные getArea и getPerimeter. Переопределить методы в подклассах, написать тест и объяснить полиморфизм и ошибки из предложенного фрагмента.

- [Shape.java](shapes/Shape.java)
- [Circle.java](shapes/Circle.java)
- [Rectangle.java](shapes/Rectangle.java)
- [Square.java](shapes/Square.java)
- [TestShape.java](shapes/TestShape.java)

Класс для запуска: `practice3.shapes.TestShape`.

### Задание 2 Интерфейс Movable и движущиеся фигуры

Создать интерфейс Movable и реализующие его MovablePoint и MovableCircle. Дополнительно создать MovableRectangle, представленный двумя движущимися точками. Написать метод проверки равенства скоростей углов и тест.

- [Movable.java](movable/Movable.java)
- [MovablePoint.java](movable/MovablePoint.java)
- [MovableCircle.java](movable/MovableCircle.java)
- [MovableRectangle.java](movable/MovableRectangle.java)
- [TestMovable.java](movable/TestMovable.java)

Класс для запуска: `practice3.movable.TestMovable`.

