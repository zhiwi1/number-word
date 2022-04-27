package com.zhyuliuk.numbertowords.reader.impl;

import com.zhyuliuk.numbertowords.reader.NumberReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberReaderImpl implements NumberReader {
    private static final Logger logger = LogManager.getLogger();
    private static NumberReaderImpl instance;

    private NumberReaderImpl() {
    }

    public static NumberReaderImpl getInstance() {
        if (instance == null) {
            instance = new NumberReaderImpl();
        }
        return instance;
    }

    public List<String> readPowerNumbers(String relativePath) {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = Files.newBufferedReader(Paths.get(relativePath))) {
            list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            logger.error("Cant find file: {}", relativePath);
        }
        return list;
    }

}
