# Merch-site
Интернет-магазин по продаже продукции с символикой музыкальных коллективов или отдельных исполнителей
---
В идеале должны существовать возможности
1. Просмотреть все товары
2. Отфильтровать по типу, цене, или чему бы то ни было
3. Купить товар
4. Купить товар без аккаунта, указав контактные данные
5. Зарегистрироваться
6. Добавить товар (при наличии прав)
7. Удалить товар (при наличии прав)
___
Планируется реализовать REST API и использовать AngularJS. 
___
Примерная схема базы данных:
![image](https://i.imgsafe.org/f861a39f6f.png)
---
Сейчас есть:
+ Запускающаяся с божьей помощью версия
+ REST API для таблицы товаров
+ Пара вырожденных сервисов и DAO уровень
+ Подключен Hibernate
+ 2 страницы: главная и добавления товара
+ 2 типа товаров