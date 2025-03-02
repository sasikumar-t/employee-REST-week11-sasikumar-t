package com.expd.training.week11.employee.dao.inmemory;


import com.expd.training.week11.employee.dao.BaseDAO;
import com.expd.training.week11.employee.model.HourlyEmployee;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

@Repository
public class InMemoryHourlyEmployeeDAO implements BaseDAO<HourlyEmployee> {
    Map<Long, HourlyEmployee> employeeHashMap = new ConcurrentHashMap<>();
    AtomicLong atomicInteger = new AtomicLong(1L);

    @Override
    public boolean update(HourlyEmployee updateObject) {
        return employeeHashMap.computeIfPresent(updateObject.getEmployeeId(),(key,oldValue) -> updateObject ) != null;
    }

    @Override
    public boolean delete(HourlyEmployee deleteObject) {
        return employeeHashMap.remove(deleteObject.getEmployeeId()) != null;
    }

    @Override
    public HourlyEmployee insert(HourlyEmployee newObject) {
        Long empId = atomicInteger.getAndIncrement();
        newObject.setEmployeeId(empId);
        employeeHashMap.put(empId, newObject);
        return newObject;
    }

    @Override
    public Optional<HourlyEmployee> getById(Long id) {
        return Optional.ofNullable(employeeHashMap.get(id));
    }

    @Override
    public List<HourlyEmployee> getAll() {
        return new ArrayList<>(employeeHashMap.values());
    }

    @Override
    public void resetDataStore() {
        employeeHashMap = new ConcurrentHashMap<>();
        atomicInteger = new AtomicLong(1L);
    }
}