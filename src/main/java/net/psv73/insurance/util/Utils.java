package net.psv73.insurance.util;

import net.psv73.insurance.model.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Utils {

    public static Map<String, Object> editData(Optional<Insurance> insurance) {

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

            payment = payment * (insurance.getPerson().ordinal() + 1);

        } else {

        }
        return payment;
    }
}
