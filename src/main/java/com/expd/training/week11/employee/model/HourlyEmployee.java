package com.expd.training.week11.employee.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class HourlyEmployee extends Employee {

    private int hoursWorked;
    private Long hourlyPayRate;

    public Long calculateWeeklyPay() {
        return hoursWorked * hourlyPayRate;
    }
    public Long calculateYearlyPay() {
        return (hoursWorked * hourlyPayRate * 52);
    }
    @Override
    public String toString() {
        return String.format("Name : %s %nTitle : %s%nHours Worked: %s%n Hourly Pay Rate : %s %nWeekly Pay: %s %n Yearly Pay: %s %n----------------", getName(), getJobTitle(),getHoursWorked(), numberFormat.format(getHourlyPayRate()), numberFormat.format(calculateWeeklyPay()),numberFormat.format(calculateYearlyPay()));
    }
}
