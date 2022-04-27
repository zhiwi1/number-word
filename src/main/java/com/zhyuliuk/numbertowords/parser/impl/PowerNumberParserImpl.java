package com.zhyuliuk.numbertowords.parser.impl;

import com.zhyuliuk.numbertowords.parser.PowerNumberParser;


import java.util.List;

public class PowerNumberParserImpl implements PowerNumberParser {
    private static final String WHITE_SPACE = " ";
    private static final int COUNT_OF_COLUMNS = 3;
    private static PowerNumberParserImpl instance;


    private PowerNumberParserImpl() {
    }

    public static PowerNumberParserImpl getInstance() {
        if (instance == null) {
            instance = new PowerNumberParserImpl();
        }
        return instance;
    }

    public String[][] parsePowerNumbers(List<String> powerNumbers) {
        return powerNumbers.stream()
                .map(line -> (line.split(WHITE_SPACE)))
                .toArray(size -> new String[size][COUNT_OF_COLUMNS]);
    }

}
