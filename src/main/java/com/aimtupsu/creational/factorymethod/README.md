# Factory Method

Фабричный метод (Factory method) - порождающий паттерн проектирования, предоставлюящий своим подклассам (дочерним классам) интерфейс для создания экземпляров некоторого класса.  

## Общая иерархия
![Factory Method UML diagramm from Wikipedia](https://upload.wikimedia.org/wikipedia/ru/f/f0/FactoryMethodPattern.png)
#### Продукт (Product)
Общий интерфейс создаваемых объектов - Гитара
```java
interface Guitar {
    void play();
}
```
#### Конкретный продукт 1 (ConcreteProduct1)
Реализует интерфейс продукта - Акустическая гитара
```java
class AcousticGuitar implements Guitar { }
```
#### Конкретный продукт 2 (ConcreteProduct2)
Реализует интерфейс продукта - Басс-гитара
```java
class BassGuitar implements Guitar { }
```
#### Создатель (Creator)
Определяет общий интерфейс создаталя - мастерская по изготовлению гитар
```java
interface GuitarWorkshop {
    void createGuitar();
}
```
#### Конкретный создатель 1 (ConcreteCreator1)
Реализует интерфейс создаталя - мастерская по изготовлению акустических гитар
```java
class AcousticGuitarWorkshop implements GuitarWorkshop {
    @SuppressWarnings("UnnecessaryLocalVariable") 
    createGuitar() {
        final AcousticGuitar acousticGuitar = new AcousticGuitar();
        //...
        return acousticGuitar;
    }
}
```
#### Конкретный создатель 2 (ConcreteCreator2)
Реализует интерфейс создаталя - мастерская по изготовлению басс-гитар
```java
class BassGuitarWorkshop implements GuitarWorkshop {
    @SuppressWarnings("UnnecessaryLocalVariable") 
    createGuitar() {
        final BassGuitar bassGuitar = new BassGuitar();
        //...
        return bassGuitar;
    }
}
```
## Достоинства:
* позволяет сделать код более универсальным, не привязываюсь к конкретным классам, а оперируя лишь общим интерфейсом
* выделяет код инстанциирования в одно место, упрощая поддержку кода
* упрощает добавление новых конкретных реализаций 

## Недостатки:
* может привести к созданию больших параллельных иерархий классов, так как для каждой конкретной реализации требуется создать свой подкласс создателя 