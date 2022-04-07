package product;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;

public class Product {

    String userName = "dinitha";
    String password = "dinitha";

    @Test
    public void GetProductDetails() {
        // Specify the base URL to the RESTful web service
        RestAssured.baseURI = "http://localhost:8080/";
        // Get the RequestSpecification of the request to be sent to the server.
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.auth().basic(userName,password);
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.get("/products");
        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());

    }

    @Test
    public void createProduct() {
        RestAssured.baseURI = "http://localhost:8080/";
        // Get the RequestSpecification of the request to be sent to the server.
        File jsonDataInFile = new File("src/test/java/product/createProduct.json");
        RequestSpecification httpRequest = RestAssured.given();
        httpRequest.header("Content-Type", "application/json");
        httpRequest.auth().basic(userName,password);
        httpRequest.body(jsonDataInFile);
        // specify the method type (GET) and the parameters if any.
        //In this case the request does not take any parameters
        Response response = httpRequest.post("products");
        // Print the status and message body of the response received from the server
        System.out.println("Status received => " + response.getStatusLine());
        System.out.println("Response=>" + response.prettyPrint());
    }
}
