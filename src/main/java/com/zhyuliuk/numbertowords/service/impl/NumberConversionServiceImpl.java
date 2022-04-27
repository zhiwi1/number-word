package com.zhyuliuk.numbertowords.service.impl;

import com.zhyuliuk.numbertowords.parser.PowerNumberParser;
import com.zhyuliuk.numbertowords.parser.impl.PowerNumberParserImpl;
import com.zhyuliuk.numbertowords.reader.NumberReader;
import com.zhyuliuk.numbertowords.reader.impl.NumberReaderImpl;
import com.zhyuliuk.numbertowords.service.NumberConversionService;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

import static com.zhyuliuk.numbertowords.util.NumberConversionConstants.*;

public class NumberConversionServiceImpl implements NumberConversionService {
    private static NumberConversionServiceImpl instance;

    private NumberConversionServiceImpl() {
    }

    public static NumberConversionServiceImpl getInstance() {
        if (instance == null) {
            instance = new NumberConversionServiceImpl();
        }
        return instance;
    }


    @Override
    public String convert(BigInteger number) {
        if (Objects.equals(number, BigInteger.ZERO)) {
            return ZERO;
        }
        var result = new StringBuilder();
        if (number.compareTo(BigInteger.ZERO) < 0) {
            result.append(MINUS);
            number = number.abs();
        }

        var triplets = Arrays.asList(String.format(THOUSAND_FORMAT_STRING, number).split(COMMA));
        var size = new AtomicInteger(triplets.size());
        triplets.forEach(trio -> result.append(calcVerbalFrom(Integer.parseInt(trio), size.decrementAndGet())));
        return result.toString().trim();
    }

    /**
     * Counts the verbal representation of a number with a degree in the correct case.
     * Example: calcVerbalFrom(22, 1) for the nominative case will return "twenty-two thousand".
     *
     * @param triada a number between 0 and 999.
     * @param power  power (1 - thousands, 2 - millions ...).
     * @return is the verbal form of a number with a degree.
     */
    private String calcVerbalFrom(int triada, int power) {
        var thousands = 1;
        var result = new StringBuilder();

        var ones = triada % 10;
        var decades = triada / 10 % 10;
        var hundreds = triada / 100 % 10;

        var key = triada;
        var digit = DIGIT_NOMINATIVE;
        if (triada > 0) {
            if (hundreds > 0) {
                result.append(digit[hundreds][HUNDREDS_INDEX]);
                key %= 100;
            }
            if (decades > 1) {
                result.append(digit[decades][DECADES_INDEX]);
                key %= 10;
            }
            if (decades == 1) {
                result.append(digit[ones][FROM_11_TO_20_INDEX]);
            } else {
                result.append(digit[ones][power == thousands ? FOR_THOUSANDS_INDEX : FOR_OTHERS_INDEX]);
            }

            result.append(calcPower(key, power - 1)).append(SPACE);
        }
        return result.toString();
    }

    /**
     * Calculates the correct case.
     *
     * @param key    key for dictionary lookup (1-19).
     * @param degree degree (1 - thousands, 2 - millions ...).
     * @return exponent in verbal form.
     */
    private String calcPower(int key, int degree) {
        if (degree < 0) {
            return EMPTY_SPACE;
        }
        NumberReader numberReader = NumberReaderImpl.getInstance();
        PowerNumberParser numberParser = PowerNumberParserImpl.getInstance();
        List<String> powerNumbers = numberReader.readPowerNumbers(RELATIVE_PATH_TO_POWERS);
        var power = numberParser.parsePowerNumbers(powerNumbers);

        switch (key) {
            case 1:
                return power[degree][SINGULAR_INDEX];
            case 2:
            case 3:
            case 4:
                return power[degree][FROM_2_TO_4_INDEX];
            default:
                return power[degree][OTHERS_INDEX];
        }
    }

}
