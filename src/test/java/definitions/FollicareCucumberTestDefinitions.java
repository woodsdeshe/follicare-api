package definitions;

import com.example.Follicare.FollicareApplication;
import com.example.Follicare.model.Resources;
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
    private List<Specialist> specialistList;
    private String specialty;
    private ResponseEntity<List<Specialist>> specialistResponse;
    private String zipCode;
    private List<Resources> resourcesList;
    private ResponseEntity<List<Resources>> resourceResponse;
    private String title;



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
        specialistResponse = new RestTemplate().exchange(BASE_URL + port + "/api/specialists?specialty=" + specialty, HttpMethod.GET, null, new ParameterizedTypeReference<List<Specialist>>() {
        });
        specialistList = specialistResponse.getBody();
    }

    @Then("a list of specialists specializing in that hair disorder should be returned")
    public void aListOfSpecialistsSpecializingInThatHairDisorderShouldBeReturned() {
        Assert.assertNotNull(specialistList);
        Assert.assertFalse(specialistList.isEmpty());
        for (Specialist specialist : specialistList) {
            Assert.assertEquals(specialty, specialist.getSpecialty());
        }
    }


    @Given("a specialist in located in a specific zip code")
    public void specialistInASpecificZipCode() {
        zipCode = "49505";
    }

    @When("the user searches for specialists by zip code")
    public void theUserSearchesForSpecialistsByZipCode() {
        specialistResponse = new RestTemplate().exchange(BASE_URL + port + "/api/specialists?zipCode=" + zipCode, HttpMethod.GET, null, new ParameterizedTypeReference<List<Specialist>>() {
        });
        specialistList = specialistResponse.getBody();

    }

    @Then("a list of specialists located in that zip code should be returned")
    public void aListOfSpecialistsLocatedInThatZipCodeShouldBeReturned() {
        Assert.assertNotNull(specialistList);
        Assert.assertFalse(specialistList.isEmpty());
        for (Specialist specialist: specialistList) {
            Assert.assertEquals(zipCode, specialist.getZipCode());
        }
    }

    @Given("a specialist specializes in a specific specialty and is located in a specific zip code")
    public void aSpecialistSpecializesInASpecificSpecialtyAndIsLocatedInASpecificZipCode() {
        zipCode = "49505";
        specialty = "Alopecia Areata";

    }

    @When("the user searches for specialists by specialty and zip code")
    public void theUserSearchesForSpecialistsBySpecialtyAndZipCode() {
        specialistResponse = new RestTemplate().exchange(BASE_URL + port + "/api/specialists?zipCode=" + zipCode + "&specialty=" + specialty, HttpMethod.GET, null, new ParameterizedTypeReference<List<Specialist>>() {
        });
        specialistList = specialistResponse.getBody();
    }

    @Then("a list of specialists specializing in the specialty and located in the zip code should be returned")
    public void aListOfSpecialistsSpecializingInTheSpecialtyAndLocatedInTheZipCodeShouldBeReturned() {
        Assert.assertNotNull(specialistList);
        Assert.assertFalse(specialistList.isEmpty());
        for (Specialist specialist: specialistList) {
            Assert.assertEquals(zipCode, specialist.getZipCode());
            Assert.assertEquals(specialty, specialist.getSpecialty());
        }
    }

    @Given("there are multiple topics in the system")
    public void thereAreMultipleTopicsInTheSystem() {
        responseEntity = new RestTemplate().exchange(BASE_URL + port + "/api/resources", HttpMethod.GET, null, String.class);
        list = JsonPath.from(String.valueOf(responseEntity.getBody())).get();
    }

    @When("the user requests the list of all topics")
    public void theUserRequestsTheListOfAllTopics() {
        Assert.assertTrue(list.size() > 0);
    }

    @Then("the system should return a list of all topics")
    public void theSystemShouldReturnAListOfAllTopics() {
        Assert.assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
    }

    @Given("a user provides a specific topic title")
    public void aUserProvidesASpecificTopicTitle() {
        
    }

    @When("the user searches for resources by title")
    public void theUserSearchesForResourcesByTitle() {
        
    }

    @Then("a list of resources related to that title should be returned")
    public void aListOfResourcesRelatedToThatTitleShouldBeReturned() {
    }
}
