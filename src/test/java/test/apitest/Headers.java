package apitest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Headers {

    public String host;
    public String connection;
    public String xForwardedProto;
    public String xForwardedPort;
    public String userAgent;
    public String accept;
    public String acceptEncoding;

}
