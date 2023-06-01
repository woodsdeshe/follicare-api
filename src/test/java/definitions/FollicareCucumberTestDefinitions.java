package definitions;

import com.example.Follicare.FollicareApplication;
import io.cucumber.java.en.Given;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FollicareApplication.class)
public class FollicareCucumberTestDefinitions {
    @Given("a user has a valid profile and a specialist exists")
    public void aUserHasAValidProfileAndASpecialistExists() {

    }
}
