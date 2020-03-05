package net.psv73.insurance.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ToString
@EqualsAndHashCode
@Entity
@Data
@Table(name = "insurance")
@Access(AccessType.FIELD)
public class Insurance {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dateStamp;

    private String name;

    private Type type;

    private LocalDate start;

    private LocalDate end;

    private Plan plan;

    private Person person;

    private float payment;

    public Insurance() {
    }

    public Insurance(String name, Type type, LocalDate start, LocalDate end, Plan plan, Person person, float payment) {
        this.name = name;
        this.type = type;
        this.start = start;
        this.end = end;
        this.plan = plan;
        this.person = person;
        this.payment = payment;
    }

  }