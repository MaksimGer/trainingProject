package com.netcracker.onlinestore2.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "Params")
public class Params {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne()
    @JoinColumn(name = "product_id")
    private Product product;

    @ManyToOne()
    @JoinColumn(name = "attribute_id")

    private Attribute attribute;

    private String value;

    public Params() {}

    public Params(Product product, Attribute attribute, String value) {
        this.product = product;
        this.attribute = attribute;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Attribute getAttribute() {
        return attribute;
    }

    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Params params = (Params) o;
        return  Objects.equals(product, params.product) &&
                Objects.equals(attribute, params.attribute);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product, attribute);
    }
}
