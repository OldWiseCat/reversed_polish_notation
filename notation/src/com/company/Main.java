package com.company;

import java.util.Stack;

public class Main {
    //По хорошему, в данный метод надо бы добавить исключение FormatErrorException
    private static Integer solve(int operand2, String operation, int operand1) {
        if (operation.equals("*")) {
            return(operand1 * operand2);
        }
        if (operation.equals("/")) {
            return(operand1 / operand2);
        }
        if (operation.equals("+")) {
            return(operand1 + operand2);
        }
        if (operation.equals("-")) {
            return(operand1 - operand2);
        }
        return 0;
    }
    private static final Stack<Object> stack = new Stack<Object>();
    private static final dictionary dict = new dictionary();


    public static void main(String[] args) {
        //IX * VII - XX + XVII / II - XI
        //9 * 7 - 20 + 17 / 2 - 11
        /*1-I 2-II 3-III 4-IV 5-V 6-VI 7-VII 8-VIII 9-IX 10-X
        11-XI 12-XII 13-XIII 14-XIV 15-XV 16-XVI 17-XVII 18-XVIII
        19-XIX 20-XX*/
        dict.put("I", 1);
        dict.put("IX", 9);
        dict.put("VII", 7);
        dict.put("XX", 20);
        dict.put("XVII", 17);
        dict.put("II", 2);
        dict.put("XI", 11);
        for (String arg: args) {
            if (dict.containsKey(arg)) {
                stack.push(dict.get(arg));
            } else {
                if (arg.equals("-") || arg.equals("+")) {
                    while (stack.size() > 1) {
                        stack.push(solve((Integer)stack.pop(),(String)stack.pop(), (Integer)stack.pop()));
                    }
                    stack.push(arg);
                } else {
                    stack.push(arg);
                }
            }
        }
        while (stack.size() > 1) {
            stack.push(solve((Integer)stack.pop(),(String)stack.pop(), (Integer)stack.pop()));
        }
        System.out.println(stack.pop());
	// write your code here
    }
}
