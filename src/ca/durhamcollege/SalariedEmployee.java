package ca.durhamcollege;

import java.time.LocalDate;

public class SalariedEmployee extends Employee
{
    private double yearlySalary;

    //GETTERS AND SETTERS
    public double getYearlySalary()
    {
        return yearlySalary;
    }

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

    //CONSTRUCTORS
    SalariedEmployee(String fullName, LocalDate birthDate, final String empID,double yearlySalary)
    {
        super( fullName,  birthDate,  empID);
        setYearlySalary(yearlySalary);

    }

    @Override
    public double calculatePayDay(double pay)
    {
        pay =(getYearlySalary()/52);
        return super.calculatePayDay(pay);
    }


}
