package com.demo.demo.Service;

import com.demo.demo.Dao.PersonneDao;
import com.demo.demo.Models.Personne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonneService {

    @Autowired
    private PersonneDao personneDao;

    public PersonneService(@Qualifier("fakeDao") PersonneDao personneDao) {
        this.personneDao = personneDao;
    }

    public  int addPersonne(Personne personne) {
        return personneDao.insertPersonne(personne);
    }
    public List<Personne> getListPersonne() {
        return personneDao.selectAllPeople();
    }
    public Optional<Personne> selectPerById(UUID id){
        return personneDao.selectPersonneById(id);
    }
    public  int deletePersonneByid(UUID id) {
       return personneDao.deletePersonneById(id);
    }

    public int updatePersonneByid(UUID id,Personne newPersonne) {
        return personneDao.updatePersonneById(id,newPersonne);
    }
}
