package com.zhyuliuk.numbertowords.service;

import java.math.BigInteger;

@FunctionalInterface
public interface NumberConversionService {
    /**
     * Convert digital representation of number in verbal form
     *
     * @param number any number of BigIntegerType
     * @return String in verbal form
     */
    String convert(BigInteger number);
}
