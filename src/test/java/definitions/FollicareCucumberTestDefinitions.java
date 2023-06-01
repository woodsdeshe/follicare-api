package definitions;

import com.example.Follicare.FollicareApplication;
import com.example.Follicare.model.Specialist;
import com.example.Follicare.repository.SpecialistRepository;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CucumberContextConfiguration
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT, classes = FollicareApplication.class)
public class FollicareCucumberTestDefinitions {

    private static final String BASE_URL = "http://localhost:";
    private static Response response;
    private static ResponseEntity<String> responseEntity;
    private static List<?> list;
    private static RequestSpecification request;
    private List<Specialist> specialistsBySpecialty;
    private String specialty;
    private ResponseEntity<List<Specialist>> specialtyResponse;



    @Autowired
    private SpecialistRepository specialistRepository;

    @LocalServerPort
    String port;


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
        responseEntity = new RestTemplate().exchange(BASE_URL + port + "/api/specialists", HttpMethod.GET, null, String.class);
        list = JsonPath.from(String.valueOf(responseEntity.getBody())).get();
    }

    @When("the user requests the list of all specialists")
    public void theUserRequestsTheListOfAllSpecialists() {
        Assert.assertTrue(list.size() > 0);
    }

    @Then("the system should return a list of all specialists")
    public void theSystemShouldReturnAListOfAllSpecialists() {
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Given("a specialist specializes in a specific specialty")
    public void aSpecialistSpecializesInASpecificSpecialty() {
        specialty = "Alopecia Areata";
    }

    @When("the user searches for specialists by hair disorder")
    public void theUserSearchesForSpecialistsByHairDisorder() {
        specialtyResponse = new RestTemplate().exchange(BASE_URL + port + "/api/specialists?specialty=" + specialty, HttpMethod.GET, null, new ParameterizedTypeReference<List<Specialist>>() {
        });
        specialistsBySpecialty = specialtyResponse.getBody();
    }

    @Then("a list of specialists specializing in that hair disorder should be returned")
    public void aListOfSpecialistsSpecializingInThatHairDisorderShouldBeReturned() {
        Assert.assertNotNull(specialistsBySpecialty);
        Assert.assertFalse(specialistsBySpecialty.isEmpty());
        for (Specialist specialist : specialistsBySpecialty) {
            System.out.println("Actual Specialist Specialty: " + specialist.getSpecialty());
            System.out.println("Expected Specialty: " + specialty);

            Assert.assertEquals(specialty, specialist.getSpecialty());
        }
    }


}
