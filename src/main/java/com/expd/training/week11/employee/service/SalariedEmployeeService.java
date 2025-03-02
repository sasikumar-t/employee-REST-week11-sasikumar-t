package com.expd.training.week11.employee.service;


import com.expd.training.week11.employee.dao.inmemory.InMemorySalariedEmployeeDAO;
import com.expd.training.week11.employee.model.SalariedEmployee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class SalariedEmployeeService {
    private final InMemorySalariedEmployeeDAO inMemorySalariedEmployeeDAO;

    public SalariedEmployee addSalariedEmployee(SalariedEmployee salariedEmployee) {
        return inMemorySalariedEmployeeDAO.insert(salariedEmployee);
    }

    public boolean updateSalariedEmployee(SalariedEmployee employee) {
        return inMemorySalariedEmployeeDAO.update(employee);
    }
    public boolean deleteSalariedEmployee(SalariedEmployee employee) {
        return inMemorySalariedEmployeeDAO.delete(employee);
    }
    public SalariedEmployee getSalariedEmployeeById(Long empId) {
        var emp = inMemorySalariedEmployeeDAO.getById(empId);
        return emp.orElse(null);
    }
    public List<SalariedEmployee> getAllSalariedEmployees() {
        return inMemorySalariedEmployeeDAO.getAll();
    }
}
