package com.netcracker.edu.java.tasks;



import java.util.Arrays;
import java.util.Comparator;

public class ComplexNumberImpl implements ComplexNumber {
    double re = 0.;
    double im = 0.;

    public ComplexNumberImpl() {
    }

    public ComplexNumberImpl(double re, double im) {
        this.re = re;
        this.im = im;
    }

    /**
     * @return real part of this complex number
     */

    public double getRe() {
        return this.re;
    }

    /**
     * @return imaginary part of this complex number
     */
    public double getIm() {
        return this.im;
    }

    /**
     * @return true if this complex number has real part only (otherwise false)
     */

    public boolean isReal() {
        if (im == 0)
            return true;
        else return false;
    }

    /**
     * Sets both real and imaginary part of this number.
     *
     * @param re
     * @param im
     */

    public void set(double re, double im) {
        this.re = re;
        this.im = im;
    }

    /**
     * Parses the given string value and sets the real and imaginary parts of this number accordingly.<br/>
     * The string format is "re+imi", where re and im are numbers (floating point or integer) and 'i' is a special symbol
     * denoting imaginary part (if present, it's always the last character in the string).<br/>
     * Both '+' and '-' symbols can be the first characters of re and im; but '*' symbol is NOT allowed.<br/>
     * Correct examples: "-5+2i", 1+i", "+4-i", "i", "-3i", "3". Incorrect examples: "1+2*i", "2+2", "j".<br/>
     * Note: explicit exception generation is an OPTIONAL requirement for this task,
     * but NumberFormatException can be thrown by {@link Double#parseDouble(String)}).<br/>
     * Note: it is not reasonable to use regex while implementing this method: the parsing logic is too complicated.
     *
     * @param value
     * @throws NumberFormatException if the given string value is incorrect
     */

    public void set(String value) throws NumberFormatException {
        StringBuilder stringBuilder = new StringBuilder();
        StringBuilder stringBuilder2 = new StringBuilder();
        String reS = "0";
        String imS = "0";
        char[] chars = value.toCharArray();
        for(int i = 0; i < chars.length; i++){
            if(!value.contains("i")) {
                reS = value;
                break;
            }
            if(chars[0] == '+' || chars[0] == '-'){
                int j = i + 1;
                stringBuilder.append(chars[i]);
                try {
                    if (chars[j] == '+' || chars[j] == '-') {
                        reS = stringBuilder.toString();
                        while (chars[j] != 'i') {
                            stringBuilder2.append(chars[j]);
                            j++;
                        }
                        imS = stringBuilder2.toString();
                        break;
                    }
                    if (chars[j] == 'i') {
                        imS = stringBuilder.toString();
                        break;
                    }
                }catch (ArrayIndexOutOfBoundsException e){
                    if(chars[0] == '+') imS = "1";
                    else imS = "-1";
                    break;
                }
            }
            else {
                int j = i + 1;
                stringBuilder.append(chars[i]);
                try {
                    if (chars[j] == '+' || chars[j] == '-') {
                        reS = stringBuilder.toString();
                        while (chars[j] != 'i') {
                            stringBuilder2.append(chars[j]);
                            j++;
                        }
                        imS = stringBuilder2.toString();
                        break;
                    }
                    if(chars[j] == 'i') {
                        imS = stringBuilder.toString();
                        break;
                    }
                }
                catch (ArrayIndexOutOfBoundsException e){
                    imS = "1";
                    break;
                }
            }
        }
        if("i".equals(value)) imS = "1";
        if("+".equals(imS)) imS = "1";
        if("-".equals(imS)) imS = "-1";
        this.re = Double.parseDouble(reS);
        this.im = Double.parseDouble(imS);
    }

    /**
     * Creates and returns a copy of this object: <code>x.copy().equals(x)</code> but <code>x.copy()!=x</code>.
     *
     * @return the copy of this number
     * @see #clone()
     */

    public ComplexNumber copy() {
        return new ComplexNumberImpl(this.re, this.im);
    }

    /**
     * Creates and returns a copy of this object: the same as {@link #copy()}.<br/>
     * Note: when implemented in your class, this method overrides the {@link Object#clone()} method but changes
     * the visibility and the return type of the Object's method: the visibility modifier is changed
     * from protected to public, and the return type is narrowed from Object to ComplexNumber (see also
     * <a href="http://docs.oracle.com/javase/specs/jls/se7/html/jls-8.html#d5e11368">covariant types example from JLS</a>).
     *
     * @return the copy of this number
     * @see Object#clone()
     */
    @Override
    public ComplexNumber clone() throws CloneNotSupportedException {
        return (ComplexNumber) super.clone();
    }

    @Override
    public String toString() {
        double im = this.getIm();
        double re = this.getRe();
        String imStr = Double.toString(im);
        String reStr = Double.toString(re);
        if (re == 0 && im != 0) return imStr + "i";
        else if (re != 0 && im == 0) return reStr;
        else if (im>0 && re!=0){
            return reStr + "+" + imStr + "i";
        }else if (im<0 && re!=0){
            return reStr + imStr + "i";
        }else return "0.0";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (this.getClass() != obj.getClass()){
            if (this.toString().equals(obj.toString())) return true;
            else return false;
//            String objStr = obj.toString();
//            ComplexNumber other = new ComplexNumberImpl();
//            other.set(objStr);
//            if ((re != other.getRe()) || im != other.getIm())
//                return false;
//            else return true;
        }
        ComplexNumberImpl other = (ComplexNumberImpl) obj;
        if ((re != other.re) || (im != other.im))
            return false;
        return true;
    }

    /**
     * Compares this number with the other number by the absolute values of the numbers:
     * x < y if and only if |x| < |y| where |x| denotes absolute value (modulus) of x.<br/>
     * Can also compare the square of the absolute value which is defined as the sum
     * of the real part squared and the imaginary part squared: |re+imi|^2 = re^2 + im^2.
     *
     * @param other the object to be compared with this object.
     * @return a negative integer, zero, or a positive integer as this object
     * is less than, equal to, or greater than the given object.
     * @see Comparable#compareTo(Object)
     */
    @Override
    public int compareTo(ComplexNumber other) {
        Double x = this.getRe() * this.getRe() + this.getIm() * this.getIm();
        Double y = other.getRe() * other.getRe() + other.getIm() * other.getIm();
        return x.compareTo(y);
    }

    /**
     * Sorts the given array in ascending order according to the comparison rule defined in
     * {@link #compareTo(ComplexNumber)}.<br/>
     * It's strongly recommended to use {@link Arrays} utility class here
     * (and do not transform the given array to a double[] array).<br/>
     * Note: this method could be static: it does not use this instance of the ComplexNumber.
     * Nevertheless, it is not static because static methods can't be overridden.
     *
     * @param array an array to sort
     */
    @Override
    public void sort(ComplexNumber[] array) {
        Arrays.sort(array, new Comparator<ComplexNumber>(){
            @Override
            public int compare(ComplexNumber o1, ComplexNumber o2) {
                return o1.compareTo(o2);
            }
        });
    }

    /**
     * Changes the sign of this number. Both real and imaginary parts change their sign here.
     *
     * @return this number (the result of negation)
     */
    @Override
    public ComplexNumber negate() {
        this.re = this.getRe()*(-1);
        this.im = this.getIm()*(-1);
        return this;
    }

    /**
     * Adds the given complex number arg2 to this number. Both real and imaginary parts are added.
     *
     * @param arg2 the second operand of the operation
     * @return this number (the sum)
     */
    @Override
    public ComplexNumber add(ComplexNumber arg2) {
        this.re = this.re + arg2.getRe();
        this.im = this.im + arg2.getIm();
        return this;
    }

    /**
     * Multiplies this number by the given complex number arg2. If this number is a+bi and arg2 is c+di then
     * the result of their multiplication is (a*c-b*d)+(b*c+a*d)i<br/>
     * The method should work correctly even if arg2==this.
     *
     * @param arg2 the second operand of the operation
     * @return this number (the result of multiplication)
     */
    @Override
    public ComplexNumber multiply(ComplexNumber arg2) {
        double re1 = re;
        double im1 = im;
        if (arg2==this){
            re = re1*re1 - im1*im1;
            im = 2*re1*im1;
            return this;
        }else {
            double re2 = arg2.getRe();
            double im2 = arg2.getIm();
            re = re1*re2 - im1*im2;
            im = re1*im2 + im1*re2;
            return this;
        }
    }
}
