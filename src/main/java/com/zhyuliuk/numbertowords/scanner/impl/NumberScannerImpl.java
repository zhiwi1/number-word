package com.zhyuliuk.numbertowords.scanner.impl;

import com.zhyuliuk.numbertowords.scanner.NumberScanner;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;
import java.util.Scanner;

public class NumberScannerImpl implements NumberScanner {
    private static final Logger logger = LogManager.getLogger();
    private static NumberScannerImpl instance;

    private NumberScannerImpl() {
    }

    public static NumberScannerImpl getInstance() {
        if (instance == null) {
            instance = new NumberScannerImpl();
        }
        return instance;
    }

    public BigInteger scanNumber() {
        var scanner = new Scanner(System.in);
        while (!scanner.hasNextBigInteger()) {
            String readValue = scanner.next();
            logger.warn("Incorrect number: {}", readValue);
        }
        return scanner.nextBigInteger();
    }
}
