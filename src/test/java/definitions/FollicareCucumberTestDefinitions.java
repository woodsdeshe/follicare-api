package definitions;

import com.example.Follicare.FollicareApplication;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FollicareApplication.class)
public class FollicareCucumberTestDefinitions {
    @Given("a user has a valid profile and a specialist exists")
    public void aUserHasAValidProfileAndASpecialistExists() {
    }

    @When("the user adds the specialist to their favorites")
    public void theUserAddsTheSpecialistToTheirFavorites() {
        
    }

    @Then("the specialist should be added to the user's favorites list")
    public void theSpecialistShouldBeAddedToTheUserSFavoritesList() {
        
    }

    @Given("there are multiple specialists in the system")
    public void thereAreMultipleSpecialistsInTheSystem() {


    }

    @When("the user requests the list of all specialists")
    public void theUserRequestsTheListOfAllSpecialists() {
    }

    @Then("the system should return a list of all specialists")
    public void theSystemShouldReturnAListOfAllSpecialists() {
    }
}
