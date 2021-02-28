package com.example.demo.service;

import com.example.demo.def.NumberOperator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.math.RoundingMode;

@Component
public class Calculator<T> {
    private static final Logger log = LoggerFactory.getLogger(Calculator.class.getSimpleName());

    public T calculate(Number a, Number b, NumberOperator numberOperator) {
        if (a == null || b == null || numberOperator == null) {
            throw new IllegalArgumentException("Cannot calculate operation: " + a + " " + numberOperator + " " + b);
        }

        log.info("Calculating: {} {} {}", a, numberOperator, b);

        switch (numberOperator) {
            case ADD:
                return getAddResult(a, b);
            case SUBTRACT:
                return getSubtractResult(a, b);
            case MULTIPLY:
                return getMultiplyResult(a, b);
            case DIVIDE:
                return getDivideResult(a, b);
            default:
                throw new IllegalArgumentException("Cannot calculate. Unhandled number operator: " + numberOperator);
        }
    }

    private T getAddResult(Number a, Number b) {
        log.debug("Operation add: {} + {}", a, b);
        Number result;

        if (a instanceof Integer && b instanceof Integer) {
            result = (int) a + (int) b;
        } else if (a instanceof Double && b instanceof Double) {
            result = (double) a + (double) b;
        } else if (a instanceof Float && b instanceof Float) {
            result = (float) a + (float) b;
        } else if (a instanceof Long && b instanceof Long) {
            result = (long) a + (long) b;
        } else if (a instanceof BigDecimal && b instanceof BigDecimal) {
            result = ((BigDecimal) a).add((BigDecimal) b);
        } else {
            throw new IllegalArgumentException("Unhandled number type for add operation: "
                    + a.getClass().getSimpleName() + " | " + b.getClass().getSimpleName());
        }

        log.debug("Operation add - result: {}", result);

        return (T) result;
    }

    private T getSubtractResult(Number a, Number b) {
        log.debug("Operation subtract: {} + {}", a, b);
        Number result;

        if (a instanceof Integer && b instanceof Integer) {
            result = (int) a - (int) b;
        } else if (a instanceof Double && b instanceof Double) {
            result = (double) a - (double) b;
        } else if (a instanceof Float && b instanceof Float) {
            result = (float) a - (float) b;
        } else if (a instanceof Long && b instanceof Long) {
            result = (long) a - (long) b;
        } else if (a instanceof BigDecimal && b instanceof BigDecimal) {
            result = ((BigDecimal) a).subtract((BigDecimal) b);
        } else {
            throw new IllegalArgumentException("Unhandled number type for subtract operation: "
                    + a.getClass().getSimpleName() + " | " + b.getClass().getSimpleName());
        }

        log.debug("Operation subtract - result: {}", result);

        return (T) result;
    }

    private T getMultiplyResult(Number a, Number b) {
        log.debug("Operation multiply: {} + {}", a, b);
        Number result;

        if (a instanceof Integer && b instanceof Integer) {
            result = (int) a * (int) b;
        } else if (a instanceof Double && b instanceof Double) {
            result = (double) a * (double) b;
        } else if (a instanceof Float && b instanceof Float) {
            result = (float) a * (float) b;
        } else if (a instanceof Long && b instanceof Long) {
            result = (long) a * (long) b;
        } else if (a instanceof BigDecimal && b instanceof BigDecimal) {
            result = ((BigDecimal) a).multiply((BigDecimal) b);
        } else {
            throw new IllegalArgumentException("Unhandled number type for multiply operation: "
                    + a.getClass().getSimpleName() + " | " + b.getClass().getSimpleName());
        }

        log.debug("Operation multiply - result: {}", result);

        return (T) result;
    }

    private T getDivideResult(Number a, Number b) {
        if (b.doubleValue() == 0.0) {
            throw new IllegalArgumentException("Divide by 0");
        }

        log.debug("Operation divide: {} + {}", a, b);
        Number result;

        if (a instanceof Integer && b instanceof Integer) {
            result = (int) a / (int) b;
        } else if (a instanceof Double && b instanceof Double) {
            result = (double) a / (double) b;
        } else if (a instanceof Float && b instanceof Float) {
            result = (float) a / (float) b;
        } else if (a instanceof Long && b instanceof Long) {
            result = (long) a / (long) b;
        } else if (a instanceof BigDecimal && b instanceof BigDecimal) {
            result = ((BigDecimal) a).divide((BigDecimal) b, 6, RoundingMode.HALF_UP);
        } else {
            throw new IllegalArgumentException("Unhandled number type for multiply operation: "
                    + a.getClass().getSimpleName() + " | " + b.getClass().getSimpleName());
        }

        log.debug("Operation multiply - result: {}", result);

        return (T) result;
    }
}
