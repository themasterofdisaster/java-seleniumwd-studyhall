/*
    Pokemon API Tests

    API page: https://pokeapi.co/
    API sample search: https://pokeapi.co/api/v2/pokemon/ditto

 */
package restassured.practicetests;

import org.testng.annotations.Test;

import static org.hamcrest.Matchers.*;
import static io.restassured.RestAssured.*;

public class WhosThatPokemonTests {

    @Test
    public void requestDittoData(){
        given().
                when().get("https://pokeapi.co/api/v2/pokemon/ditto").
                then().log().body();

    }

    @Test
    public void requestDittoData_hasAbilityImporter(){
        given().
                when().get("https://pokeapi.co/api/v2/pokemon/ditto").
                then().assertThat().body("abilities.ability.name", hasItem("imposter"));

    }
}
