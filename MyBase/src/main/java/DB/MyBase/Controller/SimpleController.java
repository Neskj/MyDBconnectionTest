package DB.MyBase.Controller;

import DB.MyBase.Model.Person;
import DB.MyBase.Repository.MyRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SimpleController {

    private final MyRepository myRepository;

    SimpleController(MyRepository myRepository){
        this.myRepository=myRepository;
    }

    @GetMapping("/data")
    public List<Person> getData(){

        List<Person> listOfPerson=myRepository.showData();

       return  listOfPerson;

    }
}
