package com.cyunq.datastructures.stack.calculator;

public class Calculator {

    public static void main(String[] args) {
        int index = 0;//索引，用于扫描表达式
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';//将每次扫描得到的char 保存到ch
        String keepnumber = "";//用于拼接多位数

        String exp = "7*2*2-5+1-5+3-4";
        CalculatorStack numStack = new CalculatorStack(10);
        CalculatorStack operStack = new CalculatorStack(10);

        //扫描experession
        while (true) {
            //一次得到expression的每一个字符
            ch = exp.substring(index, index + 1).charAt(0);
            //判断ch是什么
            if (operStack.isOperation(ch)) {
                if (!operStack.isEmpty()) {
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                } //如果为空,或者加入的运算符优先级大于当前栈顶端运算符，直接入栈
            } else {
                //numStack.push(ch-48);//ch is '1' ch need to - 48
                //在处理数时，需要向exp的后面
                keepnumber += ch;

                if (index == exp.length() - 1) {
                    numStack.push(Integer.parseInt(keepnumber));
                }
                //判断下一个字符是不是数字
                else if (operStack.isOperation(exp.substring(index + 1, index + 2).charAt(0))) {
                    numStack.push(Integer.parseInt(keepnumber));
                    keepnumber = "";
                }
            }
            index++;
            //判断，是否扫描结束
            if (index >= exp.length()) {
                break;//扫描结束
            }
        }
        //进行计算
        while (true) {
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        int finalRes = numStack.pop();
        System.out.printf("表达式 %s = %d ", exp, finalRes);
    }
}
