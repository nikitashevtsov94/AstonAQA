package apitest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseKey {

    HOST("host"),
    CONNECTION("connection"),
    X_FORWARDED_PROTO("x-forwarded-proto"),
    X_FORWARDED_PORT("x-forwarded-port"),
    USER_ASGENT("user-agent"),
    ACCEPT("accept"),
    ACCEPT_ENCODING("accept-encoding");

    private final String name;
}
