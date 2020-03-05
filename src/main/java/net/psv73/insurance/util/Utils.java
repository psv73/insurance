package net.psv73.insurance.util;

import net.psv73.insurance.model.Insurance;
import net.psv73.insurance.model.Person;
import net.psv73.insurance.model.Plan;
import net.psv73.insurance.model.Type;

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

    public static Insurance calculatePayment(Insurance insurance) {

        return insurance;
    }
}
