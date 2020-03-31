import entities.RootElement;
import services.JsonService;
import services.JsonServiceImpl;
import services.XmlService;
import services.XmlServiceImpl;


public class Main {
    public static void main(String[] args) throws Throwable {

        XmlService service = new XmlServiceImpl();
        RootElement rootElementFromXml = (RootElement) service.convertXmlToObject().orElseThrow(NullPointerException::new);
        service.printProduct(rootElementFromXml);

//        JsonService convertService = new JsonServiceImpl();
//        convertService.convertObjectToJSon(rootElementFromXml);
//        RootElement rootElementFromJson = (RootElement) convertService.convertJsonToObject().orElseThrow(NullPointerException::new);
//
//        System.out.println(rootElementFromXml.equals(rootElementFromJson));

        //service.convertObjectToXml(rootElementFromJson, "new.xml");

    }
}