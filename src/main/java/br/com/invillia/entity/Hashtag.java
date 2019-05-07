package br.com.invillia.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class Hashtag {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String value;

    public Hashtag() {
    }

    public Hashtag(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    @Override
    public boolean equals(final Object other) {
        if (!(other instanceof Hashtag)) {
            return false;
        }
        Hashtag castOther = (Hashtag) other;
        return Objects.equals(id, castOther.id) && Objects.equals(value, castOther.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, value);
    }

}

