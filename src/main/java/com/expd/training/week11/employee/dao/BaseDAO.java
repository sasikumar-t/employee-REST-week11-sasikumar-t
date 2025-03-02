package com.expd.training.week11.employee.dao;

import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public interface BaseDAO<T> {
    boolean update(T updateObject);
    boolean delete(T deleteObject);
    T insert(T newObject);
    Optional<T> getById(Long id);
    List<T> getAll();
    void resetDataStore();
    default List<T> getBy(Predicate<T> pred) {
        return getAll().stream()
                .filter(pred)
                .collect(toList());
    }
}
