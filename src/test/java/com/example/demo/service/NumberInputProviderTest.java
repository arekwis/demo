package com.example.demo.service;

import com.example.demo.dao.IDataNumberDao;
import com.example.demo.jpa.DataNumber;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class NumberInputProviderTest {
    private static final Integer INT_VALUE = 1;
    private static final Double DOUBLE_VALUE = 2.0;
    private static final Float FLOAT_VALUE = 3.0F;
    private static final Long LONG_VALUE = 1L;
    private static final BigDecimal BIG_DECIMAL_VALUE = BigDecimal.valueOf(5);

    private IDataNumberDao numberDao = mock(IDataNumberDao.class);

    @BeforeEach
    public void setup() {
        DataNumber dataNumber = new DataNumber();
        dataNumber.setIntegerValue(INT_VALUE);
        dataNumber.setDoubleValue(DOUBLE_VALUE);
        dataNumber.setFloatValue(FLOAT_VALUE);
        dataNumber.setLongValue(LONG_VALUE);
        dataNumber.setBigDecimalValue(BIG_DECIMAL_VALUE);

        when(numberDao.findAll()).thenReturn(Collections.singletonList(dataNumber));
    }

    @Test
    void shouldGenerateInteger() {
        //given
        NumberInputProvider<Integer> numberInputProvider = new NumberInputProvider<>(numberDao);

        //when
        Integer ret = numberInputProvider.getFirstInputNumber(Integer.class);

        //then
        assertNotNull(ret);
    }

    @Test
    void shouldGenerateDouble() {
        //given
        NumberInputProvider<Double> numberInputProvider = new NumberInputProvider<>(numberDao);

        //when
        Double ret = numberInputProvider.getFirstInputNumber(Double.class);

        //then
        assertNotNull(ret);
    }

    @Test
    void shouldGenerateFloat() {
        //given
        NumberInputProvider<Float> numberInputProvider = new NumberInputProvider<>(numberDao);

        //when
        Float ret = numberInputProvider.getFirstInputNumber(Float.class);

        //then
        assertNotNull(ret);
    }

    @Test
    void shouldGenerateLong() {
        //given
        NumberInputProvider<Long> numberInputProvider = new NumberInputProvider<>(numberDao);

        //when
        Long ret = numberInputProvider.getFirstInputNumber(Long.class);

        //then
        assertNotNull(ret);
    }

    @Test
    void shouldGenerateBigDecimal() {
        //given
        NumberInputProvider<BigDecimal> numberInputProvider = new NumberInputProvider<>(numberDao);

        //when
        BigDecimal ret = numberInputProvider.getFirstInputNumber(BigDecimal.class);

        //then
        assertNotNull(ret);
    }

    @Test
    void shouldNotGenerateNumberWhenUnhandledType() {
        //given
        NumberInputProvider<String> numberInputProvider = new NumberInputProvider<>(numberDao);

        //when && then
        //exception
        assertThrows(IllegalArgumentException.class, () -> numberInputProvider.getFirstInputNumber(String.class));
    }

    @Test
    void shouldExtractInteger() {
        //given
        NumberInputProvider<Integer> numberInputProvider = new NumberInputProvider<>(numberDao);

        //when
        Integer ret = numberInputProvider.getSecondInputNumber(Integer.class);

        //then
        assertNotNull(ret);
        assertEquals(INT_VALUE, ret);
    }

    @Test
    void shouldExtractDouble() {
        //given
        NumberInputProvider<Double> numberInputProvider = new NumberInputProvider<>(numberDao);

        //when
        Double ret = numberInputProvider.getSecondInputNumber(Double.class);

        //then
        assertNotNull(ret);
        assertEquals(DOUBLE_VALUE, ret, 0.0);
    }

    @Test
    void shouldExtractFloat() {
        //given
        NumberInputProvider<Float> numberInputProvider = new NumberInputProvider<>(numberDao);

        //when
        Float ret = numberInputProvider.getSecondInputNumber(Float.class);

        //then
        assertNotNull(ret);
        assertEquals(FLOAT_VALUE, ret, 0.0);
    }

    @Test
    void shouldExtractLong() {
        //given
        NumberInputProvider<Long> numberInputProvider = new NumberInputProvider<>(numberDao);

        //when
        Long ret = numberInputProvider.getSecondInputNumber(Long.class);

        //then
        assertNotNull(ret);
        assertEquals(LONG_VALUE, ret);
    }

    @Test
    void shouldExtractBigDecimal() {
        //given
        NumberInputProvider<BigDecimal> numberInputProvider = new NumberInputProvider<>(numberDao);

        //when
        BigDecimal ret = numberInputProvider.getSecondInputNumber(BigDecimal.class);

        //then
        assertNotNull(ret);
        assertThat(BIG_DECIMAL_VALUE.compareTo(ret));
    }

    @Test
    void shouldNotExtractNumberWhenUnhandledType() {
        //given
        NumberInputProvider<String> numberInputProvider = new NumberInputProvider<>(numberDao);

        //when && then
        //exception
        assertThrows(IllegalArgumentException.class, () -> numberInputProvider.getFirstInputNumber(String.class));
    }

}