package com.github.dnvriend.controller;

import com.github.dnvriend.converter.PersonConverter;
import com.github.dnvriend.dao.PersonDao;
import com.github.dnvriend.dto.PersonDto;
import io.dropwizard.hibernate.UnitOfWork;
import java.util.Optional;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/person")
@Produces(MediaType.APPLICATION_JSON)
public class PersonController {

    private final PersonDao personDao;

    public PersonController(PersonDao personDao) {
        this.personDao = personDao;
    }

    @GET
    @Path("/static")
    public PersonDto getPerson() {
        return PersonDto.builder()
            .id(1L)
            .name("foo")
            .age(42)
            .build();
    }

    // https://www.dropwizard.io/en/stable/manual/core.html#paths
    @GET
    @Path("/{id}")
    @UnitOfWork
    public Optional<PersonDto> getPersonById(@PathParam("id") Long id) {
        return personDao.findById(id).map(PersonConverter::jpaToDto);
    }

    @PUT
    @UnitOfWork
    public void putPerson(PersonDto person) {
        personDao.create(PersonConverter.dtoToJpa(person));
    }
}
