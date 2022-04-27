package com.zhyuliuk.numbertowords.scanner;

import java.math.BigInteger;

@FunctionalInterface
public interface NumberScanner {
    /**
     * Scan from console in infinite loop BigInteger value
     *
     * @return BigInteger
     */
    BigInteger scanNumber();
}
