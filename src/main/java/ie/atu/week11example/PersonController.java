package ie.atu.week11example;

import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/person")
@RestController
public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{ID}")
    public ResponseEntity<?> getPerson(@PathVariable String ID) {
        if (ID.length() > 5 || ID.isBlank()) {
            return ResponseEntity.badRequest().body("EmployeeId is invalid");
        }

        Person person = personService.getPersonByEmployeeId(ID);

        if (person == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(person);
    }

    @PostMapping("/createPerson")
    public ResponseEntity<String>create(@Valid @RequestBody Person person) {
        personService.savePerson(person);
        return new ResponseEntity<>("Person created successfully", HttpStatus.OK);
    }
    
    @PutMapping("/replace/{ID}")
    public ResponseEntity<String>create(@Valid @RequestBody Person rperson, @PathVariable String ID)
    {
        if (ID.length() > 5 || ID.isBlank()) {
            return ResponseEntity.badRequest().body("EmployeeId is invalid");
        }

        if (rperson == null) {
            return ResponseEntity.notFound().build();
        }
        else
        {

        }

        personService.savePerson(rperson);
        return rperson;
    }
}
