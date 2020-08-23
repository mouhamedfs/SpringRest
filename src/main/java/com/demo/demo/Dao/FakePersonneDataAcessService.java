package com.demo.demo.Dao;

import com.demo.demo.Models.Personne;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class FakePersonneDataAcessService  implements PersonneDao{

    public static final List<Personne> PD = new ArrayList<>();
    @Override
    public int insertPersonne(UUID id, Personne personne) {
        PD.add(new Personne(id, personne.getNom())) ;
        return 1;
    }

    @Override
    public List<Personne> selectAllPeople() {
        return PD;
    }

    @Override
    public Optional<Personne> selectPersonneById(UUID id) {
        return PD.stream()
                .filter(personne -> personne.getId().equals(id))
                .findFirst();
    }

    @Override
    public int deletePersonneById(UUID id) {
        Optional<Personne> personneMaybe = selectPersonneById(id);
        if(personneMaybe.isEmpty())
            return 0;
        else
            PD.remove(personneMaybe.get());
            return 1;
    }

    @Override
    public int updatePersonneById(UUID id, Personne personnetoUpdate) {
        return selectPersonneById(id)
                .map(p ->  {
                    int indexofPersonToDelete = PD.indexOf(p);
                    if(indexofPersonToDelete >= 0) {
                        PD.set(indexofPersonToDelete, new Personne(id,personnetoUpdate.getNom()));
                        return 1;
                    }
                    return 0;

                })
                .orElse(0);
    }
}
