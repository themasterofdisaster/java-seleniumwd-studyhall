/*
    Cocktail Search Tests

    API page: https://www.thecocktaildb.com/api.php?ref=apilist.fun
    API sample search: https://www.thecocktaildb.com/api/json/v1/1/search.php?f=a
 */
package restassured.practicetests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class CocktailSearchTests {

    private String requestZCocktails = "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=z";

    @Test
    public void requestCocktailsByName(){

        given().log().all().
                when().get(requestZCocktails).
                then().log().body();
    }

    @Test
    public void requestCocktailsByLetterZ_assertZombieIsListed(){

        given().
                when().get(requestZCocktails).
                then().assertThat().body("drinks.strDrink", hasItem("Zombie"));
    }


    @Test
    public void requestCocktailsByLetterZ_assert3IsZombie(){

        given().
                when().get(requestZCocktails).
                then().assertThat().body("drinks[3].strDrink", equalTo("Zombie"));
    }

}
