package kp.calc.controllers;

import java.util.Stack;

public class changeString {

    public static int evaluate (String calculations){

        char[] tokens = calculations.toCharArray();

        // Stack for numbers
        Stack<Integer> values = new Stack<Integer>();

        //Stack for ops
        Stack<Character> ops = new Stack<Character>();

        for (int i=0; i <= tokens.length; i++) {

            //whitespace
            if (tokens[i] == ' ')
                continue;

            //number push to stack
            if (tokens[i] >= '0' && tokens[i] <= '9') {

                StringBuilder stringBuilder = new StringBuilder();
                // number with more digits
                while (i < tokens.length && tokens[i] >= '0' && tokens[i] <= '9')
                    stringBuilder.append(tokens[i++]);
                values.push(Integer.parseInt(stringBuilder.toString()));

            }
            //open brace, push to stack
            else if (tokens[i] == '(')
                ops.push(tokens[i]);

            else if (tokens[i] == ')') {
                while (ops.peek() != '(')
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));
                ops.pop();
            }

            // token is operator
            else if (tokens[i] == '+' || tokens[i] == '-' || tokens[i] == '*' || tokens[i] == '/') {

                while (!ops.empty() && hasPrecedence(tokens[i], ops.peek()))
                    values.push(applyOp(ops.pop(), values.pop(), values.pop()));

                //push to ops
                ops.push(tokens[i]);
            }
        }

            while (!ops.empty())
                values.push(applyOp(ops.pop(), values.pop(), values.pop()));

            return values.pop();

        }

        // return true if op2 has higher or same precedence than op1
        public static boolean hasPrecedence(char op1, char op2) {

        if (op2 == '(' || op2 == ')')
            return false;
        if ((op1 == '*' || op1 == '/') && (op2 == '+' || op2 == '-'))
            return false;
        else
            return true;

    }

    // apply operator and numbers
    public static int applyOp(char op, int b, int a){
        switch (op){
            case '+':
                return a+b;
            case '-':
                return a-b;
            case '*':
                return a*b;
            case '/':
                if (b==0)
                    new UnsupportedOperationException("Nie mozna dzielic przez 0");
                return a / b;

        }

        return 0;

    }



}
