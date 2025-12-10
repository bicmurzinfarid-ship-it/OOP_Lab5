package functions;

import functions.meta.*;

public class Functions {
    private Functions(){};

    public static Function shift(Function f, double shiftX,double shiftY){
        return new Shift(f,shiftX,shiftY);
    }

    public static Function scale(Function f, double scaleX, double scaleY){
        return new Scale(f,scaleX,scaleY);
    }

    public static Function power(Function f, double power){
        return new Power(f,power);
    }

    public static Function sum(Function f1, Function f2){
        return new Sum(f1,f2);
    }

    public static Function mult(Function f1, Function f2){
        return new Mult(f1,f2);
    }

    public static Function composition(Function f1, Function f2){
        return new Composition(f1,f2);
    }
    public static double integral(Function f, double left, double right, double step) {
        if (f.getLeftDomainBorder() > left || f.getRightDomainBorder() < right) {
            throw new IllegalArgumentException("incorrect integration boundaries");
        }
        double resultValue = 0.0;
        double currentLeft = left;

        while (currentLeft + step < right) {
            double fLeft = f.getFunctionValue(currentLeft);
            double fRight = f.getFunctionValue(currentLeft + step);
            resultValue += (fLeft + fRight) / 2.0 * step;  // верная формула трапеции
            currentLeft += step;
        }

        // Последний неполный отрезок
        if (currentLeft < right) {
            double fLeft = f.getFunctionValue(currentLeft);
            double fRight = f.getFunctionValue(right);
            resultValue += (fLeft + fRight) / 2.0 * (right - currentLeft);
        }

        return resultValue;
    }
}
