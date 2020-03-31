package services;

import java.util.Optional;

public interface JsonService <T> {

    void convertObjectToJSon(T rootElement);

    Optional<T> convertJsonToObject();
}
