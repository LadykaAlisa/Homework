package ResponseDto;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import java.util.List;

public class RestTests {
    @Test
    public void restTestsWithLocation() {

        ResponseDto responseDto = RestAssured.given()
                .queryParam("inc", "gender,name,location,nat")
                .queryParam("results", "100")
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .get()
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .extract()
                .as(ResponseDto.class);

        System.out.println(responseDto.getResults().size());

        List<PersonDto> results = responseDto.results;

        results.stream()
                .filter(p -> "male".equals(p.getGender()))
                .filter(p -> "Ukraine".equals(p.getLocation().getCountry()))
                .map(p ->
                          p.getName().getFirst() + " "
                        + p.getName().getLast() + " — "
                        + p.getLocation().getCity() + " , "
                        + p.getLocation().getStreet().getName() + " , "
                        + p.getLocation().getStreet().getNumber() + " , "
                        + p.getLocation().getCoordinates().getLatitude() + " , "
                        + p.getLocation().getCoordinates().getLongitude() + " , "
                        + p.getLocation().getTimezone().getOffset() + " , "
                        + p.getLocation().getTimezone().getDescription())

                .forEach(System.out::println);

        long countUkraine = results.stream()
                .filter(p -> "Ukraine".equals(p.getLocation().getCountry()))
                .count();

        System.out.println("Користувачів з України: " + countUkraine);

    }
}

