package com.company;

import java.util.Stack;

public class Main {

    public static void main(String[] args) {
        Stack<Object> stack = new Stack<Object>();
        dictionary dict = new dictionary();
        //IX * VII - XX + XVII / II - XI
        /*1-I 2-II 3-III 4-IV 5-V 6-VI 7-VII 8-VIII 9-IX 10-X
        11-XI 12-XII 13-XIII 14-XIV 15-XV 16-XVI 17-XVII 18-XVIII
        19-XIX 20-XX*/
        dict.put(new String("I"), 1);
        dict.put(new String("IX"), 9);
        dict.put(new String("VII"), 7);
        dict.put(new String("XX"), 20);
        dict.put(new String("XVII"), 13);
        dict.put(new String("II"), 2);
        dict.put(new String("XI"), 11);
        int result;
        for (String arg: args) {
            if (dict.containsKey(arg)) {
                stack.push(dict.get(arg));
            } else {
                if (arg.equals("-") || arg.equals("+")) {
                    while (stack.size() > 1) {
                        Integer op1 = (Integer)stack.pop();
                        String operator = (String)stack.pop();
                        Integer op2 = (Integer)stack.pop();
                        if (operator.equals("*")) {
                            stack.push(op1 * op2);
                        }
                        if (operator.equals("/")) {
                            stack.push(op1 / op2);
                        }
                    }
                    stack.push(arg);
                } else {
                    stack.push(arg);
                }
            }
        }
        while (stack.size() > 1) {
            Integer op1 = (Integer)stack.pop();
            String operator = (String)stack.pop();
            Integer op2 = (Integer)stack.pop();
            if (operator.equals("+")) {
                stack.push(op1 + op2);
            }
            if (operator.equals("-")) {
                stack.push(op1 - op2);
            }
        }
        System.out.println(stack.pop());
	// write your code here
    }
}
