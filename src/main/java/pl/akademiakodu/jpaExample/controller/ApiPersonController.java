package pl.akademiakodu.jpaExample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.akademiakodu.jpaExample.dao.PersonDao;
import pl.akademiakodu.jpaExample.model.Person;

@RestController
public class ApiPersonController {

    @Autowired
    private PersonDao personDao;

    @GetMapping ("api/people/searchone")
    public @ResponseBody Person search (@RequestParam String surname){
        return personDao.findFirstBySurname(surname);
    }
}
