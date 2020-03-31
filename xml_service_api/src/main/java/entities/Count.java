package entities;

import javax.xml.bind.annotation.XmlAttribute;
import java.util.Objects;

public class Count {
    @XmlAttribute
    private int availability;

    public int getAvailability() {
        return availability;
    }

    @Override
    public String toString() {
        return "Count{" +
                "availability=" + availability +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Count count = (Count) o;
        return availability == count.availability;
    }

    @Override
    public int hashCode() {
        return Objects.hash(availability);
    }
}