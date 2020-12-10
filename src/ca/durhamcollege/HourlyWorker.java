/*
Title: OOP3200Java-ASasi-JYuan-Lab4
Name:Ashok Sasitharan 100745484, Jacky Yuan 100520106
Date: December 09 2020
Changed: N/A
 */
package ca.durhamcollege;

import java.time.LocalDate;

public class HourlyWorker extends Employee
{
    // PRIVATE INSTANCE VARIABLES
    private double hourlyRate;
    private double hoursPerWeek;

    // ACCESSORS

    /**
     * Returns employee's hourly rate
     * @return hourlyRate(double)
     */
    public double getHourlyRate()
    {
        return hourlyRate;
    }

    /**
     * Returns employees HoursWorked
     * @return hoursPerWeek(double)
     */
    public double getHoursPerWeek()
    {
        return hoursPerWeek;
    }

    // MUTATORS

    /**
     * Sets an employee's hours worked per week as long as it is valid
     * @param hoursPerWeek
     * @throws IllegalArgumentException hours per week is greater than 48.0 and less than 0.0
     */
    public void setHoursPerWeek(double hoursPerWeek)
    {
        if (hoursPerWeek <= 48.0 && hoursPerWeek >= 0.0)
        {
            this.hoursPerWeek = hoursPerWeek;
        }
        else
        {
            throw new IllegalArgumentException( hoursPerWeek+" is an invalid amount of hours. You can only work between 0.0-48.0 hours per week");
        }
    }

    /**
     * Sets hourlyRate if input is valid
     * @param hourlyRate
     * @throws IllegalArgumentException when hourlyRate is less than 17.0(minimum wage)
     */
    public void setHourlyRate(double hourlyRate)
    {
        if (hourlyRate >= 17.0)
        {
            this.hourlyRate = hourlyRate;
        }
        else
        {
            throw new IllegalArgumentException( hourlyRate+" is an invalid hourly rate. The minimum wage is $17.00");
        }

    }

    // PARAMETERIZED CONSTRUCTOR

    /**
     * Initializes an hourly worker based on parameters
     * @param fullName
     * @param birthDate
     * @param empID
     * @param hourlyRate
     * @param hoursPerWeek
     */
    HourlyWorker(String fullName, LocalDate birthDate, final String empID, double hourlyRate, double hoursPerWeek)
    {
        super(fullName,birthDate, empID);
        setHourlyRate(hourlyRate);
       setHoursPerWeek(hoursPerWeek);
    }

    /**
     * Returns a HourlyWorkers weekly pay(double)
     * @return pay(double)
     */
    //PUBLIC METHODS
    @Override
    public double calculatePayDay()
    {
      double pay = (double)Math.round( (getHoursPerWeek()*getHourlyRate()) * 100.0)/100.0;
        return super.calculatePayDay()+pay;
    }
}
