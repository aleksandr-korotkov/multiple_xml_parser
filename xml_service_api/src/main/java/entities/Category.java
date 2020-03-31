package entities;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import java.util.List;
import java.util.Objects;

public class Category {

    @XmlAttribute
    private String name;

    @XmlElement(name = "subcategory")
    private List<SubCategory> subCategory;

    public Category() {
    }

    public Category(String name, List<SubCategory> subCategory) {
        this.name = name;
        this.subCategory = subCategory;
    }

    public String getName() {
        return name;
    }

    public List<SubCategory> getSubCategory() {
        return subCategory;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                ", subCategory=" + subCategory +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(subCategory, category.subCategory);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, subCategory);
    }
}