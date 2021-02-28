package com.example.demo.service;

import com.example.demo.def.NumberOperator;
import com.example.demo.def.Operator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

class DataLinkServiceTest {
    private Calculator<Integer> calculator;
    private NumberInputProvider<Integer> numberInputProvider;
    private DataLinkService<Integer> dataLinkService;

    @BeforeEach
    void setup() {
        calculator = mock(Calculator.class);
        numberInputProvider = mock(NumberInputProvider.class);
        dataLinkService = new DataLinkService(numberInputProvider, calculator);
    }

    @Test
    void shouldRequestFirstInputValue() {
        //when
        dataLinkService.getFirstInputValue(Integer.class);

        //then
        verify(numberInputProvider).getFirstInputNumber(Integer.class);
    }

    @Test
    void shouldRequestSecondInputValue() {
        //when
        dataLinkService.getSecondInputValue(Integer.class);

        //then
        verify(numberInputProvider).getSecondInputNumber(Integer.class);
    }

    @Test
    void shouldRequestNumberCalculation() {
        //given
        int a = 1;
        int b = 2;

        when(calculator.calculate(a, b, NumberOperator.ADD)).thenReturn(a + b);

        //when
        Integer ret = dataLinkService.link(a, b, NumberOperator.ADD);

        //then
        assertEquals(a + b, ret);
        verify(calculator).calculate(a, b, NumberOperator.ADD);
    }

    @Test
    void shouldNotPerformLinkOperationWhenUnknownOperation() {
        //given
        int a = 1;
        int b = 2;
        Operator operator = mock(Operator.class);

        //when && then
        //exception
        assertThrows(IllegalArgumentException.class, () -> dataLinkService.link(a, b, operator));
    }
}