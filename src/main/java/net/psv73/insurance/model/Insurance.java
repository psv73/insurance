package net.psv73.insurance.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@ToString
@EqualsAndHashCode
@Entity
@Table(name = "insurance")
@Access(AccessType.FIELD)
public class Insurance {

    @Getter
    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column
    private LocalDateTime dateStamp;

    @Getter
    @Setter
    @Column
    private String name;

    @Getter
    @Setter
    @Column
    private Type type;

    @Getter
    @Setter
    @Column
    private LocalDate start;

    @Getter
    @Setter
    @Column
    private LocalDate end;

    @Getter
    @Setter
    @Column
    private Plan plan;

    @Getter
    @Setter
    @Column
    private Person person;

    @Getter
    @Setter
    @Column
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