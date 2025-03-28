package apitest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;


class TestClass {

    private static final String URI = "https://postman-echo.com";
    private static final String GET_ENDPOINT = "/get";
    private static final String POST_ENDPOINT = "/post";
    private static final Headers expectedGetHeaders = new Headers("postman-echo.com", "close", "https","443", "*/*");
    private static final Headers expectedPostHeaders = new Headers("postman-echo.com", "close", "https","443", "*/*", "gzip,deflate");
    private static final Map<String, String> params = new HashMap<>(){{put("foo1", "bar1"); put("foo2", "bar2");}};
    private static final String REQUEST_STRING = "This is expected to be sent back as part of response body.";

    @Test
    void testGetMethod() {
        String fullUri = URI + GET_ENDPOINT;

        Response response = ApiUtils.sendGetRequest(fullUri, params);
        Headers actualStaticGetHeaders = HeadersBuilder.buildStaticHeadersGet(response);
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedGetHeaders, actualStaticGetHeaders, "Найдено несовпадение в заголовках"));

        Headers actualDinamicGetHeaders = HeadersBuilder.buildDinamHeaders(response);
        Assertions.assertNotNull(actualDinamicGetHeaders, "Присутствуют пустые заголовки");

        Map<String, String> args = response.jsonPath().getMap("args");
        Assertions.assertEquals("bar1", args.get("foo1"), "Значение 'foo1' неверное");
        Assertions.assertEquals("bar2", args.get("foo2"), "Значение 'foo2' неверное");

        Assertions.assertEquals("https://postman-echo.com/get?foo1=bar1&foo2=bar2", response.jsonPath().getString("url"), "URL не совпадает");
    }

    @Test
    void testPostMethodString() {
        String fullUri = URI + POST_ENDPOINT;

        Response response = ApiUtils.sendPostRequest(fullUri, REQUEST_STRING);
        Assertions.assertEquals("This is expected to be sent back as part of response body.", response.jsonPath().get("data"));

        Headers actualStaticPostHeaders = HeadersBuilder.buildStaticHeadersGeneral(response);
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedPostHeaders, actualStaticPostHeaders, "Найдено несовпадение в заголовках")
        );
        Headers actualDinemicPostHeaders = HeadersBuilder.buildDinamHeaders(response);
        Assertions.assertNotNull(actualDinemicPostHeaders, "Присутствуют пустые заголовки");
        Assertions.assertNull(response.jsonPath().get("json"));
        Assertions.assertEquals("https://postman-echo.com/post", response.jsonPath().getString("url"), "URL не совпадает");
    }
}
