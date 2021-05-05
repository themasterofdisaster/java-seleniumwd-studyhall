# About Rest Assured


#### Update the pom.xml file 

Add the following in the dependencies section (or create one) to indicate we have a dependency with rest-assured.

    <dependency>
          <groupId>io.rest-assured</groupId>
          <artifactId>rest-assured</artifactId>
          <version>RELEASE</version>
    </dependency>


#### API Under Test

http://zippopotam.us/

A simple RESTful API that supplies location data based on the country code and the zip code that you supply in your API 
request.

If we want to use this API in our REST Assured tests, we can send a GET call at to this locator which contains two path 
parameters, namely US as a country code and 90210 as the zip code for which we want to retrieve the location data.

    _GET http://api.zippopotam.us/us/90210
    
If you perform this request using REST Assured, the response will look something like this:

    {
      post code: "90210",
      country: "United States",
      country abbreviation: "US",
      places: [
        {
          place name: "Beverly Hills",
          longitude: "-118.4065",
          state: "California",
          state abbreviation: "CA",
          latitude: "34.0901"
        }
      ]
    }

in the response, you get a list of places associated with the country code and the zip code that you specified, 
and in this case, the API returns a single place, namely Beverly Hills in the state of California.

The API also returns some response headers, including the status code which indicates that everything went fine, 
and the Content-Type, which tells us, or rather, the consumer of the API, that the content type of the response is 
application/json which helps the API consumer decode the response body.


    
    