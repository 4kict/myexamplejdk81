package com.my.test.controllers;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

/**
 * Created by SBT-Kiladze-GS on 01.12.2017.
 */
public class MyTests {

    /**
     * Perfomance
     */
    public static int sumOfThousands(int num) {
//        int sum = 0;
//        int i = 0;
//        while (i <= num / 1000) {
//            sum += i * 1000;
//            i++;
//        }
//        return sum;
//        return (int)((num / 1000 / 2.0) * (1000.0 + num));
        int tmp = num / 1000;
        return (int) ((tmp / 2.0) * (1 + tmp)) * 1000;
    }

    @Test
    public void doTest() {
        System.out.println(sumOfThousands(8000));
    }

    /**
     * Resistor
     */
    static Map<Character, String> colorMap = new HashMap<>();
    {
        colorMap.put('0', "black");
        colorMap.put('1', "brown");
        colorMap.put('2', "red");
        colorMap.put('3', "orange");
        colorMap.put('4', "yellow");
        colorMap.put('5', "green");
        colorMap.put('6', "blue");
        colorMap.put('7', "violet");
        colorMap.put('8', "gray");
        colorMap.put('9', "white");
    }

    public static String encodeResistorColors(String ohmsString) {
        int indx = ohmsString.indexOf(" ohms");
        if (indx == -1) {
            return "";
        }
        String resistVal = ohmsString.substring(0, indx);
        char lastChar = resistVal.charAt(resistVal.length() - 1);
        Integer ohms;
        if (Character.isDigit(lastChar)) {
            ohms = Integer.parseInt(resistVal);
        } else if (lastChar == 'k') {
            ohms = (int) (Double.parseDouble(resistVal.substring(0, resistVal.length() - 1)) * 1000);
        } else if (lastChar == 'M') {
            ohms = (int) (Double.parseDouble(resistVal.substring(0, resistVal.length() - 1)) * 1000000);
        } else {
            return "";
        }
        if (ohms < 10) {
            return "";
        }
        String ohmsStr = ohms.toString();
        String result = (colorMap.get(ohmsStr.charAt(0)) + " ") +
                colorMap.get(ohmsStr.charAt(1)) + " " +
                colorMap.get(((Integer) (ohmsStr.length() - 2)).toString().charAt(0)) + " " +
                "gold";

        return result;
    }


    @Test
    public void SomeCommonResistorValuesTests() {
        assertEquals("brown black black gold", encodeResistorColors("10 ohms"));
        assertEquals("yellow violet black gold", encodeResistorColors("47 ohms"));
        assertEquals("brown black brown gold", encodeResistorColors("100 ohms"));
        assertEquals("red red brown gold", encodeResistorColors("220 ohms"));
        assertEquals("orange orange brown gold", encodeResistorColors("330 ohms"));
        assertEquals("yellow violet brown gold", encodeResistorColors("470 ohms"));
        assertEquals("blue gray brown gold", encodeResistorColors("680 ohms"));
        assertEquals("brown black red gold", encodeResistorColors("1k ohms"));
        assertEquals("yellow violet red gold", encodeResistorColors("4.7k ohms"));
        assertEquals("brown black orange gold", encodeResistorColors("10k ohms"));
        assertEquals("red red orange gold", encodeResistorColors("22k ohms"));
        assertEquals("yellow violet orange gold", encodeResistorColors("47k ohms"));
        assertEquals("brown black yellow gold", encodeResistorColors("100k ohms"));
        assertEquals("orange orange yellow gold", encodeResistorColors("330k ohms"));
        assertEquals("brown black green gold", encodeResistorColors("1M ohms"));
        assertEquals("red black green gold", encodeResistorColors("2M ohms"));
    }

}
