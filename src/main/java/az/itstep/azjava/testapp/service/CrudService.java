package az.itstep.azjava.testapp.service;

import java.util.List;

public interface CrudService<T, ID> {
    T get(ID id);
    List<T> getAll();
    T save(T t);
    T update(T t);
    void delete(ID id);
}
