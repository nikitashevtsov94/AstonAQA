package apitest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseKey {

    HOST("host"),
    X_REQUEST_START("x-request-start"),
    CONNECTION("connection"),
    CONTENT_LENGTH("content-length"),
    X_FORWARDED_PROTO("x-forwarded-proto"),
    X_FORWARDED_PORT("x-forwarded-port"),
    X_AMZN_TRACE_ID("x-amzn-trace-id"),
    CONTENT_TYPE("content-type"),
    USER_AGENT("user-agent"),
    ACCEPT("accept"),
    POSTMAN_TOKEN("postman-token"),
    ACCEPT_ENCODING("accept-encoding"),
    COOKIE("cookie"),
    GET_PARAM1("foo1"),
    GET_PARAM2("foo2"),
    URL("url"),
    DATA("data"),
    FORM("form"),
    JSON("json"),
    ARGS("args"),
    HEADERS("headers");

    private final String name;
}
