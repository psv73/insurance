package net.psv73.insurance.util;

import net.psv73.insurance.model.*;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class Utils {

    public static float getProperty(String key) {

        float property;
        FileReader fileReader = null;
        File file = new File("src/main/resources/config.properties");

        Properties properties = new Properties();

        try {
            fileReader = new FileReader(file);
            properties.load(fileReader);

        } catch(IOException io) {
            io.printStackTrace();
        } finally {
            if (fileReader != null) {

            }
        }

        property = Float.parseFloat(properties.getProperty(key));

        return property;
    }

    public static Map<String, Object> editData(Insurance insurance) {

        Map<String, Object> data = new HashMap<>();

        data.put("insurance", insurance);

        data.put("type", Type.values());

        data.put("plan", Plan.values());

        data.put("person", Person.values());

        return data;
    }

    public static Insurance calculateInsurance(Insurance insurance) {

        return insurance;
    }
}
