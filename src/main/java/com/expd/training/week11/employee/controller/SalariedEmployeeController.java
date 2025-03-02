package com.expd.training.week11.employee.controller;

import com.expd.training.week11.employee.model.SalariedEmployee;
import com.expd.training.week11.employee.service.SalariedEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("/employee/salaried")
public class SalariedEmployeeController {

    private final SalariedEmployeeService salariedEmployeeService;

    @GetMapping
    public ResponseEntity<List<SalariedEmployee>> getEmployees() {
        return ResponseEntity.ok(salariedEmployeeService.getAllSalariedEmployees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<SalariedEmployee> getHourlyEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(salariedEmployeeService.getSalariedEmployeeById(id));
    }

    @PostMapping
    public ResponseEntity<SalariedEmployee> addHourlyEmployee(@RequestBody SalariedEmployee employee) {
        return ResponseEntity.ok(salariedEmployeeService.addSalariedEmployee(employee));
    }

    @PutMapping("/id")
    public ResponseEntity<SalariedEmployee> updateHourlyEmployee(@PathVariable Long id, @RequestBody SalariedEmployee employee) {
        if (!Objects.equals(employee.getEmployeeId(), id))
            return ResponseEntity.notFound().build();
        boolean success = salariedEmployeeService.updateSalariedEmployee(employee);
        return success ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<SalariedEmployee> deleteEmployee(@RequestBody SalariedEmployee employee) {
        boolean isDelete = salariedEmployeeService.deleteSalariedEmployee(employee);
        return isDelete ? ResponseEntity.ok(employee) : ResponseEntity.notFound().build();
    }
}
