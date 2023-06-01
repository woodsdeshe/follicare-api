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

    @Given("the user has added specialists to their favorites list")
    public void theUserHasAddedSpecialistsToTheirFavoritesList() {
    }

    @When("the user requests the list of specialists in their favorites list")
    public void theUserRequestsTheListOfSpecialistsInTheirFavoritesList() {
    }

    @Then("the system should return a list of specialists in their favorites list")
    public void theSystemShouldReturnAListOfSpecialistsInTheirFavoritesList() {
    }

    @Given("a user has a specialist in their favorites list")
    public void aUserHasASpecialistInTheirFavoritesList() {
    }

    @When("the user removes the specialist from their favorites")
    public void theUserRemovesTheSpecialistFromTheirFavorites() {
    }

    @Then("the specialist should be removed from the user's favorites list")
    public void theSpecialistShouldBeRemovedFromTheUserSFavoritesList() {
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

    @Given("a user has a specific hair disorder")
    public void aUserHasASpecificHairDisorder() {
    }

    @When("the user searches for specialists by hair disorder")
    public void theUserSearchesForSpecialistsByHairDisorder() {
    }

    @Then("a list of specialists specializing in that hair disorder should be returned")
    public void aListOfSpecialistsSpecializingInThatHairDisorderShouldBeReturned() {
    }

    @Given("a user has a specific zip code")
    public void aUserHasASpecificZipCode() {
    }

    @When("the user searches for specialists by zip code")
    public void theUserSearchesForSpecialistsByZipCode() {
    }

    @Then("a list of specialists located in that zip code should be returned")
    public void aListOfSpecialistsLocatedInThatZipCodeShouldBeReturned() {
    }

    @Given("a user has a specific hair disorder and zip code")
    public void aUserHasASpecificHairDisorderAndZipCode() {
    }

    @When("the user searches for specialists by hair disorder and zip code")
    public void theUserSearchesForSpecialistsByHairDisorderAndZipCode() {
    }

    @Then("a list of specialists specializing in the hair disorder and located in the zip code should be returned")
    public void aListOfSpecialistsSpecializingInTheHairDisorderAndLocatedInTheZipCodeShouldBeReturned() {
    }

    @Given("there are multiple topics in the system")
    public void thereAreMultipleTopicsInTheSystem() {
    }

    @When("the user requests the list of all topics")
    public void theUserRequestsTheListOfAllTopics() {
    }

    @Then("the system should return a list of all topics")
    public void theSystemShouldReturnAListOfAllTopics() {
    }

    @Given("a user provides a specific topic name")
    public void aUserProvidesASpecificTopicName() {
    }

    @When("the user searches for resources by topic")
    public void theUserSearchesForResourcesByTopic() {
    }

    @Then("a list of resources related to that topic should be returned")
    public void aListOfResourcesRelatedToThatTopicShouldBeReturned() {
    }
}
