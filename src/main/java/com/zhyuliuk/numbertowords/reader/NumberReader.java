package com.zhyuliuk.numbertowords.reader;

import java.util.List;

@FunctionalInterface
public interface NumberReader {
    /**
     * Read from relative path values of powers
     *
     * @param relativePath relative path to file for reading powers
     * @return List<String>
     */
    List<String> readPowerNumbers(String relativePath);
}
