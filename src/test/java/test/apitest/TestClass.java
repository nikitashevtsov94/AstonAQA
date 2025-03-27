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

    @Test
    void testGetMethod() {
        RestAssured.baseURI = URI;
        List<TestDataClass> data =
                        given()
                        .when()
                        .get("/get?foo1=bar1&foo2=bar2")
                        .then()
                        .statusCode(200)
                        .log().all()
                        .extract()
                        .body().jsonPath().getList("args", TestDataClass.class);

//        Map<String,String> headers = data.jsonPath().getMap("headers");
//
//        Assertions.assertNotNull(headers, "Поле 'headers' не должно быть null");
//        Assertions.assertEquals("postman-echo.com", headers.get("host"), "Значение 'host' неверное");
//        Assertions.assertEquals("close", headers.get("connection"), "Значение 'connection' неверное");
//        Assertions.assertEquals("https", headers.get("x-forwarded-proto"), "Значение 'x-forwarded-proto' неверное");
//        Assertions.assertEquals("443", headers.get("x-forwarded-port"), "Значение 'x-forwarded-port' неверное");
//
//        Assertions.assertEquals("https://postman-echo.com/get", response.jsonPath().getString("url"), "URL не совпадает");
    }

//    @Test
//    void testPostMethod() {
//        RestAssured.baseURI = URI;
//
//        String requestBody = "{\n    \"test\": \"value\"\n}";
//        Response response = given()
//                .contentType(ContentType.JSON)
//                .body(requestBody)
//                .when()
//                .post("/post")
//                .then()
//                .statusCode(200)
//                .log().all()
//                .extract().response();
//    }
}
