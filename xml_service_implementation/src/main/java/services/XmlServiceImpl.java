package services;

import entities.RootElement;

import javax.xml.bind.*;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;

public class XmlServiceImpl implements XmlService {

    private static final String XML_SOURCE = "xml_service_implementation/src/main/resources/";
    private static final String XML_ROOT_ELEMENT = "products";


    @Override
    public Optional<Object> convertXmlToObject() throws IOException {
        try (InputStream xml_source_stream_for_parsing = getClass()
                .getClassLoader().getResourceAsStream("products.xml")){
            StreamSource xml = new StreamSource(xml_source_stream_for_parsing);
            XMLInputFactory xif = XMLInputFactory.newFactory();
            XMLStreamReader xmlStreamReader = xif.createXMLStreamReader(xml);
            xmlStreamReader.nextTag();
            while (!xmlStreamReader.getLocalName().equals(XML_ROOT_ELEMENT)) {
                xmlStreamReader.nextTag();
            }
            JAXBContext jc = JAXBContext.newInstance(RootElement.class);
            Unmarshaller unmarshaller = jc.createUnmarshaller();
            JAXBElement<RootElement> jb = unmarshaller.unmarshal(xmlStreamReader, RootElement.class);
            xmlStreamReader.close();
            return Optional.of(jb.getValue());
        }
        catch (XMLStreamException e){
            e.printStackTrace();
        }
        catch (JAXBException e){
            e.printStackTrace();
        }

        return Optional.empty();
    }

    @Override
    public void printProduct(Object element){
        System.out.println(element.toString());
    }

    @Override
    public void convertObjectToXml(Object rootElement, String xmlFileName){
        try {
            File file = new File(XML_SOURCE + xmlFileName);
            if(!file.exists()){
                file.createNewFile();
            }
            JAXBContext jaxbContext = JAXBContext.newInstance(RootElement.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(rootElement, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

