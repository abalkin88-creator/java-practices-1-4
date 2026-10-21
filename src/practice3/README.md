# Практическая работа 3

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

