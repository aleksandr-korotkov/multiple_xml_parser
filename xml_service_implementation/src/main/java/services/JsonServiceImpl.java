package services;

import com.fasterxml.jackson.databind.ObjectMapper;
import entities.RootElement;

import java.io.File;
import java.io.IOException;
import java.util.Optional;

public class JsonServiceImpl implements JsonService {
    private static final String SOURCE_JSON = "src/main/resources/product.json";
    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void convertObjectToJSon(Object rootElement){
        try {
            File file = new File(SOURCE_JSON);
            if(!file.exists()){
                file.createNewFile();
            }
            mapper.writeValue(file, rootElement);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Optional<Object> convertJsonToObject(){
        try {
            return Optional.of(mapper.readValue(new File(SOURCE_JSON), RootElement.class));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }
}
