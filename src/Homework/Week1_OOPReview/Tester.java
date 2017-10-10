package Homework.Week1_OOPReview;

import java.io.*;
import java.util.Scanner;

public class Tester {
    public static void main(String[] args) throws IOException {

        String firstName;
        char ch;

        String name;
        double earn = 0;
        String lastName;

        Employee[] employees = new Employee[5];

        Scanner input = new Scanner(new File("employee.txt")); //reads in employee.txt

        int i = 0;
        while (input.hasNext()) { //while loop to check each line for what type of employee, and the data proceeding
                                  // after the name for the employee data type regarding wages, earnings, hours, etc.
            firstName = input.next();
            double wage;
            int hours;
            if (firstName.charAt(0) == '#') {
                name = firstName.replace("#", "");
                lastName = input.next();
                earn = input.nextDouble();
                employees[i] = new Manager(name, lastName, earn);
            }
            else if (firstName.charAt(0) == '*') {
                name = firstName.replace("*", "");
                lastName = input.next();
                wage = input.nextDouble();
                hours = input.nextInt();
                employees[i] = new HourlyWorker(name, lastName, wage, hours);
            }
            i++;
        }


        //print employees to console
        for (Employee employee : employees) {
            System.out.println(employee.toString());
        }
    }
}