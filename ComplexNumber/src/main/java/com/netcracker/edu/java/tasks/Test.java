package com.netcracker.edu.java.tasks;

/**
 * Created by aleksejtitorenko on 04.07.16.
 */

public class Test {


    static public void main(String[] args) {
        //String complexNumStr = "12.5-1.0i";
        //String complexNumStr = "0.0";
        String complexNumStr = "1.0+0.5i";
        String complexNumStr1 = "-0.2i";

        ComplexNumber testNum = new ComplexNumberImpl();
//        testNum.set("+0.5i");

        testNum.set("1-0.5i");
        System.out.println(testNum.toString());
        System.out.println(testNum.equals("1.0"));
//        System.out.println(testNum.equals("1.0"));
//        System.out.println("toString: " + testNum.toString());

//        String num2 = "1.1+0.5i";
//        System.out.println(testNum.equals(num2));
//        testNum1.set(complexNumStr1);
//        testNum.negate();
//        testNum1.negate();
//        ComplexNumber[] arr = {testNum, testNum1};
//        System.out.println(Arrays.toString(arr));
//        testNum.add(testNum1);
//        testNum.sort(arr);
//        System.out.println(Arrays.toString(arr));
//        System.out.println("Re: " + testNum.getRe());
//        System.out.println("Im: " + testNum.getIm());
//        testNum.multiply(testNum1);
//        System.out.println("toString: " + testNum.toString());
//
//        System.out.println("Re2: " + testNum1.getRe());
//        System.out.println("Im2: " + testNum1.getIm());
//        System.out.println("toString: " + testNum1.toString());
//
//         System.out.println(testNum.compareTo(testNum1));

    }
}
