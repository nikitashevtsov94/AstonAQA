package apitest;

import lombok.Data;


@Data

public class Headers {

    public String host;
    public String connection;
    public String xForwardedProto;
    public String xForwardedPort;
    public String accept;
    public String acceptEncoding;

    public String xRequestStart;
    public String contentLength;
    public String xAmznTraceId;
    public String contentType;
    public String userAgent;
    public String postmanToken;
    public String cookie;

    public Headers(String xRequestStart, String contentLength, String xAmznTraceId, String contentType,String userAgent, String postmanToken, String cookie) {
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
        this.xRequestStart = xRequestStart;
    }

    public Headers(String host, String connection, String xForwardedProto, String xForwardedPort, String accept, String acceptEncoding) {
        this.host = host;
        this.connection = connection;
        this.xForwardedProto = xForwardedProto;
        this.xForwardedPort = xForwardedPort;
        this.accept = accept;
        this.acceptEncoding = acceptEncoding;
    }


}
