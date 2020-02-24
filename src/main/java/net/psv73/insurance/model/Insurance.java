package net.psv73.insurance.model;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "insurance")
@Access(AccessType.FIELD)
public class Insurance {

    @Id
    @Column(unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private LocalDateTime dateStamp;

    @Column
    private String name;

    @Column
    private Type type;

    @Column
    private LocalDate start;

    @Column
    private LocalDate end;

    @Column
    private Plan plan;

    @Column
    private Person person;

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

    public Long getId() {
        return id;
    }

    public LocalDateTime getDateStamp() {
        return dateStamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public float getPayment() {
        return payment;
    }

    public void setPayment(float payment) {
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Insurance{" +
                "id=" + id +
                ", dateStamp=" + dateStamp +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", start=" + start +
                ", end=" + end +
                ", plan=" + plan +
                ", person=" + person +
                ", payment=" + payment +
                '}';
    }
}