package entities;

import adapters.JsonLocalDateDeserializer;
import adapters.JsonLocalDateSerializer;
import adapters.XmlLocalDateAdapter;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import enums.Color;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.Objects;

public class Product {
    @XmlElement
    private String manufacturer;
    @XmlElement
    private String model;
    @JsonDeserialize(using = JsonLocalDateDeserializer.class)
    @JsonSerialize(using = JsonLocalDateSerializer.class)
    @XmlElement(name = "dateofmanufacture")
    @XmlJavaTypeAdapter(XmlLocalDateAdapter.class)
    private LocalDate dateOfManufacture;
    @XmlElement
    private Color color;
    @XmlElement
    private Double price;
    @XmlElement(name = "count")
    private Count count;

    public String getManufacturer() {
        return manufacturer;
    }

    public String getModel() {
        return model;
    }

    public LocalDate getDateOfManufacture() {
        return dateOfManufacture;
    }

    public Color getColor() {
        return color;
    }

    public Double getPrice() {
        return price;
    }
    public Count getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Product{" +
                "manufacturer='" + manufacturer + '\'' +
                ", model='" + model + '\'' +
                ", dateOfManufacture=" + dateOfManufacture +
                ", color=" + color +
                ", price=" + price +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(manufacturer, product.manufacturer) &&
                Objects.equals(model, product.model) &&
                Objects.equals(dateOfManufacture, product.dateOfManufacture) &&
                color == product.color &&
                Objects.equals(price, product.price) &&
                Objects.equals(count, product.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(manufacturer, model, dateOfManufacture, color, price, count);
    }
}