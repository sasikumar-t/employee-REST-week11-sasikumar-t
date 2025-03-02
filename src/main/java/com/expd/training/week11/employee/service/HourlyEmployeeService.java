package com.expd.training.week11.employee.service;


import com.expd.training.week11.employee.dao.inmemory.InMemoryHourlyEmployeeDAO;
import com.expd.training.week11.employee.model.Employee;
import com.expd.training.week11.employee.model.HourlyEmployee;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class HourlyEmployeeService {
   private final InMemoryHourlyEmployeeDAO inMemoryHourlyEmployeeDAO;
   public HourlyEmployee addHourlyEmployee(HourlyEmployee hourlyEmployee) {
        return inMemoryHourlyEmployeeDAO.insert(hourlyEmployee);
    }
    public boolean updateHourlyEmployee(HourlyEmployee employee) {
        return inMemoryHourlyEmployeeDAO.update(employee);
    }
    public boolean deleteHourlyEmployee(HourlyEmployee employee) {
        return inMemoryHourlyEmployeeDAO.delete(employee);
    }
    public HourlyEmployee getHourlyEmployeeById(Long empId) {
        return inMemoryHourlyEmployeeDAO.getById(empId).orElse(null);
    }
    public List<HourlyEmployee> getAllHourlyEmployees() {
        return inMemoryHourlyEmployeeDAO.getAll();
    }
}
