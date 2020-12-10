package ca.durhamcollege;

import java.time.LocalDate;

public class HourlyWorker extends Employee
{
    private double hourlyRate;
    private double hoursPerWeek;

    public double getHourlyRate()
    {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate)
    {
        this.hourlyRate = hourlyRate;
    }

    public double getHoursPerWeek()
    {
        return hoursPerWeek;
    }

    public void setHoursPerWeek(double hoursPerWeek)
    {
        this.hoursPerWeek = hoursPerWeek;
    }

    //Constructor
    HourlyWorker(String fullName, LocalDate birthDate, final String empID, double hourlyRate, double hoursPerWeek)
    {
        super(fullName,birthDate, empID);
        this.hourlyRate= hourlyRate;
        this.hoursPerWeek=hoursPerWeek;
    }

    @Override
    public double calculatePayDay(double pay)
    {
        pay = (getHoursPerWeek()*getHourlyRate());
        return super.calculatePayDay(pay);
    }
}
