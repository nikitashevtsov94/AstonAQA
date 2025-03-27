package apitest;

import io.restassured.response.Response;

import java.util.Map;

public class HeadersBuilder {

    public static Headers buildHeaders(Response response) {
        Map<String,String> headers = response.jsonPath().getMap("headers");
        String host = headers.get(ResponseKey.HOST.getName());
        String connection = headers.get(ResponseKey.CONNECTION.getName());
        String xForwardedProto = headers.get(ResponseKey.X_FORWARDED_PROTO.getName());
        String xForwardedPort = headers.get(ResponseKey.X_FORWARDED_PORT.getName());
        String accept = headers.get(ResponseKey.ACCEPT.getName());
        String acceptEncoding = headers.get(ResponseKey.ACCEPT_ENCODING.getName());
        return new Headers(host, connection, xForwardedProto, xForwardedPort, accept);
    }
}
