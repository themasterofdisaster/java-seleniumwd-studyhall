/*
    Parameterized Tests

        Parameters in RESTful APIs

        There are two types of parameters:

        PATH PARAMETERS

            Where the parameter value is simply part of the URL that you call when you invoke the API.
            This is the one that our API under test also uses.

            http://api.zippopotam.us/us/90210
            http://api.zippopotam.us/ca/B2R

            In the first example above US and 90210 are path parameters.
            In the second example CA and B2R are different values for the same path parameters

        QUERY PARAMETERS

            We can recognize query parameters by the question mark (?) followed by key/value tuples separated by an equal sign.

            For example, here's a different API that calculates the MD5 checksum for a plain text string.

            http://md5.jsontest.com?text=apple
            http://md5.jsontest.com?text=banana

            In the case of this different API, you specify query parameters with a key text and a value: ?text=apple
            The value can ben any text (?text=randomword), and in response it will return the MD5 value for that specific
            value of the text query parameter.

        To parameterize the test in the example below,I am going to stick to our test API http://api.zippopotam.us, so
        I am going to stick to path parameters.
        I am using TestNG's built in data provider mechanism.

 */

package restassured;

import org.testng.annotations.*;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ParameterizedTests {

    // This will provide our parameters for the test
    @DataProvider (name="zipCodesAndPlaces")
    public Object[][] zipCodesAndPlaces(){
        return new Object[][]{
            { "us", "90210", "Beverly Hills" },
            { "us", "12345", "Schenectady" },
            { "ca", "B2R", "Waverley"}
        };
    }

    @Test (dataProvider = "zipCodesAndPlaces")
    public void someTest(String countryCode, String zipCode, String expectedPlace){

        given().pathParam("countryCode", countryCode).pathParam("zipCode", zipCode).
                when().get("http://zippopotam.us/{countryCode}/{zipCode}").
        then().assertThat().body("places[0].'place name'", equalTo(expectedPlace));

    }
}
