package ru.ncedu.java.tasks;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

/**
 * Created by aleksejtitorenko on 02.07.16.
 */
public class Test {
    public static void main (String[] args){
        Logger log = Logger.getLogger(Test.class.getName());
        double[] testArr = {3.,2.,1.,0.,1.,2.};
        double[] testArr2 = {2.,1.,2.};
        ArrayVector test1 = new ArrayVectorImpl();
        test1.set(testArr2);
        ArrayVector test = new ArrayVectorImpl();
        test.set(testArr);
        System.out.println(Arrays.toString(test.get()));
        System.out.println(test.getSize());
        test.set(9, 5.);
        System.out.println(Arrays.toString(test.get()));
        System.out.println(test.getSize());
        test.set(-1, 54.);
        System.out.println(Arrays.toString(test.get()));
        System.out.println(test.getSize());

        //test.set(91, 5.);
        System.out.println(Arrays.toString(test.get()));
        System.out.println(test.getSize());
        try {
            System.out.println(test.get(6));
        }catch (ArrayIndexOutOfBoundsException e){
            Logger.getLogger(Test.class.getName()).log(new LogRecord(Level.WARNING, e.getMessage()));
        }
        log.info(String.valueOf(test.getMax()));
        log.info(String.valueOf(test.getMin()));
        test.sortAscending();
        log.info(Arrays.toString(test.get()));
        test.mult(2);
        log.info(Arrays.toString(test.get()));
        log.info(Arrays.toString(test.get())+ "+" + Arrays.toString(test1.get()));
        test = test.sum(test1);
        log.info(Arrays.toString(test.get()));
        ArrayVector test2 = test.clone();
        test2.mult(4);
        log.info(Arrays.toString(test2.get()));
        log.info(Arrays.toString(test.get()));
        log.info("\n");
        log.info(Arrays.toString(test.get()));
        log.info(Arrays.toString(test1.get()));
        log.info(String.valueOf("SCALAR: " + test.scalarMult(test)));
        log.info(Arrays.toString(test.get()));
        log.info(Arrays.toString(test1.get()));
        log.info("NORMA: " + String.valueOf(test.getNorm()));
        log.info("NORMA2: " + String.valueOf(test1.getNorm()));
        test.set(15, 32.);
        log.info("SET: " + Arrays.toString(test.get()) + "SIZE: " + String.valueOf(test.getSize()));

    }
}
