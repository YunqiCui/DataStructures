package com.cyunq.datastructures.stack.polandnotation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {

        //先定义逆波兰表达式
        //(30+4)*5-6  => 30 4 + 5 * 6 -
        //测试：4 * 5 - 8 + 60 + 8 / 2 => 4 5 * 8 - 60 + 8 2 / +
        //为了方便，逆波兰表达式的数字和符号用数字隔开
        String suffixExp = "30 4 + 5 * 6 -";
        String suffixExp2 = "4 5 * 8 - 60 + 8 2 / +";

        String expression = "1+((2+3)*4)-5";
        List<String> ls = toInfixExpressionList(expression);
        System.out.println("中缀表达式： " + ls);

        List<String> ls1 = parseSuffixExpressionList(ls);
        System.out.println("后缀表达式： " + ls1);

        //思路
        //1. 将(3+4)*5-6  => 3 4 + 5 * 6 - 放入ArrayList 中
        //2. 将ArrayList 传递给一个方法，配合栈 完成计算

//        List<String> rpnList = getListString(suffixExp2);
//        System.out.println("rpnList = " + rpnList);

//        int res = calculate(rpnList);
//        System.out.println("res = " + res);
    }

    //将逆波兰表达式的数据和运算符，一次放入ArrayList中
    public static List<String> getListString(String exp) {

        String[] split = exp.split(" ");
        List<String> list = new ArrayList<String>();
        Collections.addAll(list, split);
        return list;
    }

    //将中缀表达式转成对应的List
    //1+((2+3)*4)-5 ==> [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
    public static List<String> toInfixExpressionList(String s) {
        List<String> ls = new ArrayList<String>();
        int i = 0;
        String str;
        char ch;

        do {
            if ((ch = s.charAt(i)) < 48 || (ch = s.charAt(i)) > 57) {
                ls.add("" + ch);
                i++;
            } else {//考虑多位数的问题
                str = "";//现将String 置成空串
                while (i < s.length() && (ch = s.charAt(i)) >= 48 && (ch = s.charAt(i)) <= 57) {
                    str += ch;
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }

    //将中缀表达式List，转换成后缀表达式
    //[1, +, (, (, 2, +, 3, ), *, 4, ), -, 5] ==> [1,2,3,+,4,×,+,5,–]

    public static List<String> parseSuffixExpressionList(List<String> ls) {

        Stack<String> s1 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();

        for (String item : ls) {
            //1.如果是一个数就入栈
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
            } else {
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    //计算逆波兰表达式
    public static int calculate(List<String> list) {
        //创建栈，只需要一个栈即可
        Stack<String> stack = new Stack<String>();
        for (String item : list) {
            //使用正则表达式，取出数
            if (item.matches("\\d+")) {//匹配的是多位数
                stack.push(item);
            } else {
                //pop two numbers
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("Wrong operator!");
                }
                stack.push("" + res);
            }
        }
        return Integer.parseInt(stack.pop());
    }
}
