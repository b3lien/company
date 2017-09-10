package pl.akademiakodu.jpaExample.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.jpaExample.dao.PersonDao;
import pl.akademiakodu.jpaExample.model.Person;



@Controller
public class PersonController {

    @Autowired
    private PersonDao personDao;

    @GetMapping("/people/add")
    public String add(){
        return "person/add";
    }

    @PostMapping("/people/create")
    public String create (@ModelAttribute Person person){
        personDao.save(person);
        return "redirect:/people/"+person.getId();
    }

    @GetMapping("/people/{id}")
    public String findId (@PathVariable Long id, ModelMap modelMap){
        if (personDao.findById(id).isPresent()) {
            modelMap.addAttribute("person", personDao.findById(id).get());
            return "person/show";
        }
        else {
            modelMap.addAttribute("message","Nie ma takiej osoby!");
            return "person/error";
        }
    }

    @GetMapping("/people/showall")
    public String showAll (ModelMap modelMap){
        modelMap.addAttribute("people",personDao.findAll());
        return "person/showAll";
    }

    @GetMapping("/people/searchone")
    public String findOne (@RequestParam String surname, ModelMap modelMap){
        modelMap.addAttribute("person",personDao.findFirstBySurname(surname));
        return "person/show";
    }

    @GetMapping("/people/searchall")
    public String findAll (@RequestParam String surname, ModelMap modelMap) {
        modelMap.addAttribute("people",personDao.findBySurname(surname));
        return "person/searchAll";
    }

    @GetMapping("/people/remove")
    public String remove(@RequestParam Long id, ModelMap modelMap) {
        personDao.deleteById(id);
        return "person/remove";
    }

}
