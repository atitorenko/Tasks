package ru.ncedu.java.tasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.util.Scanner;

/**
 * Created by aleksejtitorenko on 28.07.16.
 */
public class Test {
    public static void main(String[] args) throws ParseException, FileNotFoundException {
        BusinessCard bc = new BusinessCardImpl();
        File file = new File("test.txt");
        Scanner scanner = new Scanner(file);
        bc = bc.getBusinessCard(scanner);
        System.out.println(bc.getDepartment());
        System.out.println(bc.getSalary());
        System.out.println(bc.getPhoneNumber());
        System.out.println(bc.getEmployee());
        System.out.println(bc.getGender());
        System.out.println(bc.getAge());
        scanner.close();
    }
}
