package com.andy.gestion_uai.service;

import java.util.List;
import java.util.Optional;

public interface Crud<E> {
    /**
     * @param e
     * @return id
     */
    Long create(E e);

    /**
     * @param id
     * @return
     */
    Optional<E> read(Long id);
    E Update(E e);
    void deleteById(Long id);
    List<E> findAll();
}
