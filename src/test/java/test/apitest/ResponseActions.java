package apitest;

import io.restassured.response.Response;
import lombok.experimental.UtilityClass;

import java.util.Map;

@UtilityClass
public class ResponseActions {

    public static String getResponseUrl(Response response) {
        return response.jsonPath().getString(ResponseKey.URL.getName());
    }

    public static String getResponseData(Response response) {
        return response.jsonPath().getString(ResponseKey.DATA.getName());
    }

    public static Map<String, String> getResponseForm(Response response) {
        return response.jsonPath().get(ResponseKey.FORM.getName());
    }

    public static Map<String, String> getResponseJson(Response response) {
        return response.jsonPath().get(ResponseKey.JSON.getName());
    }

    public static Map<String, String> getResponseHeaders(Response response) {
        return response.jsonPath().getMap(ResponseKey.HEADERS.getName());
    }
}
