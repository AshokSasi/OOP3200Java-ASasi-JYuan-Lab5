/*
Title: OOP3200Java-ASasi-JYuan-Lab4
Name:Ashok Sasitharan 100745484, Jacky Yuan 100520106
Date: December 09 2020
Changed: N/A
 */
package ca.durhamcollege;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        final int numObject = 5;
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        //SALARIED EMPLOYEE
        //Create a SalariedEmployee object
        SalariedEmployee salEmp = new SalariedEmployee("Ashok Sasitharan",   LocalDate.parse("07/08/2000", dateFormat),"18325648",55002.22);
        //Print out the yearly salary
        System.out.println("Yearly Salary: $"+ salEmp.getYearlySalary());
        //change the YearlySalary
        salEmp.setYearlySalary(100000);
        //Print out the yearly salary
        System.out.println("Yearly Salary (After change): $" + salEmp.getYearlySalary());

        //HOURLY WORKER
        //create HourlyWorker object
        HourlyWorker hourWorker = new HourlyWorker("Jacky Yuan", LocalDate.parse("02/09/1995", dateFormat), "65478912", 17.99, 36.0);
        //Print out Hourly Rate and Hours Worked Per Week
        System.out.println("Hourly rate: $" + hourWorker.getHourlyRate());
        System.out.println("Hours per week: " + hourWorker.getHoursPerWeek());
        //Change the Hourly Rate and Hours Per Week
        hourWorker.setHourlyRate(20.0);
        hourWorker.setHoursPerWeek(25.0);
        //Print out the changed Hourly Rate and Hours Worked Per Week
        System.out.println("Hourly rate (After change): $" + hourWorker.getHourlyRate());
        System.out.println("Hours per week (After change): " + hourWorker.getHoursPerWeek());

        //PAY ROLL
        try
        {
            //initialize all of the Employee array objects
            Employee[] empObj = new Employee[numObject];
            empObj[0]= new SalariedEmployee("Tommy Wiseau",   LocalDate.parse("21/03/1955", dateFormat),"65612345",95356.89);
            empObj[1]= new SalariedEmployee("Leo Treo",   LocalDate.parse("15/02/1999", dateFormat),"12345678",23500.33);
            empObj[2]= new HourlyWorker("Andre Angroppa",   LocalDate.parse("15/09/1998", dateFormat),"78545621",50.0,40.0);
            empObj[3]= new HourlyWorker("Nimmy Jeutron",   LocalDate.parse("28/11/2010", dateFormat),"49889465",18.0,22.0);
            empObj[4]= new HourlyWorker("Bonge Sob",   LocalDate.parse("02/08/1996", dateFormat),"13798165",25.0,44.0);

            //Print out the Employee array's objects in a formatted pay roll report
            System.out.println("\n                     Pay Roll");
            System.out.println("---------------------------------------------------");
            System.out.printf("%10s %15s %22s","Employee ID","Name","Weekly Pay");
            System.out.println("\n---------------------------------------------------");
            for (int i=0;i < numObject; i++)
            {
                System.out.printf("%10s %21s %7s% 10.2f", empObj[i].getEmpID(),empObj[i].getName(), "$", empObj[i].calculatePayDay());
                System.out.println("");
            }

        }
        //catch block
        catch (Exception ex)
        {
            System.out.println("Error: " + ex);
            System.out.println("----------------------------------------------------");

        }


    }
}
