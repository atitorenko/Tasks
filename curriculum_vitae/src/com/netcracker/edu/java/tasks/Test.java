package com.netcracker.edu.java.tasks;

/**
 * Created by aleksejtitorenko on 20.07.16.
 */
public class Test {
    public static final String PHONE_PATTERN =
            "(\\(?([1-9][0-9]{2})\\)?[-. ]*)?([1-9][0-9]{2})[-. ]*(\\d{2})[-. ]*(\\d{2})(\\s*ext\\.?\\s*([0-9]+))?";
    public static final String NAME_PATTERN = "(\\w+\\.?)\\s(\\w+\\.?)\\s?(\\w+\\.?)?";

    public static void main(String[] args){
        String text = "First Lastq; Examples of numbers matching the expression: \\\"(916)125-4171\\\", \\\"495 926-93-47 ext.1846\\\", \\\"800 250 0890\\\"";
        CurriculumVitae cv = new CurriculumVitaeImpl();
        cv.setText(text);
        String fullName = cv.getFullName();
        String firstName = cv.getFirstName();
        String middleName = cv.getMiddleName();
        String lastName = cv.getLastName();
        System.out.println(
                "full name: " + fullName + "\n"
                + "first name: " + firstName + "\n"
                + "middle name: " + middleName + "\n"
                + " last name: " + lastName
        );
        cv.updateLastName("Titorenko");
        System.out.println("new last name: " + cv.getLastName());

        CurriculumVitae.Phone oldPhone = cv.getPhones().get(1);
        CurriculumVitae.Phone newPhone = new CurriculumVitae.Phone("496 132-93-47 ext.1846", 495, 1846);

        System.out.println(cv.getText());
        System.out.println(cv.getPhones());
        cv.updatePhone(oldPhone, newPhone);
        System.out.println(cv.getText());
        System.out.println(cv.getPhones());
        cv.hide("Alexey titorenko Al.");
    }
}
