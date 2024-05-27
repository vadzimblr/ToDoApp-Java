package bsu.poznyak.projectmanagementapplication.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public interface IDaoRepository<T> {
    abstract void insert(T entity);
    abstract List<T> getAll();

    abstract T getById(int id);

    abstract void update(T entity);


}
