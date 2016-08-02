package ru.ncedu.java.tasks;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by aleksejtitorenko on 28.07.16.
 */
public class BusinessCardImpl implements BusinessCard {
    public BusinessCardImpl() {
        sdf = new SimpleDateFormat("dd-MM-yyyy");
    }

    private SimpleDateFormat sdf;

    private String name;
    private String lastName;
    private String department;
    private Date birthDate;
    private String gender;
    private int salary;
    private String phone;

    /**
     * This method obtains (via Scanner) information from an input stream
     * that contains the following information about an Employee:<br/>
     * Name - String<br/>
     * Last name - String<br/>
     * Department - String <br/>
     * Birth date - String in format: "DD-MM-YYYY", where DD - two-digits birth date,
     * MM - two-digits month of birth, YYYY - year of birth<br/>
     * Gender : F or M - Character<br/>
     * Salary : number from 100 to 100000<br/>
     * Phone number : 10-digits number<br/>
     * All entries are separated with ";" sign<br/>
     * The format of input is the following:<br/>
     * Name;Last name;Department;Birth date;Gender;Salary;Phone number
     *
     * @param scanner Data source
     * @return Business Card
     * @throws InputMismatchException Thrown if input value
     *                                does not correspond to the data format given above (for example,
     *                                if phone number is like "AAA", or date format is incorrect, or salary is too high)
     * @throws NoSuchElementException Thrown if input stream hasn't enough values
     *                                to construct a BusinessCard
     */
    @Override
    public BusinessCard getBusinessCard(Scanner scanner) throws InputMismatchException, NoSuchElementException {
        scanner.useDelimiter(";");
        List<String> params = new LinkedList<>();
        while (scanner.hasNext()) {
            params.add(scanner.next());
        }
        if (params.size() == 7) {
            name = params.get(0);
            lastName = params.get(1);
            department = params.get(2);
            try {
                birthDate = sdf.parse(params.get(3));
            } catch (ParseException e) {
                throw new InputMismatchException("Wrong params");
            }
            if (params.get(4).equals("M") || params.get(4).equals("F")) {
                gender = params.get(4);
            } else throw new InputMismatchException("bad gender");
            if (params.get(5).matches("\\d+") && Integer.parseInt(params.get(5)) >= 100 && Integer.parseInt(params.get(5)) <= 100000) {
                this.salary = Integer.parseInt(params.get(5));
            } else throw new InputMismatchException("salary wrong");
            if (params.get(6).matches("\\d{10}")) {
                phone = params.get(6);
            } else throw new InputMismatchException("bad phone");
        } else throw new NoSuchElementException("input stream hasn't enough values to construct a BusinessCard");
        return this;
    }

    /**
     * @return Employee Name and Last name separated by space (" "), like "Chuck Norris"
     */
    @Override
    public String getEmployee() {
        return name + " " + lastName;
    }

    /**
     * @return Employee Department name, like "DSI"
     */
    @Override
    public String getDepartment() {
        return department;
    }

    /**
     * @return Employee Salary, like 1000
     */
    @Override
    public int getSalary() {
        return salary;
    }

    /**
     * @return Employee Age in years, like 69
     */
    @Override
    public int getAge() {
        Calendar cal = new GregorianCalendar();
        cal.setTime(birthDate);
        Calendar now = new GregorianCalendar();
        int age = now.get(Calendar.YEAR) - cal.get(Calendar.YEAR);
        if ((cal.get(Calendar.MONTH) > now.get(Calendar.MONTH))
                || (cal.get(Calendar.MONTH) == now.get(Calendar.MONTH) && cal.get(Calendar.DAY_OF_MONTH) > now
                .get(Calendar.DAY_OF_MONTH))) {
            age--;
        }
        return age;
    }

    /**
     * @return Employee Gender: either "Female" or "Male"
     */
    @Override
    public String getGender() {
        if (gender.equals("M")) return "Male";
        else return "Female";
    }

    /**
     * @return Employee Phone Number in the following format: "+7 123-456-78-90"
     */
    @Override
    public String getPhoneNumber() {
        StringBuilder sb = new StringBuilder();
        return sb.append("+7 ").append(phone.substring(0, 3)).append("-").append(phone.substring(3, 6)).append("-").append(phone.substring(6, 8)).append("-").append(phone.substring(8, 10)).toString();
    }
}
