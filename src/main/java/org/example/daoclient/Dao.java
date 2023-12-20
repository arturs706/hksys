package org.example.daoclient;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface Dao<T> {

    Optional<T> get(UUID client_id);

    List<T> getAll();

    void save(T t);

    void update(T t, String[] params);

    void delete(T t);
}