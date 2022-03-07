package br.com.frosit.hortifrutsj.services;

import java.util.List;

public interface CrudMethodsInterface<T> {

    List<T> findAll();

    T findById(Long id);

    T findByName(String name);

    T insert(T obj);

    T update(T obj, Long id);

    void delete(Long id);
}
