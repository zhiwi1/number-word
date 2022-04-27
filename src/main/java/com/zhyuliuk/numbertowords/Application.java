package com.zhyuliuk.numbertowords;

import com.zhyuliuk.numbertowords.scanner.NumberScanner;
import com.zhyuliuk.numbertowords.scanner.impl.NumberScannerImpl;
import com.zhyuliuk.numbertowords.service.NumberConversionService;
import com.zhyuliuk.numbertowords.service.impl.NumberConversionServiceImpl;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigInteger;


public class Application {
    private static final Logger logger = LogManager.getLogger();

    public static void main(String[] args) {
        try {
            NumberScanner scanner = NumberScannerImpl.getInstance();
            NumberConversionService service = NumberConversionServiceImpl.getInstance();
            System.out.println("Введите число: ");
            BigInteger number = scanner.scanNumber();
            System.out.println(service.convert(number));
        } catch (ArrayIndexOutOfBoundsException e) {
            logger.error("Значение которые вы ввели слишком большое, обновите powerNumbers.txt");
        }

    }
}
