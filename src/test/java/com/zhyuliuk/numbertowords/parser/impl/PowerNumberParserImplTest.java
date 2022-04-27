package com.zhyuliuk.numbertowords.parser.impl;

import com.zhyuliuk.numbertowords.parser.PowerNumberParser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class PowerNumberParserImplTest {
    private static PowerNumberParser parser;

    @BeforeAll
    static void init() {
        parser = PowerNumberParserImpl.getInstance();
    }


    @Test
    void shouldConvertFromBigIntegerToRussianStringTest() {
        List<String> list = new ArrayList<>();
        list.add("тысяча тысячи тысяч");
        list.add("миллион миллиона миллионов");
        String[][] expectedResult = {{"тысяча", "тысячи", "тысяч"},
                {"миллион", "миллиона", "миллионов"}};
        String[][] actualResult = parser.parsePowerNumbers(list);
        Assertions.assertEquals(Arrays.deepToString(actualResult), Arrays.deepToString(expectedResult));
    }
}
