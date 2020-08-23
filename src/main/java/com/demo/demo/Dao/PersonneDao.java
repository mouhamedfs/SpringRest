package com.demo.demo.Dao;

import com.demo.demo.Models.Personne;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PersonneDao {

    int insertPersonne(UUID id, Personne personne);

    default int insertPersonne(Personne personne) {
        UUID id = UUID.randomUUID();
        return insertPersonne(id,personne);
    }
    List<Personne> selectAllPeople();

    Optional<Personne> selectPersonneById(UUID id);
    int deletePersonneById(UUID id);
    int updatePersonneById(UUID id,Personne personne);
}
