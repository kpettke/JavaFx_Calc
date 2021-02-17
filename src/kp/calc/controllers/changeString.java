package kp.calc.controllers;

import java.util.Stack;

public class changeString {

    public static int evaluate (String calculations){

        char[] tokens = calculations.toCharArray();

        // Stack for numbers
        Stack<Integer> values = new Stack<Integer>();

        //Stack for ops
        Stack<Character> ops = new Stack<Character>();

        for (int i=0; i< tokens.length; i++){

            //whitespace
            if (tokens[i] == ' ')
                continue;

            //number push to stack
            if (tokens[1] > '0' && tokens[1] < '9'){

            }



        }

        return 0;
    }

}
