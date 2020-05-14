package com.psv73.insurance.util;

import com.psv73.insurance.model.*;

import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Utils {

    public static Map<String, Object> getInsurance(Optional<Insurance> insurance) {

        Map<String, Object> data = new HashMap<>();

        data.put("insurances", insurance);

        data.put("type", Type.values());

        data.put("plan", Plan.values());

        data.put("person", Person.values());

        return data;
    }

    public static float calculatePayment(Insurance insurance, Rate rate) {

        float payment = 0;

        if (insurance.getType() == Type.YEAR) {

            switch (insurance.getPlan()) {
                case BASIC: {
                    payment = payment + rate.getBasicYear();
                    break;
                }
                case EXTENDED: {
                    payment = payment + rate.getExtendedYear();
                    break;
                }
                case EXTRA: {
                    payment = payment + rate.getExtraYear();
                    break;
                }
            }

            if (insurance.isCancellationTravel()) {
                payment = payment * rate.getCancellationTravelYear();
            }

            if (insurance.isSportActive()) {
                payment = payment * rate.getSportActiveYear();
            }

        } else {

            long days = insurance.getStart().until(insurance.getEnd(), ChronoUnit.DAYS);

            switch (insurance.getPlan()) {
                case BASIC: {
                    payment = payment + rate.getBasicDay() * days;
                    break;
                }
                case EXTENDED: {
                    payment = payment + rate.getExtendedDay() * days;
                    break;
                }
                case EXTRA: {
                    payment = payment + rate.getExtraDay() * days;
                    break;
                }
            }

            if (insurance.isCancellationTravel()) {
                payment = payment * rate.getCancellationTravelDay();
            }

            if (insurance.isSportActive()) {
                payment = payment * rate.getSportActiveDay();
            }

        }

        payment = payment * (insurance.getPerson().ordinal() + 1);

        return payment;
    }
}
