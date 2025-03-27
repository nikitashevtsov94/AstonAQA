package apitest;

public class Headers {

    public String host;

    public Headers(String host, String connection, String xForwardedProto, String xForwardedPort, String userAgent, String accept, String acceptEncoding) {
        this.host = host;
        this.connection = connection;
        this.xForwardedProto = xForwardedProto;
        this.xForwardedPort = xForwardedPort;
        this.userAgent = userAgent;
        this.accept = accept;
        this.acceptEncoding = acceptEncoding;
    }

    public String connection;
    public String xForwardedProto;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    public String getxForwardedProto() {
        return xForwardedProto;
    }

    public void setxForwardedProto(String xForwardedProto) {
        this.xForwardedProto = xForwardedProto;
    }

    public String getxForwardedPort() {
        return xForwardedPort;
    }

    public void setxForwardedPort(String xForwardedPort) {
        this.xForwardedPort = xForwardedPort;
    }

    public String getUserAgent() {
        return userAgent;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept;
    }

    public String getAcceptEncoding() {
        return acceptEncoding;
    }

    public void setAcceptEncoding(String acceptEncoding) {
        this.acceptEncoding = acceptEncoding;
    }

    public String xForwardedPort;
    public String userAgent;
    public String accept;
    public String acceptEncoding;
}
