/*
Title: OOP3200Java-ASasi-JYuan-Lab4
Name:Ashok Sasitharan 100745484, Jacky Yuan 100520106
Date: December 09 2020
Changed: N/A
 */
package ca.durhamcollege;

import java.time.LocalDate;
import java.util.regex.Pattern;

public abstract class Employee extends Person
{
    //PRIVATE INSTANCE VARIABLES
    private  String empID;

    //ACCESSOR

    /**
     * Gets an employees EmployeeID
     * @return
     */
    public String getEmpID()
    {
        return empID;
    }


    //PARAMTERIZED CONSTRUCTOR

    /**
     * Initializes a person object
     * @param fullName
     * @param birthDate
     * @param empID
     * @throws IllegalArgumentException when employeeID is not numeric and is not equal to 8 digits
     */
    Employee (String fullName, LocalDate birthDate,final String empID)
    {
        super(fullName,birthDate);
        if (Pattern.matches("[0-9]+",empID) == true && empID.length()==8)
        {
            this.empID = empID;
        }
        else
        {
            throw new IllegalArgumentException( empID+" is an invalid Employee ID. Employee ID must be an 8 digit ID");
        }

    }
    //PUBLIC METHODS

    /**
     * Calculates an employee's weekly pay
     * @return double
     */
    public double calculatePayDay()
    {
        double pay=0.0;

        return pay;
    }
}
