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
    private static final String PUT_ENDPOINT = "/put";
    private static final String PATCH_ENDPOINT = "/patch";
    private static final String DELETE_ENDPOINT = "/delete";
    private static final Headers expectedGetHeaders = new Headers("postman-echo.com", "close", "https", "443", "*/*");
    private static final Headers expectedPostHeaders = new Headers("postman-echo.com", "close", "https", "443", "*/*", "gzip,deflate");
    private static final Map<String, String> params = new HashMap<>() {{
        put("foo1", "bar1");
        put("foo2", "bar2");
    }};
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

        Assertions.assertEquals("https://postman-echo.com/get?foo1=bar1&foo2=bar2", ApiUtils.getResponseUrl(response), "URL не совпадает");
    }

    @Test
    void testPostMethodString() {
        String fullUri = URI + POST_ENDPOINT;

        Response response = ApiUtils.sendPostRequestRaw(fullUri, REQUEST_STRING);
        Assertions.assertEquals("This is expected to be sent back as part of response body.", ApiUtils.getResponseData(response));

        Headers actualStaticPostHeaders = HeadersBuilder.buildStaticHeadersGeneral(response);
        Headers actualDinamicPostHeaders = HeadersBuilder.buildDinamHeaders(response);
        checkResponseHeaders(actualStaticPostHeaders, actualDinamicPostHeaders);
        Assertions.assertNull(response.jsonPath().get("json"));
        Assertions.assertEquals("https://postman-echo.com/post", ApiUtils.getResponseUrl(response), "URL не совпадает");
    }

    @Test
    void testPostMethodData() {
        String fullUri = URI + POST_ENDPOINT;

        Response response = ApiUtils.sendPostRequestUrlEncoded(fullUri, params);

        Assertions.assertEquals(params, response.jsonPath().get("form"));
        Headers actualStaticPostHeaders = HeadersBuilder.buildStaticHeadersGeneral(response);
        Headers actualDinamicPostHeaders = HeadersBuilder.buildDinamHeaders(response);
        checkResponseHeaders(actualStaticPostHeaders, actualDinamicPostHeaders);
        Assertions.assertEquals(params, response.jsonPath().get("json"), "Найдено несовпадение в заголовках");
        Assertions.assertEquals("https://postman-echo.com/post", ApiUtils.getResponseUrl(response), "URL не совпадает");
    }

    @Test
    void testPutMethodeString() {
        String fullUri = URI + PUT_ENDPOINT;

        Response response = ApiUtils.sendPutRequestRaw(fullUri, REQUEST_STRING);

        Assertions.assertEquals("This is expected to be sent back as part of response body.", ApiUtils.getResponseData(response));

        Headers actualStaticPostHeaders = HeadersBuilder.buildStaticHeadersGeneral(response);
        Headers actualDinamicPostHeaders = HeadersBuilder.buildDinamHeaders(response);
        checkResponseHeaders(actualStaticPostHeaders, actualDinamicPostHeaders);
        Assertions.assertNull(response.jsonPath().get("json"));
        Assertions.assertEquals("https://postman-echo.com/put", ApiUtils.getResponseUrl(response), "URL не совпадает");
    }

    @Test
    void testPatchMethodeString() {
        String fullUri = URI + PATCH_ENDPOINT;

        Response response = ApiUtils.sendPatchRequestRaw(fullUri, REQUEST_STRING);

        Assertions.assertEquals("This is expected to be sent back as part of response body.", ApiUtils.getResponseData(response));

        Headers actualStaticPostHeaders = HeadersBuilder.buildStaticHeadersGeneral(response);
        Headers actualDinamicPostHeaders = HeadersBuilder.buildDinamHeaders(response);
        checkResponseHeaders(actualStaticPostHeaders, actualDinamicPostHeaders);
        Assertions.assertNull(response.jsonPath().get("json"));
        Assertions.assertEquals("https://postman-echo.com/patch", ApiUtils.getResponseUrl(response), "URL не совпадает");
    }

    @Test
    void testDeleteMethodeString() {
        String fullUri = URI + DELETE_ENDPOINT;
        Response response = ApiUtils.sendDeleteRequestRaw(fullUri, REQUEST_STRING);

        Assertions.assertEquals("This is expected to be sent back as part of response body.", ApiUtils.getResponseData(response));

        Headers actualStaticPostHeaders = HeadersBuilder.buildStaticHeadersGeneral(response);
        Headers actualDinamicPostHeaders = HeadersBuilder.buildDinamHeaders(response);
        checkResponseHeaders(actualStaticPostHeaders, actualDinamicPostHeaders);
        Assertions.assertNull(response.jsonPath().get("json"));
        Assertions.assertEquals("https://postman-echo.com/delete", ApiUtils.getResponseUrl(response), "URL не совпадает");
    }

    static void checkResponseHeaders(Headers actualStaticPostHeaders, Headers actualDinamicPostHeaders) {
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedPostHeaders, actualStaticPostHeaders, "Найдено несовпадение в заголовках"),
                () -> Assertions.assertNotNull(actualDinamicPostHeaders, "Присутствуют пустые заголовки")
        );
    }

}
