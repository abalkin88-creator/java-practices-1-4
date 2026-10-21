# Практическая работа 4

## Перечисления и их применение

### Задание 1 Времена года

Создать enum времён года со средней температурой и конструктором. Вывести любимое время года, реализовать метод со switch. getDescription возвращает «Холодное время года», а для лета переопределяется и возвращает «Теплое время года». Вывести все константы, температуры и описания.

- [Season.java](seasons/Season.java)
- [TestSeason.java](seasons/TestSeason.java)

Класс для запуска: `practice4.seasons.TestSeason`.

### Задание 2 Ателье

Создать размеры XXS, XS, S, M, L с euroSize 32, 34, 36, 38, 40 и описанием размера; для XXS переопределить описание. Реализовать MenClothing, WomenClothing, абстрактный Clothes и подклассы TShirt, Pants, Skirt, Tie. Класс Atelier должен принимать Clothes[] и выводить всю информацию отдельно о мужской и женской одежде.

- [Size.java](atelier/Size.java)
- [MenClothing.java](atelier/MenClothing.java)
- [WomenClothing.java](atelier/WomenClothing.java)
- [Clothes.java](atelier/Clothes.java)
- [TShirt.java](atelier/TShirt.java)
- [Pants.java](atelier/Pants.java)
- [Skirt.java](atelier/Skirt.java)
- [Tie.java](atelier/Tie.java)
- [Atelier.java](atelier/Atelier.java)

Класс для запуска: `practice4.atelier.Atelier`.

### Задание 3 Интернет магазин

Создать мини-приложение: ввод логина и пароля с клавиатуры, просмотр каталогов и товаров выбранного каталога, добавление товара в корзину и покупка содержимого корзины. Использовать перечисления.

- [Category.java](shop/Category.java)
- [Product.java](shop/Product.java)
- [Shop.java](shop/Shop.java)

Класс для запуска: `practice4.shop.Shop`.

Учебный вход: логин `student`, пароль `java17`. Далее используйте пункты меню для выбора каталога, товаров, корзины и покупки.

### Задание 4 Компьютер

Описать Computer и его составные части отдельными классами Processor, Memory, Monitor. Предусмотреть свойства и методы каждого класса. Марки компьютеров представить перечислением.

- [Brand.java](computer/Brand.java)
- [Processor.java](computer/Processor.java)
- [Memory.java](computer/Memory.java)
- [Monitor.java](computer/Monitor.java)
- [Computer.java](computer/Computer.java)

Класс для запуска: `practice4.computer.Computer`.

## Раздел 4.1

[Задания на наследование и абстрактные классы](inheritance/README.md).
