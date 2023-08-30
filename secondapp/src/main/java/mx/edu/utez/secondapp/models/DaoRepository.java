package mx.edu.utez.secondapp.models;

import java.util.List;

public interface DaoRepository<T>{
    List<T> findAll();
    boolean save(T object);
    boolean delete(Long id);
}
