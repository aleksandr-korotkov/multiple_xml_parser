package services;

import java.io.IOException;
import java.util.Optional;

public interface XmlService <T>{

    Optional<T> convertXmlToObject() throws IOException;

    void convertObjectToXml(T rootElement, String xmlFileName);

    void printProduct(T element);
}
