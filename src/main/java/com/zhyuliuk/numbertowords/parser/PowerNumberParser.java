package com.zhyuliuk.numbertowords.parser;

import java.util.List;

@FunctionalInterface
public interface PowerNumberParser {
    /**
     * Parse lines with powerNumbers
     *
     * @param powerNumbers list with string in format "тысяча тысячи тысяч"
     * @return String[][]
     */
    String[][] parsePowerNumbers(List<String> powerNumbers);
}
