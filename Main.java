import functions.*;
import functions.basic.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== ТЕСТИРОВАНИЕ ВСЕХ МЕТОДОВ ===");

        FunctionPoint[] points1 = {
                new FunctionPoint(1.0, 2.0),
                new FunctionPoint(3.0, 4.0),
                new FunctionPoint(5.0, 6.0)
        };

        FunctionPoint[] points2 = {
                new FunctionPoint(1.0, 2.0),
                new FunctionPoint(3.0, 4.0),
                new FunctionPoint(5.0, 6.0)
        };

        FunctionPoint[] points3 = {
                new FunctionPoint(1.0, 2.0),
                new FunctionPoint(3.0, 4.0),
                new FunctionPoint(5.0, 7.0) // Отличается от points1
        };

        // Создаем объекты для тестирования
        ArrayTabulatedFunction arrayFunc1 = new ArrayTabulatedFunction(points1);
        ArrayTabulatedFunction arrayFunc2 = new ArrayTabulatedFunction(points2);
        ArrayTabulatedFunction arrayFunc3 = new ArrayTabulatedFunction(points3);

        LinkedListTabulatedFunction listFunc1 = new LinkedListTabulatedFunction(points1);
        LinkedListTabulatedFunction listFunc2 = new LinkedListTabulatedFunction(points2);
        LinkedListTabulatedFunction listFunc3 = new LinkedListTabulatedFunction(points3);

        System.out.println("\n--- 1. ТЕСТ toString() ---");
        System.out.println("ArrayTabulatedFunction toString(): " + arrayFunc1.toString());
        System.out.println("LinkedListTabulatedFunction toString(): " + listFunc1.toString());

        System.out.println("\n--- 2. ТЕСТ equals() ---");
        System.out.println("arrayFunc1.equals(arrayFunc2): " + arrayFunc1.equals(arrayFunc2) + " (ожидается: true)");
        System.out.println("arrayFunc1.equals(arrayFunc3): " + arrayFunc1.equals(arrayFunc3) + " (ожидается: false)");
        System.out.println("listFunc1.equals(listFunc2): " + listFunc1.equals(listFunc2) + " (ожидается: true)");
        System.out.println("listFunc1.equals(listFunc3): " + listFunc1.equals(listFunc3) + " (ожидается: false)");
        System.out.println("arrayFunc1.equals(listFunc1): " + arrayFunc1.equals(listFunc1) + " (ожидается: true)");
        System.out.println("listFunc1.equals(arrayFunc1): " + listFunc1.equals(arrayFunc1) + " (ожидается: true)");
        System.out.println("arrayFunc1.equals(null): " + arrayFunc1.equals(null) + " (ожидается: false)");
        System.out.println("arrayFunc1.equals(\"строка\"): " + arrayFunc1.equals("строка") + " (ожидается: false)");

        System.out.println("\n--- 3. ТЕСТ hashCode() ---");
        System.out.println("arrayFunc1.hashCode(): " + arrayFunc1.hashCode());
        System.out.println("arrayFunc2.hashCode(): " + arrayFunc2.hashCode());
        System.out.println("arrayFunc3.hashCode(): " + arrayFunc3.hashCode());
        System.out.println("listFunc1.hashCode(): " + listFunc1.hashCode());
        System.out.println("listFunc2.hashCode(): " + listFunc2.hashCode());
        System.out.println("listFunc3.hashCode(): " + listFunc3.hashCode());

        // Проверка согласованности equals() и hashCode()
        System.out.println("arrayFunc1.equals(arrayFunc2) && arrayFunc1.hashCode() == arrayFunc2.hashCode(): " +
                (arrayFunc1.equals(arrayFunc2) && arrayFunc1.hashCode() == arrayFunc2.hashCode()) + " (ожидается: true)");

        System.out.println("listFunc1.equals(listFunc2) && listFunc1.hashCode() == listFunc2.hashCode(): " +
                (listFunc1.equals(listFunc2) && listFunc1.hashCode() == listFunc2.hashCode()) + " (ожидается: true)");

        // Тест с небольшим изменением
        ArrayTabulatedFunction arr1Modified = (ArrayTabulatedFunction) arrayFunc1.clone();
        arr1Modified.setPointY(0, arr1Modified.getPointY(0) + 0.001); // Изменяем на 0.001

        System.out.println("После изменения Y на 0.001:");
        System.out.println("arrayFunc1.equals(arr1Modified): " + arrayFunc1.equals(arr1Modified) + " (ожидается: false)");
        System.out.println("arrayFunc1.hashCode() == arr1Modified.hashCode(): " +
                (arrayFunc1.hashCode() == arr1Modified.hashCode()) + " (ожидается: false)");
        System.out.println("Новый hashCode: " + arr1Modified.hashCode());

        System.out.println("\n--- 4. ТЕСТ clone() ---");
        // Тестирование ArrayTabulatedFunction
        ArrayTabulatedFunction arrayClone = (ArrayTabulatedFunction) arrayFunc1.clone();
        System.out.println("Array clone создан: " + (arrayClone != null));
        System.out.println("Array clone != original: " + (arrayClone != arrayFunc1));
        System.out.println("Array clone equals original: " + arrayClone.equals(arrayFunc1));

        // Проверка глубокого копирования для массива
        arrayFunc1.setPointY(0, 999.0);
        System.out.println("После изменения оригинала arrayFunc1:");
        System.out.println("Оригинал Y[0]: " + arrayFunc1.getPointY(0) + " (ожидается: 999.0)");
        System.out.println("Клон Y[0]: " + arrayClone.getPointY(0) + " (ожидается: 2.0)");
        System.out.println("Клон не изменился: " + (arrayClone.getPointY(0) == 2.0));

        // Тестирование LinkedListTabulatedFunction
        LinkedListTabulatedFunction listClone = (LinkedListTabulatedFunction) listFunc1.clone();
        System.out.println("List clone создан: " + (listClone != null));
        System.out.println("List clone != original: " + (listClone != listFunc1));
        System.out.println("List clone equals original: " + listClone.equals(listFunc1));

        // Проверка глубокого копирования для списка
        listFunc1.setPointY(1, 888.0);
        System.out.println("После изменения оригинала listFunc1:");
        System.out.println("Оригинал Y[1]: " + listFunc1.getPointY(1) + " (ожидается: 888.0)");
        System.out.println("Клон Y[1]: " + listClone.getPointY(1) + " (ожидается: 4.0)");
        System.out.println("Клон не изменился: " + (listClone.getPointY(1) == 4.0));

        // Проверка, что клоны разных типов работают корректно
        System.out.println("arrayClone instanceof ArrayTabulatedFunction: " + (arrayClone instanceof ArrayTabulatedFunction));
        System.out.println("listClone instanceof LinkedListTabulatedFunction: " + (listClone instanceof LinkedListTabulatedFunction));

        System.out.println("\n=== ТЕСТИРОВАНИЕ ЗАВЕРШЕНО ===");
    }
}