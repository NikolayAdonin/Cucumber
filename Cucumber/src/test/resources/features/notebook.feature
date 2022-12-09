# language: ru
# encoding: utf-8
Функция: Ноутбуки

  Я как посетитель сайта DNS хочу иметь возможность
  - видеть список ноутбуков
  - сортировать и фильтровать список ноутбуков
  - переходить на страницу продукта

  Это позволит мне выбрать понравившийся ноутбуки и посмотреть его характеристики.

  Предыстория:
    Дано Открыта страница "Стартовая страница сайта DNS"
    Когда Нажата кнопка "Всё верно"
    И Выполнен переход на страницу "Ноутбуки"
    И Открыта страница "Ноутбуки"
    И Спрятан блок "header"

  @table @notebookPageTitle @case3
  Сценарий: Проверка заголовка страницы
    И Установлены фильтры из таблицы с двумя колонками
      | Производитель            | ASUS  |
      | Объем оперативной памяти | 32 ГБ |
    И Установлена сортировка "сначала дорогие"
    И Применены фильтры
    И Выполнен переход на страницу первого продукат в списке
    И Открыта страница "Продукт. Ноутбук"
    Тогда Проверка: Заголовок страницы "Продукт. Ноутбук" содержит текст "ASUS"

  @table @notebookTitle @case3
  Сценарий: Проверка названия ноутбука
    И Установлены фильтры из таблицы с двумя колонками
      | Производитель            | ASUS  |
      | Объем оперативной памяти | 32 ГБ |
    И Установлена сортировка "сначала дорогие"
    И Применены фильтры
    И Выполнен переход на страницу первого продукат в списке
    И Открыта страница "Продукт. Ноутбук"
    Тогда Проверка: Название ноутбука соответсвует названию ноутбука в заголовке страницы

  @table @ram @case3
  Сценарий: Проверка оперативной памяти ноутбука
    И Установлены фильтры из таблицы с двумя колонками
      | Производитель            | ASUS  |
      | Объем оперативной памяти | 32 ГБ |
    И Установлена сортировка "сначала дорогие"
    И Применены фильтры
    И Выполнен переход на страницу первого продукат в списке
    И Открыта страница "Продукт. Ноутбук"
    И Нажата кнопка "Развернуть все"
    Тогда Проверка: Количество оперативной памяти в характеристиках равно 32

  @Examples @case3
  Структура сценария: Проверка оперативной памяти ноутбука
    И В фильтре "Производитель" выбрано значение "<company>"
    И В фильтре "Объем оперативной памяти" выбрано значение "<ram> ГБ"
    И Установлена сортировка "<type>"
    И Применены фильтры
    И Выполнен переход на страницу первого продукат в списке
    И Открыта страница "Продукт. Ноутбук"
    И Нажата кнопка "Развернуть все"
    Тогда Проверка: Количество оперативной памяти в характеристиках равно <ram>

    Примеры:
      | type               | company | ram |
      | Сначала дорогие    | ASUS    | 8   |
      | сначала дорогие    | ASUS    | 32  |
      | Сначала популярные | ASUS    | 8   |
      | Сначала популярные | ASUS    | 32  |


