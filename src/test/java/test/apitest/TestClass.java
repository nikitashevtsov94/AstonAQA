package apitest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


class TestClass {

    private static final String URI = "https://postman-echo.com";
    private static final String GET_ENDPOINT = "/get";
    private static final String POST_ENDPOINT = "/post";
    private static final Headers expectedHeaders = new Headers("postman-echo.com", "close", "https",
            "443", "PostmanRuntime/7.43.0", "*/*", "gzip, deflate, br");
    private static final Map<String, String> params = Map.of("foo1", "bar1", "foo2", "bar2");

    @Test
    void testGetMethod() {
        String fullUri = URI + GET_ENDPOINT;

        Response response = ApiUtils.sendGetRequest(fullUri, params);
        Headers actualHeaders = HeadersBuilder.buildHeaders(response);

        Assertions.assertEquals(expectedHeaders, actualHeaders, "Найдено несовпадение в заголовках");

        Map<String, String> args = response.jsonPath().getMap("args");
        Assertions.assertNotNull(args, "Поле 'args' не должно быть null");
        Assertions.assertEquals("bar1", args.get("foo1"), "Значение 'foo1' неверное");
        Assertions.assertEquals("bar2", args.get("foo2"), "Значение 'foo2' неверное");
        Assertions.assertEquals("https://postman-echo.com/get?foo1=bar1&foo2=bar2", response.jsonPath().getString("url"), "URL не совпадает");
    }

    @Test
    void testPostMethod() {
        String fullUri = URI + POST_ENDPOINT;
        String requestBody = "This is expected to be sent back as part of response body.";
        Response response = ApiUtils.sendPostRequest(fullUri, requestBody);
        Assertions.assertEquals("This is expected to be sent back as part of response body.", response.jsonPath().get("data"));

    }
}
