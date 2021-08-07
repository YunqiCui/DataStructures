package com.cyunq.datastructures.stack.calculator;

import com.cyunq.datastructures.stack.array.ArrayStack;

public class CalculatorStack extends ArrayStack {

    /**
     * Constructor of class ArrayStack
     *
     * @param maxSize size of stack
     */
    public CalculatorStack(int maxSize) {
        super(maxSize);
    }

    /**
     * 返回运算符的优先级，数字越大，优先级越大
     *
     * @param oper operator
     * @return
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     *
     * @param val
     * @return check if char is operator
     */
    public boolean isOperation(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-';
    }
    /**
     *
     * @param num1 first number
     * @param num2 second number
     * @param oper operator
     * @return
     */
    public int cal(int num1, int num2, int oper) {
        int res = 0;

        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '/':
                res = num2 / num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            default:
                break;
        }
        return res;
    }
}
