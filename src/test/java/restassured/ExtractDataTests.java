package restassured;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.hasSize;

public class ExtractDataTests extends SpecBuildersTests{

    @Test
    public void extractPlaceNameFromResponseBody_assertEqualToBeverlyHills(){
        String placeName =
                given().
                        spec(requestSpec).
                        when().
                        get("us/90210").
                        then().extract().path("places[0].'place name'");

        Assert.assertEquals(placeName, "Beverly Hills");
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
