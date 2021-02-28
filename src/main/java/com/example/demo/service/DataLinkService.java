package com.example.demo.service;

import com.example.demo.def.NumberOperator;
import com.example.demo.def.Operator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DataLinkService<T> {
    private final NumberInputProvider<T> numberInputProvider;
    private final Calculator<T> calculator;

    @Autowired
    public DataLinkService(NumberInputProvider<T> numberInputProvider,
                           Calculator<T> calculator) {
        this.numberInputProvider = numberInputProvider;
        this.calculator = calculator;
    }

    public T getFirstInputValue(Class<T> clazz) {
        return numberInputProvider.getFirstInputNumber(clazz);
    }

    public T getSecondInputValue(Class<T> clazz) {
        return numberInputProvider.getSecondInputNumber(clazz);
    }

    public T link(T valueA, T valueB, Operator operator) {
        if (valueA instanceof Number && valueB instanceof Number && operator instanceof NumberOperator) {
            return calculator.calculate((Number) valueA, (Number) valueB, (NumberOperator) operator);
        } else {
            throw new IllegalArgumentException("Unhandled operation: " + valueA.getClass().getSimpleName()
                    + " " + operator.toString() + " " + valueB.getClass().getSimpleName());
        }
    }
}
