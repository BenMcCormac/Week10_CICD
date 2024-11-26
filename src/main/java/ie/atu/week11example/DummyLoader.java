package ie.atu.week11example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DummyLoader implements CommandLineRunner
{
    private final PersonRepository personRepository;

    @Autowired
    public DataLoader(PersonRepository personRepository)
    {
        this.personRepository = personRepository;
    }

    @Override
    public void run(String... args) throws Exception
    {
        Person testData = new Person(1L, "Ben", 21, "g00416547@atu.ie", "Mr", "416547", "Student", "Electronics");
    }
}
