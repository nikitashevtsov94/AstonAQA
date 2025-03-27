package apitest;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ResponseKey {

    HOST("host");

    private final String name;
}
