package com.example.demo.service;

import com.example.demo.def.NumberOperator;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldNotCalculateWhenIncorrectArguments() {
        //given
        Calculator<Integer> calculator = new Calculator<>();
        int a = 12345;
        int b = 0;

        //when && then
        //exception
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(a, b, null));
    }

    @Test
    void shouldCalculateAddInteger() {
        //given
        Calculator<Integer> calculator = new Calculator<>();
        int a = 12345;
        int b = 4567;

        //when
        Integer ret = calculator.calculate(a, b, NumberOperator.ADD);

        //then
        assertNotNull(ret);
        assertEquals(a + b, ret);
    }

    @Test
    void shouldCalculateAddDouble() {
        //given
        Calculator<Double> calculator = new Calculator<>();
        double a = 123.0;
        double b = 345.0;

        //when
        Double ret = calculator.calculate(a, b, NumberOperator.ADD);

        //then
        assertNotNull(ret);
        assertEquals(a + b, ret);
    }

    @Test
    void shouldCalculateAddLong() {
        //given
        Calculator<Long> calculator = new Calculator<>();
        long a = 123L;
        long b = 345L;

        //when
        Long ret = calculator.calculate(a, b, NumberOperator.ADD);

        //then
        assertNotNull(ret);
        assertEquals(a + b, ret);
    }

    @Test
    void shouldCalculateAddFloat() {
        //given
        Calculator<Float> calculator = new Calculator<>();
        float a = 123.0F;
        float b = 345.0F;

        //when
        Float ret = calculator.calculate(a, b, NumberOperator.ADD);

        //then
        assertNotNull(ret);
        assertEquals(a + b, ret);
    }

    @Test
    void shouldCalculateAddBigDecimal() {
        //given
        Calculator<BigDecimal> calculator = new Calculator<>();
        BigDecimal a = BigDecimal.valueOf(123);
        BigDecimal b = BigDecimal.valueOf(345);

        //when
        BigDecimal ret = calculator.calculate(a, b, NumberOperator.ADD);

        //then
        assertNotNull(ret);
        assertThat(a.add(b), Matchers.comparesEqualTo(ret));
    }

    @Test
    void shouldNotCalculateAddWhenUnknownType() {
        //given
        Calculator<Integer> calculator = new Calculator<>();
        byte a = 1;
        byte b = 2;

        //when & then
        //exception
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(a, b, NumberOperator.SUBTRACT));
    }

    @Test
    void shouldCalculateSubtractInteger() {
        //given
        Calculator<Integer> calculator = new Calculator<>();
        int a = 12345;
        int b = 4567;

        //when
        Integer ret = calculator.calculate(a, b, NumberOperator.SUBTRACT);

        //then
        assertNotNull(ret);
        assertEquals(a - b, ret);
    }

    @Test
    void shouldCalculateSubtractDouble() {
        //given
        Calculator<Double> calculator = new Calculator<>();
        double a = 123.0;
        double b = 345.0;

        //when
        Double ret = calculator.calculate(a, b, NumberOperator.SUBTRACT);

        //then
        assertNotNull(ret);
        assertEquals(a - b, ret);
    }

    @Test
    void shouldCalculateSubtractLong() {
        //given
        Calculator<Long> calculator = new Calculator<>();
        long a = 123L;
        long b = 345L;

        //when
        Long ret = calculator.calculate(a, b, NumberOperator.SUBTRACT);

        //then
        assertNotNull(ret);
        assertEquals(a - b, ret);
    }

    @Test
    void shouldCalculateSubtractFloat() {
        //given
        Calculator<Float> calculator = new Calculator<>();
        float a = 123.0F;
        float b = 345.0F;

        //when
        Float ret = calculator.calculate(a, b, NumberOperator.SUBTRACT);

        //then
        assertNotNull(ret);
        assertEquals(a - b, ret);
    }

    @Test
    void shouldCalculateSubtractBigDecimal() {
        //given
        Calculator<BigDecimal> calculator = new Calculator<>();
        BigDecimal a = BigDecimal.valueOf(123);
        BigDecimal b = BigDecimal.valueOf(345);

        //when
        BigDecimal ret = calculator.calculate(a, b, NumberOperator.SUBTRACT);

        //then
        assertNotNull(ret);
        assertThat(a.subtract(b), Matchers.comparesEqualTo(ret));
    }

    @Test
    void shouldNotCalculateSubtractWhenUnknownType() {
        //given
        Calculator<Integer> calculator = new Calculator<>();
        byte a = 1;
        byte b = 2;

        //when & then
        //exception
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(a, b, NumberOperator.SUBTRACT));
    }

    @Test
    void shouldCalculateMultiplyInteger() {
        //given
        Calculator<Integer> calculator = new Calculator<>();
        int a = 12345;
        int b = 4567;

        //when
        Integer ret = calculator.calculate(a, b, NumberOperator.MULTIPLY);

        //then
        assertNotNull(ret);
        assertEquals(a * b, ret);
    }

    @Test
    void shouldCalculateMultiplyDouble() {
        //given
        Calculator<Double> calculator = new Calculator<>();
        double a = 123.0;
        double b = 345.0;

        //when
        Double ret = calculator.calculate(a, b, NumberOperator.MULTIPLY);

        //then
        assertNotNull(ret);
        assertEquals(a * b, ret);
    }

    @Test
    void shouldCalculateMultiplyLong() {
        //given
        Calculator<Long> calculator = new Calculator<>();
        long a = 123L;
        long b = 345L;

        //when
        Long ret = calculator.calculate(a, b, NumberOperator.MULTIPLY);

        //then
        assertNotNull(ret);
        assertEquals(a * b, ret);
    }

    @Test
    void shouldCalculateMultiplyFloat() {
        //given
        Calculator<Float> calculator = new Calculator<>();
        float a = 123.0F;
        float b = 345.0F;

        //when
        Float ret = calculator.calculate(a, b, NumberOperator.MULTIPLY);

        //then
        assertNotNull(ret);
        assertEquals(a * b, ret);
    }

    @Test
    void shouldCalculateMultiplyBigDecimal() {
        //given
        Calculator<BigDecimal> calculator = new Calculator<>();
        BigDecimal a = BigDecimal.valueOf(123);
        BigDecimal b = BigDecimal.valueOf(345);

        //when
        BigDecimal ret = calculator.calculate(a, b, NumberOperator.MULTIPLY);

        //then
        assertNotNull(ret);
        assertThat(a.multiply(b), Matchers.comparesEqualTo(ret));
    }

    @Test
    void shouldNotCalculateMultiplyWhenUnknownType() {
        //given
        Calculator<Integer> calculator = new Calculator<>();
        byte a = 1;
        byte b = 2;

        //when & then
        //exception
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(a, b, NumberOperator.MULTIPLY));
    }

    @Test
    void shouldCalculateDivideInteger() {
        //given
        Calculator<Integer> calculator = new Calculator<>();
        int a = 12345;
        int b = 4567;

        //when
        Integer ret = calculator.calculate(a, b, NumberOperator.DIVIDE);

        //then
        assertNotNull(ret);
        assertEquals(a / b, ret);
    }

    @Test
    void shouldCalculateDivideDouble() {
        //given
        Calculator<Double> calculator = new Calculator<>();
        double a = 123.0;
        double b = 345.0;

        //when
        Double ret = calculator.calculate(a, b, NumberOperator.DIVIDE);

        //then
        assertNotNull(ret);
        assertEquals(a / b, ret);
    }

    @Test
    void shouldCalculateDivideLong() {
        //given
        Calculator<Long> calculator = new Calculator<>();
        long a = 123L;
        long b = 345L;

        //when
        Long ret = calculator.calculate(a, b, NumberOperator.DIVIDE);

        //then
        assertNotNull(ret);
        assertEquals(a / b, ret);
    }

    @Test
    void shouldCalculateDivideFloat() {
        //given
        Calculator<Float> calculator = new Calculator<>();
        float a = 123.0F;
        float b = 345.0F;

        //when
        Float ret = calculator.calculate(a, b, NumberOperator.DIVIDE);

        //then
        assertNotNull(ret);
        assertEquals(a / b, ret);
    }

    @Test
    void shouldCalculateDivideBigDecimal() {
        //given
        Calculator<BigDecimal> calculator = new Calculator<>();
        BigDecimal a = BigDecimal.valueOf(123);
        BigDecimal b = BigDecimal.valueOf(345);

        //when
        BigDecimal ret = calculator.calculate(a, b, NumberOperator.DIVIDE);

        //then
        assertNotNull(ret);
        assertThat(a.divide(b, 6, RoundingMode.HALF_UP), Matchers.comparesEqualTo(ret));
    }

    @Test
    void shouldNotCalculateDivideIntegerWhenDivideByZero() {
        //given
        Calculator<Integer> calculator = new Calculator<>();
        int a = 12345;
        int b = 0;

        //when && then
        //exception
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(a, b, NumberOperator.DIVIDE));
    }

    @Test
    void shouldNotCalculateDivideWhenUnknownType() {
        //given
        Calculator<Integer> calculator = new Calculator<>();
        byte a = 1;
        byte b = 2;

        //when & then
        //exception
        assertThrows(IllegalArgumentException.class, () -> calculator.calculate(a, b, NumberOperator.DIVIDE));
    }

}