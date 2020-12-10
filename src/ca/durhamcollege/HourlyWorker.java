package ca.durhamcollege;

import java.time.LocalDate;

public class HourlyWorker extends Employee
{
    // PRIVATE INSTANCE VARIABLES
    private double hourlyRate;
    private double hoursPerWeek;

    // ACCESSORS
    public double getHourlyRate()
    {
        return hourlyRate;
    }
    public double getHoursPerWeek()
    {
        return hoursPerWeek;
    }

    // MUTATORS
    public void setHoursPerWeek(double hoursPerWeek)
    {
        if (hoursPerWeek <= 48.0)
        {
            this.hoursPerWeek = hoursPerWeek;
        }
        else
        {
            throw new IllegalArgumentException( hoursPerWeek+" is an invalid amount of hours. The maximum hours you can work in a week is 48.0 hours");
        }
    }

    public void setHourlyRate(double hourlyRate)
    {
        if (hourlyRate>=17.0)
        {
            this.hourlyRate = hourlyRate;
        }
        else
        {
            throw new IllegalArgumentException( hourlyRate+" is an invalid hourly rate. The minimum wage is $17.00");
        }

    }

    // PARAMETERIZED CONSTRUCTOR
    HourlyWorker(String fullName, LocalDate birthDate, final String empID, double hourlyRate, double hoursPerWeek)
    {
        super(fullName,birthDate, empID);
        setHourlyRate(hourlyRate);
       setHoursPerWeek(hoursPerWeek);
    }

    //PUBLIC METHODS
    @Override
    public double calculatePayDay()
    {
      double pay = (double)Math.round( (getHoursPerWeek()*getHourlyRate()) * 100.0)/100.0;
        return super.calculatePayDay()+pay;
    }
}
