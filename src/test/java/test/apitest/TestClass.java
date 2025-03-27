package apitest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;


class TestClass {
    private static final String URI = "https://postman-echo.com";
    private static final String GET_REQUEST = "/get?foo1=bar1&foo2=bar2";
    @Test
    void testGetMethod() {
        RestAssured.baseURI = URI;
                Response response = RestAssured
                        .given()
                        .contentType(ContentType.JSON)
                        .when()
                        .get(GET_REQUEST)
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract()
                        .response();

        Map<String, String> args = response.jsonPath().getMap("args");

        Assertions.assertNotNull(args, "Поле 'args' не должно быть null");
        Assertions.assertEquals("bar1", args.get("foo1"), "Значение 'foo1' неверное");
        Assertions.assertEquals("bar2", args.get("foo2"), "Значение 'foo2' неверное");

        Map<String,String> headers = response.jsonPath().getMap("headers");

        Assertions.assertNotNull(headers, "Поле 'headers' не должно быть null");
        Assertions.assertEquals("postman-echo.com", headers.get(ResponseKey.HOST.getName()), "Значение 'host' неверное");
        Assertions.assertEquals("close", headers.get("connection"), "Значение 'connection' неверное");
        Assertions.assertEquals("https", headers.get("x-forwarded-proto"), "Значение 'x-forwarded-proto' неверное");
        Assertions.assertEquals("443", headers.get("x-forwarded-port"), "Значение 'x-forwarded-port' неверное");
        Assertions.assertNotNull(headers.get("x-amzn-trace-id"));
        Assertions.assertNotNull(headers.get("user-agent"));
        Assertions.assertEquals("*/*", headers.get("accept"), "Значение 'x-forwarded-port' неверное");
        Assertions.assertEquals(headers.get("cache-control"));

        Assertions.assertEquals("https://postman-echo.com/get?foo1=bar1&foo2=bar2", response.jsonPath().getString("url"), "URL не совпадает");
    }

    @Test
    void testPostMethod() {
        RestAssured.baseURI = URI;

        String requestBody = "This is expected to be sent back as part of response body.";

        Response response = given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .log().all()
                .extract().response();
        Assertions.assertEquals("This is expected to be sent back as part of response body.", response.jsonPath().get("data"));

    }
}
