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

    public Response sendPostRequestRaw(String uri, String requestBody) {
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

    public Response sendPostRequestUrlEncoded(String uri, Map<String, String> params) {
        RestAssured.baseURI = uri;
        return given()
                .contentType(ContentType.URLENC.withCharset("UTF-8"))
                .formParams(params)
                .log().all()
                .when()
                .post()
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
    }

    public Response sendPutRequestRaw(String uri, String requestBody) {
        RestAssured.baseURI = uri;
        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .log().all()
                .when()
                .put()
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
    }

    public Response sendPatchRequestRaw(String uri, String requestBody) {
        RestAssured.baseURI = uri;
        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .log().all()
                .when()
                .patch()
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
    }

    public Response sendDeleteRequestRaw(String uri, String requestBody) {
        RestAssured.baseURI = uri;
        return given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .log().all()
                .when()
                .delete()
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
    }
    static String getResponseUrl(Response response) {
        return response.jsonPath().getString("url");
    }
    static String getResponseData(Response response) {
        return response.jsonPath().getString("data");
    }
}
