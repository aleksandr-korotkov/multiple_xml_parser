package entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Objects;

@XmlRootElement
public class RootElement {

    @XmlElement(name = "category")
    private List<Category> categories;

    public RootElement() {
    }

    public RootElement(List<Category> categories) {
        this.categories = categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    @Override
    public String toString() {
        return "ProductList{" +
                "categories=" + categories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RootElement that = (RootElement) o;
        return Objects.equals(categories, that.categories);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categories);
    }
}