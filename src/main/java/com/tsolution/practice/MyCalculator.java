package com.tsolution.practice;



public class MyCalculator {

private Calculator calculator;
private int firstNum;
private int secondNum;

public Calculator getCalculator() {
	return calculator;
}
public void setCalculator(Calculator calculator) {
	this.calculator = calculator;
}
public int getFirstNum() {
	return firstNum;
}
public void setFirstNum(int firstNum) {
	this.firstNum = firstNum;
}
public int getSecondNum() {
	return secondNum;
}
public void setSecondNum(int secondNum) {
	this.secondNum = secondNum;
}

public void add() {
	calculator.addition(firstNum, firstNum);
}

public void sub() {
	calculator.substraction(firstNum, firstNum);
}
public void mult() {
	calculator.multiplication(firstNum, firstNum);
}
public void div() {
	calculator.division(firstNum, firstNum);
}


}
