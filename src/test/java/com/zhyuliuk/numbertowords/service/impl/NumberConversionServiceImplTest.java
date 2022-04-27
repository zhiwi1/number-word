package com.zhyuliuk.numbertowords.service.impl;

import com.zhyuliuk.numbertowords.service.NumberConversionService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;

class NumberConversionServiceImplTest {

    private static NumberConversionService service;


    @BeforeAll
    static void init() {
        service = NumberConversionServiceImpl.getInstance();
    }

    static Object[][] createNumberAndExpectedValue() {
         return new Object[][]{
                 {"0", "ноль"},
                 {"6", "шесть"},
                 {"12", "двенадцать"},
                 {"217", "двести семнадцать"},
                 {"662", "шестьсот шестьдесят два"},
                 {"1001", "одна тысяча один"},
                 {"66300", "шестьдесят шесть тысяч триста"},
                 {"3165334", "три миллиона сто шестьдесят пять тысяч триста тридцать четыре"},
                 {"42931248", "сорок два миллиона девятьсот тридцать одна тысяча двести сорок восемь"},
                 {"7664000500", "семь миллиардов шестьсот шестьдесят четыре миллиона пятьсот"},
                 {"429786218412", "четыреста двадцать девять миллиардов семьсот восемьдесят шесть миллионов двести восемнадцать тысяч четыреста двенадцать"}
         };
     }


    @ParameterizedTest
    @MethodSource("createNumberAndExpectedValue")
    void shouldConvertFromBigIntegerToRussianStringTest(String number, String expectedResult) {
        var bigInteger = new BigInteger(number);
        String actualResult = service.convert(bigInteger);
        Assertions.assertEquals(actualResult, expectedResult);
    }


}
