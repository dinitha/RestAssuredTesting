package tutorial;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.junit.Test;

public class PostExample {

    @Test
    public void UserRegistrationSuccessful()
    {
        RestAssured.baseURI = "https://demoqa.com/BookStore/v1/Books";
        RequestSpecification request = RestAssured.given();
        JSONObject requestParams = new JSONObject();
        requestParams.put("userId", "TQ123");
        requestParams.put("isbn", "9781449325862");
        // Add a header stating the Request body is a JSON
        request.header("Content-Type", "application/json"); // Add the Json to the body of the request
        request.body(requestParams.toJSONString());
        Response response = request.post("/BookStoreV1BooksPost");
        System.out.println("The status received: " + response.statusLine());
        System.out.println(response.getStatusLine());
        System.out.println(response.asString());
    }
}
