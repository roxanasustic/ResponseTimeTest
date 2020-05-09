package ResponseTimeTest;

import com.jayway.restassured.RestAssured;
import org.junit.Test;

import static com.jayway.restassured.RestAssured.get;
import static com.jayway.restassured.RestAssured.given;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.lessThan;

public class GraylogResponseTimeTest {

    @Test
    public void ResponseTime(){

        RestAssured.baseURI = "http://elastic:elastic@192.168.99.102:9200/graylog_0/";
        String json = get("_search?pretty&q=8906d6e1-ef29-4265-9510-b061a7e93127").asString();
        System.out.println(json);

        given().
                parameters("q","8906d6e1-ef29-4265-9510-b061a7e93127").
                when().
                get("_search").
                then().
                body("hits.hits._source.message", contains("This is a test message")).
                and().time(lessThan(10L));

    }

}
