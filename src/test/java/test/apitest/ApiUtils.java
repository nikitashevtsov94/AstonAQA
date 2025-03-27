package apitest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

import java.util.Map;

import static io.restassured.RestAssured.given;

@UtilityClass
public class ApiUtils {

    public Response sendGetRequest(String uri, Map<String, String> params) {
        RestAssured.baseURI = uri;
        return RestAssured
                .given()
                .contentType(ContentType.JSON)
                .queryParams(params)
                .when()
                .get()
                .then()
                .statusCode(200)
                .log().all()
                .extract()
                .response();
    }

    public Response sendPostRequest(String uri, String requestBody) {
        RestAssured.baseURI = uri;
        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post()
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
    }

    public Response sendPostRequest(String uri, Map<String, String> params) {
        RestAssured.baseURI = uri;
        return given()
                .contentType(ContentType.JSON)
                .body(params)
                .when()
                .post()
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
    }
}
