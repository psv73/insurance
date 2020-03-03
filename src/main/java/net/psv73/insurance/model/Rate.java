package net.psv73.insurance.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@EqualsAndHashCode
@Component
@ConfigurationProperties(prefix = "app")
public class Rate {

    private float basicDay;

    private float basicYear;

    private float extendedDay;

    private float extendedYear;

    private float extraDay;

    private float extraYear;

    private float cancellationDay;

    private float cancellationYear;

    private float sportDay;

    private float sportYear;

    private String name;

    public Rate() {
    }

}
