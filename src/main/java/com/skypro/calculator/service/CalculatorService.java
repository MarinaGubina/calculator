package com.skypro.calculator.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {

    public String welcome(){
        return "Добро пожаловать в калькулятор";
    }

    public int plus(int num1, int num2){
        return num1 + num2;
    }

    public int minus(int num1, int num2){
        return num1 - num2;
    }

    public int multiply(int num1, int num2){
        return num1*num2;
    }

    public double divide(int num1, int num2){
        if(num2 == 0){
            throw new IllegalArgumentException("Нельзя делить на ноль");
        }
        return num1/num2;
    }

}
