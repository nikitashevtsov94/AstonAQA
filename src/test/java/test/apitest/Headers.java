package apitest;

import lombok.Data;


@Data
public class Headers {

    private String host;
    private String connection;
    private String xForwardedProto;
    private String xForwardedPort;
    private String accept;
    private String acceptEncoding;
    private String xRequestStart;
    private String contentLength;
    private String xAmznTraceId;
    private String contentType;
    private String userAgent;
    private String postmanToken;
    private String cookie;

    public Headers(String xRequestStart, String contentLength, String xAmznTraceId, String contentType, String userAgent,
                   String postmanToken, String cookie) {
        this.xRequestStart = xRequestStart;
        this.contentLength = contentLength;
        this.xAmznTraceId = xAmznTraceId;
        this.contentType = contentType;
        this.userAgent = userAgent;
        this.postmanToken = postmanToken;
        this.cookie = cookie;
    }

    public Headers(String host, String connection, String xForwardedProto, String xForwardedPort, String accept) {
        this.host = host;
        this.connection = connection;
        this.xForwardedProto = xForwardedProto;
        this.xForwardedPort = xForwardedPort;
        this.accept = accept;
    }

    public Headers(String host, String connection, String xForwardedProto, String xForwardedPort, String accept,
                   String acceptEncoding) {
        this.host = host;
        this.connection = connection;
        this.xForwardedProto = xForwardedProto;
        this.xForwardedPort = xForwardedPort;
        this.accept = accept;
        this.acceptEncoding = acceptEncoding;
    }
}
