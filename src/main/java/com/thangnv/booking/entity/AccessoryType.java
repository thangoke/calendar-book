package com.thangnv.booking.entity;

import com.thangnv.booking.entity.audit.AuditableEntity;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;

@Entity
@Table(name = "accessory_type")
public class AccessoryType extends AuditableEntity {
    @Id
    @GeneratedValue(generator = "sequence-generator")
    @GenericGenerator(
            name = "sequence-generator",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {@Parameter(name = "sequence_name", value = "accessory_type_seq")}
    )
    private Long id;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    public Long getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
