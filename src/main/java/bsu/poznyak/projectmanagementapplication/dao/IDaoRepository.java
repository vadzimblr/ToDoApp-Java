package bsu.poznyak.projectmanagementapplication.dao;

import java.util.List;

public interface IDaoRepository<T> {
    void insert(T entity);
    List<T> getAll();

    T getById(int id);

    void update(T entity);

    void deleteById(int id);


}
