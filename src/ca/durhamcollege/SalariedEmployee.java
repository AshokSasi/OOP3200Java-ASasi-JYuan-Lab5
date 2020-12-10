package ca.durhamcollege;

import java.time.LocalDate;

public class SalariedEmployee extends Employee
{
    //PRIVATE INSTANCE VARIABLES
    private double yearlySalary;
    private final int weeksInYear=52;

    // ACCESSORS
    public double getYearlySalary()
    {
        return yearlySalary;
    }

    // MUTATORS
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
    SalariedEmployee(String fullName, LocalDate birthDate, final String empID,double yearlySalary)
    {
        super( fullName,  birthDate,  empID);
        setYearlySalary(yearlySalary);

    }

    // PUBLIC METHODS
    @Override
    public double calculatePayDay()
    {
        double pay = (double)Math.round ((getYearlySalary()/weeksInYear) * 100.0)/100.0;
        return super.calculatePayDay() + pay;
    }


}
