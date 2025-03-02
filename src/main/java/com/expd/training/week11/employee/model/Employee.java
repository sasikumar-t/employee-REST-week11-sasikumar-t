package com.expd.training.week11.employee.model;

import lombok.Data;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Objects;
@Data
public abstract class Employee {
    private Long employeeId;
    private String name;
    private String jobTitle;

    private final Locale locale = Locale.US;
    protected final NumberFormat numberFormat = NumberFormat.getCurrencyInstance(locale);


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) && Objects.equals(jobTitle, employee.jobTitle);
    }

    @Override
    public String toString() {
        return String.format("Name : %s %nTitle : %s%n----------------", getName(), getJobTitle());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, jobTitle);
    }

    public abstract Long calculateWeeklyPay();
}
