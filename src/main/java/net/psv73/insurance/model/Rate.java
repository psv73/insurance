package net.psv73.insurance.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@ToString
@EqualsAndHashCode
@Component
@PropertySource("classpath:application.properties")
@ConfigurationProperties(prefix = "app")
public class Rate {

    @Getter
    @Setter
    private float basicDay;

    @Getter
    @Setter
    private float basicYear;

    @Getter
    @Setter
    private float extendedDay;

    @Getter
    @Setter
    private float extendedYear;

    @Getter
    @Setter
    private float extraDay;

    @Getter
    @Setter
    private float extraYear;

    @Getter
    @Setter
    private float cancellationDay;

    @Getter
    @Setter
    private float cancellationYear;

    @Getter
    @Setter
    private float sportDay;

    @Getter
    @Setter
    private float sportYear;

    @Getter
    @Setter
    private String name;

    public Rate() {
    }

}
