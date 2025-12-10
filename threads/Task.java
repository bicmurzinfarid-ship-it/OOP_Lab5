package threads;

import functions.Function;

public class Task {
    private Function f;
    private double left,right,step;
    private int num;

    public Task(){}

    public Task(Function f, double left, double right, double step,int num) {
        this.f = f;
        this.left = left;
        this.right = right;
        this.step = step;
        this.num = num;
    }

    public synchronized void setTask(Function f, double left, double right, double step) {
        this.f = f;
        this.left = left;
        this.right = right;
        this.step = step;
        notify();
    }

    public synchronized void clear() {
        f = null;
        notify();
    }

    public void setF(Function f) {this.f = f;}
    public void setLeft(double left) {this.left = left;}
    public void setRight(double right) {this.right = right;}
    public void setStep(double step) {this.step = step;}
    public void setNum(int num) {this.num = num;}

    public Function getF() {return f;}
    public double getLeft() {return left;}
    public double getRight() {return right;}
    public double getStep() {return step;}
    public int getNum() {return num;}
}
