package apitest;

import io.restassured.response.Response;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
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
    private static final Headers expectedGeneralHeaders = new Headers("postman-echo.com", "close", "https", "443", "*/*", "gzip,deflate");
    private static final Args expectedArgs = new Args("bar1", "bar2");
    private static final Map<String, String> params = new HashMap<>() {{
        put("foo1", "bar1");
        put("foo2", "bar2");
    }};
    private static final String REQUEST_BODY_STRING = "This is expected to be sent back as part of response body.";
    private static final String ASSERTION_MESSAGE_URL_COMPARE = "URL не совпадает";

    @Test
    @DisplayName("Тест запроса GET")
    void testGetMethod() {
        String fullUri = URI + GET_ENDPOINT;
        Response response = ApiUtils.sendGetRequest(fullUri, params);
        Headers actualStaticGetHeaders = HeadersBuilder.buildStaticHeadersGet(response);
        Headers actualDinamicGetHeaders = HeadersBuilder.buildDinamHeaders(response);
        checkResponseHeaders(actualStaticGetHeaders, actualDinamicGetHeaders, expectedGetHeaders);
        Args actualArgsValues = ArgsBuilder.buildArgs(response);
        Assertions.assertEquals(expectedArgs, actualArgsValues, "Значение ключа неверно");
        Assertions.assertEquals(fullUri + "?foo1=bar1&foo2=bar2", ResponseActions.getResponseUrl(response),
                ASSERTION_MESSAGE_URL_COMPARE);
    }

    @Test
    @DisplayName("Тест запроса POST со строкой")
    void testPostMethodString() {
        String fullUri = URI + POST_ENDPOINT;
        Response response = ApiUtils.sendPostRequestRaw(fullUri, REQUEST_BODY_STRING);
        Assertions.assertEquals(REQUEST_BODY_STRING, ResponseActions.getResponseData(response));
        Headers actualStaticPostHeaders = HeadersBuilder.buildStaticHeadersGeneral(response);
        Headers actualDinamicPostHeaders = HeadersBuilder.buildDinamHeaders(response);
        checkResponseHeaders(actualStaticPostHeaders, actualDinamicPostHeaders, expectedGeneralHeaders);
        Assertions.assertNull(ResponseActions.getResponseJson(response));
        Assertions.assertEquals(fullUri, ResponseActions.getResponseUrl(response), ASSERTION_MESSAGE_URL_COMPARE);
    }

    @Test
    @DisplayName("Тест запроса POST с параметрами")
    void testPostMethodData() {
        String fullUri = URI + POST_ENDPOINT;
        Response response = ApiUtils.sendPostRequestUrlEncoded(fullUri, params);
        Assertions.assertEquals(params, ResponseActions.getResponseForm(response));
        Headers actualStaticPostHeaders = HeadersBuilder.buildStaticHeadersGeneral(response);
        Headers actualDinamicPostHeaders = HeadersBuilder.buildDinamHeaders(response);
        checkResponseHeaders(actualStaticPostHeaders, actualDinamicPostHeaders, expectedGeneralHeaders);
        Assertions.assertEquals(params, ResponseActions.getResponseJson(response), "Найдено несовпадение в заголовках");
        Assertions.assertEquals(fullUri, ResponseActions.getResponseUrl(response), ASSERTION_MESSAGE_URL_COMPARE);
    }

    @Test
    @DisplayName("Тест запроса PUT")
    void testPutMethodeString() {
        String fullUri = URI + PUT_ENDPOINT;
        Response response = ApiUtils.sendPutRequestRaw(fullUri, REQUEST_BODY_STRING);
        Assertions.assertEquals(REQUEST_BODY_STRING, ResponseActions.getResponseData(response));
        Headers actualStaticPostHeaders = HeadersBuilder.buildStaticHeadersGeneral(response);
        Headers actualDinamicPostHeaders = HeadersBuilder.buildDinamHeaders(response);
        checkResponseHeaders(actualStaticPostHeaders, actualDinamicPostHeaders, expectedGeneralHeaders);
        Assertions.assertNull(ResponseActions.getResponseJson(response));
        Assertions.assertEquals(fullUri, ResponseActions.getResponseUrl(response), ASSERTION_MESSAGE_URL_COMPARE);
    }

    @Test
    @DisplayName("Тест запроса PATCH")
    void testPatchMethodeString() {
        String fullUri = URI + PATCH_ENDPOINT;
        Response response = ApiUtils.sendPatchRequestRaw(fullUri, REQUEST_BODY_STRING);
        Assertions.assertEquals(REQUEST_BODY_STRING, ResponseActions.getResponseData(response));
        Headers actualStaticPostHeaders = HeadersBuilder.buildStaticHeadersGeneral(response);
        Headers actualDinamicPostHeaders = HeadersBuilder.buildDinamHeaders(response);
        checkResponseHeaders(actualStaticPostHeaders, actualDinamicPostHeaders, expectedGeneralHeaders);
        Assertions.assertNull(ResponseActions.getResponseJson(response));
        Assertions.assertEquals(fullUri, ResponseActions.getResponseUrl(response), ASSERTION_MESSAGE_URL_COMPARE);
    }

    @Test
    @DisplayName("Тест запроса DELETE")
    void testDeleteMethodeString() {
        String fullUri = URI + DELETE_ENDPOINT;
        Response response = ApiUtils.sendDeleteRequestRaw(fullUri, REQUEST_BODY_STRING);
        Assertions.assertEquals(REQUEST_BODY_STRING, ResponseActions.getResponseData(response));
        Headers actualStaticPostHeaders = HeadersBuilder.buildStaticHeadersGeneral(response);
        Headers actualDinamicPostHeaders = HeadersBuilder.buildDinamHeaders(response);
        checkResponseHeaders(actualStaticPostHeaders, actualDinamicPostHeaders, expectedGeneralHeaders);
        Assertions.assertNull(ResponseActions.getResponseJson(response));
        Assertions.assertEquals(fullUri, ResponseActions.getResponseUrl(response), ASSERTION_MESSAGE_URL_COMPARE);
    }

    private static void checkResponseHeaders(Headers actualStaticPostHeaders, Headers actualDinamicPostHeaders, Headers expectedHeaders) {
        Assertions.assertAll(
                () -> Assertions.assertEquals(expectedHeaders, actualStaticPostHeaders, "Найдено несовпадение в заголовках"),
                () -> Assertions.assertNotNull(actualDinamicPostHeaders, "Присутствуют пустые заголовки")
        );
    }
}
