import functions.*;
import functions.basic.*;

public class Main {
    public static void main(String[] args) {
        double[] points1 = new double[]{1,2,3,4,5,6};
        double[] points2 = new double[]{1,2,3,4,5,7};

        ArrayTabulatedFunction array1 = new ArrayTabulatedFunction(1,10,points1);
        LinkedListTabulatedFunction list1 = new LinkedListTabulatedFunction(1,10,points1);
        ArrayTabulatedFunction array2 = new ArrayTabulatedFunction(1,10,points2);
        LinkedListTabulatedFunction list2 = new LinkedListTabulatedFunction(1,10,points2);
        System.out.println("проверка toString: ");
        System.out.println("Аррей в стр: "+array1.toString());
        System.out.println("Лист в стр: "+list1.toString());

        System.out.println("проверка equals: ");
        System.out.println("List1,Array1 ожидается True: "+list1.equals(array1));
        System.out.println("List2,Array1 ожидается False: "+list2.equals(array1));

        System.out.println("проверка клона");
        ArrayTabulatedFunction CloneArray1 = (ArrayTabulatedFunction)array1.clone();
        System.out.println("клон с оригиналом: true "+CloneArray1.equals(array1));
        CloneArray1.setPointY(0,0);
        System.out.println("клон c изм с оригиналом: false "+CloneArray1.equals(array1));

        System.out.println("Хеш аррей 1: " + array1.hashCode());
        System.out.println("Хеш аррей 2: " + array2.hashCode());
        System.out.println("Хеш лист 1: " + list1.hashCode());
        LinkedListTabulatedFunction list1Cl =(LinkedListTabulatedFunction) list1.clone();
        System.out.println("Хеш листкл 1: " + list1Cl.hashCode());
        System.out.println("ожидается true: "+list1Cl.equals(list1));
        list1Cl.setPointY(0,list1Cl.getPointY(0)+0.01);
        System.out.println("ожидается false: "+list1Cl.equals(list1));
        System.out.println("Хеш листкл 1 c изм : " + list1Cl.hashCode());
        System.out.println("Хеш лист 1: " + list1.hashCode());
    }
}