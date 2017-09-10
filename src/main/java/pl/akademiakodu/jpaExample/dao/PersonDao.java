package pl.akademiakodu.jpaExample.dao;

import org.springframework.data.repository.CrudRepository;
import pl.akademiakodu.jpaExample.model.Person;

import java.util.List;

public interface PersonDao extends CrudRepository<Person,Long> {
    Person findFirstBySurname(String surname);
    List<Person> findBySurname (String surname);
}
