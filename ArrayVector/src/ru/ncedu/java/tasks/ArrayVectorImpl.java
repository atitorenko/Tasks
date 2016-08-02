package ru.ncedu.java.tasks;
import java.util.Arrays;

public class ArrayVectorImpl implements ArrayVector {
    double [] elements;
    public ArrayVectorImpl(){
        elements = new double[0];
    }

    public ArrayVectorImpl(double[] clone){
        this.elements = clone;
    }
    @Override
    public void set(double... elements) {
        this.elements = new double[elements.length];
        this.elements = elements;
    }

    @Override
    public double[] get() {
        return this.elements;
    }

    @Override
    public ArrayVector clone() {
        return new ArrayVectorImpl(this.elements.clone());
    }

    @Override
    public int getSize() {
        return this.elements.length;
    }

    @Override
    public void set(int index, double value) {
        if (index>=0) {
            if (index < elements.length)
                elements[index] = value;
            else {
                elements = Arrays.copyOf(this.elements, index+1);
                elements[index] = value;
            }
        }
    }

    @Override
    public double get(int index) throws ArrayIndexOutOfBoundsException {
        if (index < elements.length && index >= 0)
        return elements[index];
        else throw new ArrayIndexOutOfBoundsException("Bad Index");
    }

    @Override
    public double getMax() {
        double max = elements[0];
        for (int i = 0; i < elements.length; i++){
            if (elements[i] > max) max = elements[i];
        }
        return max;
    }

    @Override
    public double getMin() {
        double min = elements[0];
        for (int i = 0; i < elements.length; i++){
            if (elements[i] < min) min = elements[i];
        }
        return min;
    }

    @Override
    public void sortAscending() {
        Arrays.sort(elements);
    }

    @Override
    public void mult(double factor) {
        for (int i = 0; i < elements.length; i++)
            elements[i]*=factor;
    }

    @Override
    public ArrayVector sum(ArrayVector anotherVector) {
        int n = this.elements.length < anotherVector.getSize() ? this.elements.length : anotherVector.getSize();
        for (int i = 0; i < n; i++)
            this.elements[i]+=anotherVector.get(i);
        return this;
    }

    @Override
    public double scalarMult(ArrayVector anotherVector) {
        int n = this.elements.length < anotherVector.getSize() ? this.elements.length : anotherVector.getSize();
        double mult = 0;
        for (int i = 0; i < n; i++){
            mult+=this.elements[i]*anotherVector.get(i);
        }
        return mult;
    }

    @Override
    public double getNorm() {
        return Math.pow(this.scalarMult(this), 0.5);
    }
}
