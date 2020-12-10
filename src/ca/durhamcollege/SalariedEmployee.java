/*
Title: OOP3200Java-ASasi-JYuan-Lab4
Name:Ashok Sasitharan 100745484, Jacky Yuan 100520106
Date: December 09 2020
Changed: N/A
 */
package ca.durhamcollege;

import java.time.LocalDate;

public class SalariedEmployee extends Employee
{
    //PRIVATE INSTANCE VARIABLES
    private double yearlySalary;
    private final int weeksInYear=52;

    // ACCESSORS

    /**
     * Returns this yearlySalary
     * @return yearlySalary
     */
    public double getYearlySalary()
    {
        return yearlySalary;
    }

    // MUTATORS

    /**
     * Sets an employee's yearly salary if it is a number greater than or equal to 0
     * @param yearlySalary
     * @throws IllegalArgumentException when yearlySalary entered is negative
     */
    public void setYearlySalary(double yearlySalary)
    {
        if (yearlySalary >= 0.0)
        {
            this.yearlySalary = yearlySalary;
        }
        else
        {
            throw new IllegalArgumentException( yearlySalary+" is an invalid yearly salary. The yearly salary must be a positive number");
        }
    }

    // PARAMETERIZED CONSTRUCTOR

    /**
     *Initializes a SalariedEmployee based on parameters
     * @param fullName
     * @param birthDate
     * @param empID
     * @param yearlySalary
     *
     */
    SalariedEmployee(String fullName, LocalDate birthDate, final String empID,double yearlySalary)
    {
        super( fullName,  birthDate,  empID);
        setYearlySalary(yearlySalary);

    }

    // PUBLIC METHODS

    /**
     * Takes in (double)yearly salary and returns a salaried employee's weekly pay
     * @return double
     */
    @Override
    public double calculatePayDay()
    {
        double pay = (double)Math.round ((getYearlySalary()/weeksInYear) * 100.0)/100.0;
        return super.calculatePayDay() + pay;
    }


}
