package functions;

import java.io.Serializable;

public class FunctionPoint implements Cloneable, Serializable {
    private double x;
    private double y;

    public FunctionPoint(double x, double y){
        this.x = x;
        this.y = y;
    }

    public FunctionPoint(FunctionPoint point){
        this.x = point.x;
        this.y = point.y;
    }

    public FunctionPoint(){
        this.x = 0;
        this.y = 0;
    }

    public double getX(){
        return this.x;
    }
    public double getY(){
        return this.y;
    }

    public void setX(double newX){this.x = newX;}
    public void setY(double newY){this.y = newY;}

    public String toString(){
        return "("+getX()+";"+getY()+")";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null|| obj.getClass()!=getClass()) return false;
        FunctionPoint that = (FunctionPoint) obj;
        return (that.getX() == getX()&&that.getY()==getY());
    }

    @Override
    public int hashCode() {
        long X = Double.doubleToLongBits(getX());
        long Y = Double.doubleToLongBits(getY());

        int XHigh = (int)(X >>> 32);
        int XLow = (int)X;
        int YHigh = (int)(Y >>> 32);
        int YLow = (int)Y;

        return ((29*XHigh) ^ (29*XLow) ^ (31*YHigh) ^ (31*YLow));
    }


    public Object clone(){
        Object cln = new FunctionPoint(getX(),getY());
        return cln;
    }

}
