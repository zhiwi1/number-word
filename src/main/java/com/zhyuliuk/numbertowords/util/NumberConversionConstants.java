package com.zhyuliuk.numbertowords.util;


import lombok.experimental.UtilityClass;

@UtilityClass
public class NumberConversionConstants {

    public static final int SINGULAR_INDEX = 0;
    public static final int FROM_2_TO_4_INDEX = 1;
    public static final int OTHERS_INDEX = 2;

    public static final int FOR_OTHERS_INDEX = 0;
    public static final int FOR_THOUSANDS_INDEX = 1;
    public static final int FROM_11_TO_20_INDEX = 2;
    public static final int DECADES_INDEX = 3;
    public static final int HUNDREDS_INDEX = 4;

    public static final String ZERO = "ноль";
    public static final String MINUS = "минус ";
    public static final String EMPTY_SPACE = "";
    public static final String RELATIVE_PATH_TO_POWERS = "src/main/resources/powerNumbers.txt";
    public static final String THOUSAND_FORMAT_STRING = "%,d";
    public static final String SPACE = " ";
    public static final String COMMA = ",";

    public static final String[][] DIGIT_NOMINATIVE = new String[][]{
            {"", "", "десять ", "", ""},
            {"один ", "одна ", "одиннадцать ", "десять ", "сто "},
            {"два ", "две ", "двенадцать ", "двадцать ", "двести "},
            {"три ", "три ", "тринадцать ", "тридцать ", "триста "},
            {"четыре ", "четыре ", "четырнадцать ", "сорок ", "четыреста "},
            {"пять ", "пять ", "пятнадцать ", "пятьдесят ", "пятьсот "},
            {"шесть ", "шесть ", "шестнадцать ", "шестьдесят ", "шестьсот "},
            {"семь ", "семь ", "семнадцать ", "семьдесят ", "семьсот "},
            {"восемь ", "восемь ", "восемнадцать ", "восемьдесят ", "восемьсот "},
            {"девять ", "девять ", "девятнадцать ", "девяносто ", "девятьсот "},
    };

}

