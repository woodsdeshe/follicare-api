package definitions;

import com.example.Follicare.FollicareApplication;
import com.example.Follicare.model.Resources;
import com.example.Follicare.model.Specialist;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.spring.CucumberContextConfiguration;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;
import org.junit.Assert;
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

    private static RequestSpecification request;

    private static ResponseEntity<String> responseEntity;
    private static List<?> list;
    private List<Specialist> specialistList;
    private String specialty;
    private ResponseEntity<List<Specialist>> specialistResponse;
    private String zipCode;
    private List<Resources> resourcesList;

    private String title;




    public String getSecurityKey() throws Exception {
        RequestSpecification request = RestAssured.given();
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", "porshaw@gmail.com");
        requestBody.put("password", "porsha1");
        request.header("Content-Type", "application/json");
        response = request.body(requestBody.toString()).post(BASE_URL + port + "/api/users/login");
        return response.jsonPath().getString("message");
    }



    @LocalServerPort
    String port;


    @Given("a user has a valid profile")
    public void aUserHasAValidProfile() throws Exception {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().header("Authorization", "Bearer " + getSecurityKey());
        response = request.get(BASE_URL + port + "/api/profile");
    }

    @When("the user adds the specialist to their favorites")
    public void theUserAddsTheSpecialistToTheirFavorites() throws Exception {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given();
        JSONObject requestBody = new JSONObject();
        requestBody.put("id", 1L);
        requestBody.put("first name", "Specialists' first name");
        requestBody.put("last name", "Specialists' last name");
        requestBody.put("specialty", "Specialists' specialty");
        requestBody.put("zipCode", "Specialists' zipcode");
        requestBody.put("email", "Specialists' email");
        requestBody.put("phoneNumber", "Specialists' phone number");
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + getSecurityKey());
        response = request.body(requestBody.toString()).post(BASE_URL + port + "/api/favorites/1/add");
    }

    @Then("the specialist should be added to the user's favorites list")
    public void theSpecialistShouldBeAddedToTheUserSFavoritesList() {
        Assert.assertEquals(200, response.getStatusCode());
    }


    @Given("the user has added specialists to their favorites list")
    public void theUserHasAddedSpecialistsToTheirFavoritesList() {

    }

    @When("the user requests the list of specialists in their favorites list")
    public void theUserRequestsTheListOfSpecialistsInTheirFavoritesList() {

    }

    @Then("the system should return a list of specialists in their favorites list")
    public void theSystemShouldReturnAListOfSpecialistsInTheirFavoritesList() throws Exception {

    }

    @When("the user removes the specialist from their favorites")
    public void theUserRemovesTheSpecialistFromTheirFavorites() throws Exception {
        request.header("Content-Type", "application/json");
        request.header("Authorization", "Bearer " + getSecurityKey());
        response = request.delete(BASE_URL + port + "/api/favorites/1/remove/1");
    }

    @Then("the specialist should be removed from the user's favorites list")
    public void theSpecialistShouldBeRemovedFromTheUserSFavoritesList() {
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
        specialistResponse = new RestTemplate().exchange(BASE_URL + port + "/api/specialists?specialty=" + specialty, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
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
        specialistResponse = new RestTemplate().exchange(BASE_URL + port + "/api/specialists?zipCode=" + zipCode, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
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
        specialistResponse = new RestTemplate().exchange(BASE_URL + port + "/api/specialists?zipCode=" + zipCode + "&specialty=" + specialty, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
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
        responseEntity = new RestTemplate().exchange(BASE_URL + port + "/api/resources/all", HttpMethod.GET, null, String.class);
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
        title = "Hair";
    }

    @When("the user searches for resources by title")
    public void theUserSearchesForResourcesByTitle() {
        String url = BASE_URL + port + "/api/resources?partialTitle=";
        ResponseEntity<List<Resources>> resourceResponse = new RestTemplate().exchange(url + title, HttpMethod.GET, null, new ParameterizedTypeReference<>() {
        });
        resourcesList = resourceResponse.getBody();
    }

    @Then("a list of resources related to that title should be returned")
    public void aListOfResourcesRelatedToThatTitleShouldBeReturned() {
        Assert.assertNotNull(resourcesList);
        Assert.assertFalse(resourcesList.isEmpty());
        for (Resources resource : resourcesList) {
            Assert.assertTrue(resource.getTitle().contains(title));
        }
    }

    @Given("a user account is available")
    public void aUserAccountIsAvailable() throws Exception {
        RestAssured.baseURI = BASE_URL;
        RequestSpecification request = RestAssured.given().header("Authorization", "Bearer " + getSecurityKey());
        response = request.get(BASE_URL + port + "/api/users/1");
    }

    @When("I go to my profile")
    public void iGoToMyProfile() {
        Assert.assertNotNull(String.valueOf(response));
    }

    @Then("I can see my account details")
    public void iCanSeeMyAccountDetails() {
        Assert.assertEquals(200, response.getStatusCode());
    }

}
