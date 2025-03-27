package apitest;

import lombok.AllArgsConstructor;
import lombok.Data;


@AllArgsConstructor
@Data
public class Headers {

    public String host;
    public String connection;
    public String xForwardedProto;
    public String xForwardedPort;
    public String accept;

}
