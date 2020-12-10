package ca.durhamcollege;

import java.time.LocalDate;
import java.util.regex.Pattern;

public abstract class Employee extends Person
{
    private String empID;

    //Getters and Setters

    public String getEmpID()
    {
        return empID;
    }


    //Constructor
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
    //public methods
    public double calculatePayDay()
    {
        double pay=0.0;

        return pay;
    }
}
