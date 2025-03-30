package apitest;

import io.restassured.response.Response;

import java.util.Map;

public class ArgsBuilder {

    public static Args buildArgs(Response response) {
        Map<String, String> args = response.jsonPath().getMap(ResponseKey.ARGS.getName());
        String value1 = args.get(ResponseKey.GET_PARAM1.getName());
        String value2 = args.get(ResponseKey.GET_PARAM2.getName());
        return new Args(value1, value2);
    }
}
