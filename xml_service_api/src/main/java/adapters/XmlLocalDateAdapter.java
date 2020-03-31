package adapters;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class XmlLocalDateAdapter extends XmlAdapter<String, LocalDate> {
    public LocalDate unmarshal(String v) {
        return LocalDate.parse(v, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public String marshal(LocalDate v)  {
        return v.toString();
    }
}