package restassured;

import org.testng.annotations.Test;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;


public class BasicTests {

    @Test
    public void requestUsZipCode90210_checkStatusCode_expectHttp200() {

        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                statusCode(200);
    }

    @Test
    public void requestUsZipCode90210_checkContentType_expectApplicationJson() {

        given().
                when().
                get("http://zippopotam.us/us/90210").
                then().
                assertThat().
                contentType(ContentType.JSON);
        // Another way to test for JSON content type:
        // then().assertThat().contentType(“application/json”);
    }

    @Test
    public void requestUsZipCode90210_logRequestAndResponseDetails() {

        given().
                log().all(). // tells REST Assured to write everything there is to know about the API request to the standard output.
                when().
                get("http://zippopotam.us/us/90210").
                then().
                log().body(); // tells REST Assured to log the contents of the response body to the standard output.
    }

}