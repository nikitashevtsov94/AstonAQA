package apitest;

import io.restassured.response.Response;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Map;

@Data
@AllArgsConstructor
public class HeadersBuilder {

    public static Headers buildStaticHeadersGet(Response response) {
        Map<String,String> headers = response.jsonPath().getMap("headers");
        String host = headers.get(ResponseKey.HOST.getName());
        String connection = headers.get(ResponseKey.CONNECTION.getName());
        String xForwardedProto = headers.get(ResponseKey.X_FORWARDED_PROTO.getName());
        String xForwardedPort = headers.get(ResponseKey.X_FORWARDED_PORT.getName());
        String accept = headers.get(ResponseKey.ACCEPT.getName());
        return new Headers(host, connection, xForwardedProto, xForwardedPort, accept);
    }

    public static Headers buildStaticHeadersGeneral(Response response) {
        Map<String,String> headers = response.jsonPath().getMap("headers");
        String host = headers.get(ResponseKey.HOST.getName());
        String connection = headers.get(ResponseKey.CONNECTION.getName());
        String xForwardedProto = headers.get(ResponseKey.X_FORWARDED_PROTO.getName());
        String xForwardedPort = headers.get(ResponseKey.X_FORWARDED_PORT.getName());
        String accept = headers.get(ResponseKey.ACCEPT.getName());
        String acceptEncoding = headers.get(ResponseKey.ACCEPT_ENCODING.getName());
        return new Headers(host, connection, xForwardedProto, xForwardedPort, accept, acceptEncoding);
    }

    public static Headers buildDinamHeaders(Response response) {
        Map<String,String> headers = response.jsonPath().getMap("headers");
        String xRequestStart = headers.get(ResponseKey.X_REQUEST_START.getName());
        String contentLength = headers.get(ResponseKey.CONTENT_LENGTH.getName());
        String xAmznTraceId = headers.get(ResponseKey.X_AMZN_TRACE_ID.getName());
        String contentType = headers.get(ResponseKey.CONTENT_TYPE.getName());
        String userAgent = headers.get(ResponseKey.USER_AGENT.getName());
        String postmanToken = headers.get(ResponseKey.POSTMAN_TOKEN.getName());
        String cookie = headers.get(ResponseKey.COOKIE.getName());
        return new Headers(xRequestStart, contentLength, xAmznTraceId, contentType, userAgent, postmanToken, cookie);
    }
}
