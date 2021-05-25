package restassured;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class SpecBuildersTests {

    protected static RequestSpecification requestSpec;
    protected static ResponseSpecification responseSpec;

    @BeforeClass
    public  static void createRequestSpecification(){
        requestSpec = new RequestSpecBuilder().
                setBaseUri("http://zippopotam.us").
                build();
    }

    @BeforeClass
    public static void createResponseSpecification(){
        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }

    @Test
    public void requestUsZipCode90210_checkPlaceNameInResponseBody_expectBeverlyHills() {

        given().
                spec(requestSpec).
                when().
                    get("us/90210").
                then().
                    spec(responseSpec).
                and().
                    assertThat().
                    body("places[0].'place name'", equalTo("Beverly Hills")).
                    body("places[0].state", equalTo("California")).
                    body("places.'place name'", not(hasItem("Hermosillo"))).
                    body("places.'place name'", hasSize(1));
    }

}
