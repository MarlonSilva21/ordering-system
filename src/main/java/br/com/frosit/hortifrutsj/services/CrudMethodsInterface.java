package br.com.frosit.hortifrutsj.services;

import java.util.List;

public interface CrudMethodsInterface<T> {

    List<T> findAll();

    T findById(Long id);

    T findByName(String name);

    T insertCategory(T obj);

    T updateCategory(T obj, Long id);

    void deleteCategory(Long id);
}
