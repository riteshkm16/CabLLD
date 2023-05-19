package io.riteshkm16.lld.cab.repository;

import java.util.List;

public interface InMemoryRepository<T> {
    /*
    return T on success , null on failure
     */
    T save(T t);
    /*
    return T on success , null on failure
     */
    T update(T t);
    /*
    return T on success , null on failure
     */
    T getById(Integer id);
    List<T> getAll();
}
