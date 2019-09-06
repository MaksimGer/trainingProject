package com.netcracker.onlinestore2.domain.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Attribute {
    @Id
    @GeneratedValue()
    private Long id;

    private String name;

    public Attribute() {
    }

    public Attribute(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Attribute attribute = (Attribute) o;
        return Objects.equals(id, attribute.id) &&
                Objects.equals(name, attribute.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
