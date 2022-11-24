package com.skypro.calculator;

import com.skypro.calculator.service.CalculatorService;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

public class CalculatorServiceTest {

    private final CalculatorService calculatorService = new CalculatorService();

    @Test
    public void plusTest(){
        Assertions.assertEquals(10,calculatorService.plus(5,5));
    }

    @ParameterizedTest
    @MethodSource("minusTest")
    public void minusTest(int num1, int num2, int result){
        Assertions.assertEquals(result,calculatorService.minus(num1,num2));
    }

    @ParameterizedTest
    @MethodSource("multiplyTest")
    public void multiply(int num1,int num2, int result){
        Assertions.assertEquals(result,calculatorService.multiply(num1,num2));
    }

    @ParameterizedTest
    @MethodSource("divideTest")
    public void divideTest(int num1, int num2, int result){
        Assertions.assertEquals(result,calculatorService.divide(num1,num2));
    }

    @Test
    public void divideByZero(){
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> calculatorService.divide(1,0));
    }

    public static List<Arguments> minusTest(){
        return List.of(
                Arguments.of(10,5,5),
                Arguments.of(-5,3,-8),
                Arguments.of(0,0,0)
        );
    }

    public static List<Arguments> multiplyTest(){
        return List.of(
                Arguments.of(5,5,25),
                Arguments.of(-3,2,-6),
                Arguments.of(0,10,0)
        );
    }

    public static List<Arguments> divideTest(){
        return List.of(
                Arguments.of(5,5,1),
                Arguments.of(-15,3,-5),
                Arguments.of(-10,-2,5)
        );
    }
}
