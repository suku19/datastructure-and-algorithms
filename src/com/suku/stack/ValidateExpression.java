package com.suku.stack;

import java.util.Stack;

/**
 * Checking validity of an expression containing nested parentheses
 * <p>
 * {s+b(9+8)[x+y]} - valid
 */
public class ValidateExpression {

    public static boolean validate(String exp) {
        Stack<Character> stack = new Stack<>();
        char[] elements = exp.toCharArray();

        for (char element : elements) {
            if (element == '(' || element == '{' || element == '[') {
                stack.push(element);
            } else if (element == ')' || element == '}' || element == ']') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char pop = stack.pop();
                    if (!((element == ')' && pop == '(') || (element == '}' && pop == '{') || (element == ']' && pop == '['))) {
                        return false;
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        String exp = "{s+b(9+8)[x+y]}";
        System.out.println(validate(exp));
    }
}
