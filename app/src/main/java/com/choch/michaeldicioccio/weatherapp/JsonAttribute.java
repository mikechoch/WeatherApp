package com.choch.michaeldicioccio.weatherapp;

/**
 * Created by michaeldicioccio on 9/9/17.
 */

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Holds attributes that the JSON object must have
 */
public enum JsonAttribute {

    DATE("localtime"),
    CONDITION(""),
    TEMPERATURE(""),
    WIND(""),
    HUMIDITY("");

    private final String attribute;

    public String getAttribute() {
        return attribute;
    }

    JsonAttribute(String attribute) {
        this.attribute = attribute;
    }

    /**
     * This is a list of JsonAttributes that the Json Object MUST have
     */
    public static ArrayList<String> getMustHaveAttributes() {
        return new ArrayList<>(Arrays.asList(
                DATE.getAttribute(),
                CONDITION.getAttribute(),
                TEMPERATURE.getAttribute(),
                WIND.getAttribute(),
                HUMIDITY.getAttribute()
        ));
    }
}
