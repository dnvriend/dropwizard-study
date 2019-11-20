package com.github.dnvriend.dao;

import com.github.dnvriend.jpa.PersonJpa;
import io.dropwizard.hibernate.AbstractDAO;
import java.util.List;
import java.util.Optional;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

public class PersonDao extends AbstractDAO<PersonJpa> {

    public PersonDao(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public Optional<PersonJpa> findById(Long id) {
        return Optional.ofNullable(get(id));
    }

    public PersonJpa create(PersonJpa person) {
        return persist(person);
    }

    @SuppressWarnings("unchecked")
    public List<PersonJpa> findAll() {
        return list((Query<PersonJpa>) namedQuery("com.github.dnvriend.jpa.PersonJpa.findAll"));
    }
}
