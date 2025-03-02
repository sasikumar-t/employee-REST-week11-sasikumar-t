package com.expd.training.week11.employee.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
public class SalariedEmployee extends Employee{

    private Long yearlySalary;


    @Override
    public Long calculateWeeklyPay() {
        return yearlySalary / 52;
    }
    @Override
    public String toString() {
        return String.format("Name : %s %nTitle : %s%nYearly Salary : %s %nWeekly Salary: %s %n----------------", getName(), getJobTitle(), numberFormat.format(getYearlySalary()), numberFormat.format(calculateWeeklyPay()));
    }
}
