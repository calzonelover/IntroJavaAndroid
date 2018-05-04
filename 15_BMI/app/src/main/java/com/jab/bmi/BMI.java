package com.jab.bmi;

/**
 * Created by jab on 4/5/2018 AD.
 */

public class BMI {
    public static final float minBMIValue = 18;
    public static final float maxBMIValue = 25;

    public static String getValueString(float height, float weight){
        height = height/100;
        String valueBMI = Float.toString(weight / (height * height));
        return valueBMI;
    }

    public static float getValueFloat(float height, float weight){
        height = height/100;
        return weight / (height * height);
    }
}
