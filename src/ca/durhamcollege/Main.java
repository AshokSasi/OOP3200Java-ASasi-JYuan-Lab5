package ca.durhamcollege;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        //SALARIED EMPLOYEE
        SalariedEmployee salEmp = new SalariedEmployee("Ashok Sasitharan",   LocalDate.parse("07/08/2000", dateFormat),"18325648",0);
        System.out.println(salEmp.getYearlySalary());
        salEmp.setYearlySalary(100000);
        System.out.println(salEmp.calculatePayDay());

        //HOURLY WORKER
        HourlyWorker hourWorker = new HourlyWorker("Jacky Yuan", LocalDate.parse("02/09/1995", dateFormat), "65478912", 17.0, 36.3);
        System.out.println("Hourly rate: " + hourWorker.getHourlyRate());
        System.out.println("Hours per week: " + hourWorker.getHoursPerWeek());
        System.out.println("Pay per week: " + hourWorker.calculatePayDay());


    }
}
