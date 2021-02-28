package com.example.demo.service;

import com.example.demo.dao.IDataNumberDao;
import com.example.demo.jpa.DataNumber;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

@Component
public class NumberInputProvider<T> {
    private static final Logger log = LoggerFactory.getLogger(NumberInputProvider.class.getSimpleName());

    private final IDataNumberDao dataNumberDao;

    @Autowired
    public NumberInputProvider(IDataNumberDao dataNumberDao) {
        this.dataNumberDao = dataNumberDao;
    }

    T getFirstInputNumber(Class<T> clazz) {
        log.debug("Generating first number of type: {}", clazz.getSimpleName());

        Random random = new Random();
        Number ret;

        if (Integer.class.equals(clazz)) {
            ret = random.nextInt();
        } else if (Double.class.equals(clazz)) {
            ret = random.nextDouble();
        } else if (Float.class.equals(clazz)) {
            ret = random.nextFloat();
        } else if (Long.class.equals(clazz)) {
            ret = random.nextLong();
        } else if (BigDecimal.class.equals(clazz)) {
            ret = BigDecimal.valueOf(random.nextLong());
        } else {
            throw new IllegalArgumentException("Unhandled number type: " + clazz.getSimpleName());
        }

        return (T) ret;
    }

    T getSecondInputNumber(Class<T> clazz) {
        log.debug("Generating second number of type: {}", clazz.getSimpleName());

        Number ret;

        List<DataNumber> numbers = dataNumberDao.findAll();

        if (numbers.isEmpty()) {
            throw new IllegalArgumentException("No data for second input number");
        }

        if (Integer.class.equals(clazz)) {
            ret = numbers.get(0).getIntegerValue();
        } else if (Double.class.equals(clazz)) {
            ret = numbers.get(0).getDoubleValue();
        } else if (Float.class.equals(clazz)) {
            ret = numbers.get(0).getFloatValue();
        } else if (Long.class.equals(clazz)) {
            ret = numbers.get(0).getLongValue();
        } else if (BigDecimal.class.equals(clazz)) {
            ret = numbers.get(0).getBigDecimalValue();
        } else {
            throw new IllegalArgumentException("Unhandled number type: " + clazz.getSimpleName());
        }

        if (ret == null) {
            throw new IllegalArgumentException("Failed attempt to extract second input number");
        }

        return (T) ret;
    }
}

