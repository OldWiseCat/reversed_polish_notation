package com.company;

import java.util.Stack;

public class Solver implements SolverInterface {
    private Stack<Object> stack = new Stack<Object>();
    private Dictionary dict = new Dictionary();
    /**
     * Распарсенная строка
     */
    private String[] expression;

    //По хорошему, в данный метод надо бы добавить исключение FormatErrorException
    private static Integer performOperate(int operand2, String operation, int operand1) {
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

    public Solver(String expression, Dictionary Dict)
    {
        this.expression = expression.split(" ");
        dict = Dict;
    }

    public Solver(String[] expression, Dictionary Dict)
    {
        this.expression = expression;
        dict = Dict;
    }


    public void addDictionary(Dictionary Dictionary) {
        this.dict = Dictionary;
    }

    public Integer solve()
            throws EmptyLineException
    {
        if (expression.length == 0) {
            throw new EmptyLineException();
        }
        for (String arg: expression) {
            if (dict.containsKey(arg)) {
                stack.push(dict.get(arg));
            } else {
                if (arg.equals("-") || arg.equals("+")) {
                    while (stack.size() > 1) {
                        stack.push(performOperate((Integer) stack.pop(), (String) stack.pop(), (Integer) stack.pop()));
                    }
                    stack.push(arg);
                } else {
                    stack.push(arg);
                }
            }
        }
        while (stack.size() > 1) {
            stack.push(performOperate((Integer) stack.pop(), (String) stack.pop(), (Integer) stack.pop()));
        }
        return (Integer)stack.pop();
    }


    public static void main(String[] args) {
        //IX * VII - XX + XVII / II - XI
        //9 * 7 - 20 + 17 / 2 - 11
        /*1-I 2-II 3-III 4-IV 5-V 6-VI 7-VII 8-VIII 9-IX 10-X
        11-XI 12-XII 13-XIII 14-XIV 15-XV 16-XVI 17-XVII 18-XVIII
        19-XIX 20-XX*/
        Dictionary dict = new Dictionary();
        dict.put("I", 1);
        dict.put("IX", 9);
        dict.put("VII", 7);
        dict.put("XX", 20);
        dict.put("XVII", 17);
        dict.put("II", 2);
        dict.put("XI", 11);
        Solver slv = new Solver(args, dict);
        try {
            Integer result = slv.solve();
            System.out.println(result);
        } catch(EmptyLineException e) {
            System.out.println("Забыл выражение ввести");
            System.exit(-1);
        }
    }
}
